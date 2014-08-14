package Battle

import scala.None

/**
 * Created by kolibri on 14.08.14.
 */
class BattlerActionQueue(val battler: Battler) {
  // TODO: move currentProgress and returnflag into action/event <- current progress only in director.
  var currentProgress: Int = 0
  var actionIsReturned: Boolean = false
  var action: Action = new Action(new WaitEffect, 0, 1)


  def getEvent(progress: Int): Option[Event] = {
    println("getEvent: pr" + progress + " cp: " + this.currentProgress + " ap:" + this.action.preparation + " ad: " + this.action.duration)

    if (!this.battler.canAct)
      None
    //    else if (progress == this.currentProgress + this.action.preparation) {
    else if (progress == this.currentProgress + this.action.preparation && !this.actionIsReturned) {
      //this.currentProgress = progress
      this.actionIsReturned = true

      new Some(new ActionEvent(this.action))
    }
    else if (progress == this.action.duration + this.currentProgress) {
      this.currentProgress = progress
      this.actionIsReturned = false

      new Some(new CreateActionEvent(this.battler, this))
    }
    else
      None
  }

  def hasEvent(progress: Int): Boolean = {
    if (!this.battler.canAct) return false
    if (progress == this.currentProgress) return false
    if (progress == this.action.preparation + this.currentProgress) return true
    if (progress == this.action.duration + this.currentProgress) return true
    false
  }

  def nextEventProgress(progress: Int): Int = {

    println("next: " + progress + " < " + (this.currentProgress + this.action.preparation))

    if (progress == this.currentProgress + this.action.preparation)
      progress

    if (progress < this.currentProgress + this.action.preparation && !this.actionIsReturned) {

      println("next: attack")

      return this.currentProgress + this.action.preparation
    }
    this.currentProgress + this.action.duration
  }
}
