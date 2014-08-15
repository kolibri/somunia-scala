package Battle

/**
 * Created by kolibri on 15.08.14.
 */
class Battle(val BattlerManager: BattlerManager, val eventHandler: EventHandler, val director: Director) {

  def playRound(): Unit = {
    while (this.director.hasEvent) {
      //for (event <- this.queue.event if this.queue.hasEvent) {

      val event = this.director.nextEvent

      if (this.eventHandler.canHandle(event))
        this.eventHandler.handle(event)

      // Debug output
      for (group <- BattlerManager.groups)
        for (member <- group.members)
          println(member.name + ": HP: " + member.stats("hp").current + "/" + member.stats("hp").max)
    }
  }
}
