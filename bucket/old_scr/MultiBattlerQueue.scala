package com.somunia.battle

/**
 * Created by kolibri on 15.08.14.
 */
class MultiBattlerQueue (val battlers: List[BattlerActionQueue]) {
  //require(battlers.count > 2)
  var currentProgress: Int = 0

  def getEvent(progress: Int): Option[Event] = {
    currentProgress = this.nextQueue(progress).nextEventProgress(progress)
    this.nextQueue(progress).getEvent(progress)
  }

  def hasEvent(progress: Int): Boolean = {
    for (queue: BattlerActionQueue <- this.battlers) {
      if (queue.hasEvent(progress)) return true
    }

    false
  }

  def nextEventProgress(progress: Int): Int = {
    this.nextQueue(progress).nextEventProgress(progress)
  }

  def nextQueue(progress: Int): BattlerActionQueue = {
    var queue: BattlerActionQueue = this.battlers.head

    for (currentQueue: BattlerActionQueue <- this.battlers) {
      if (currentQueue.nextEventProgress(progress) < queue.nextEventProgress(progress)) queue = currentQueue
    }

    queue
  }
}
