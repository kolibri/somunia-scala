import Battle._

object Somunia {
  /*
  class MultiEventQueue(val queues: List[BattlerEventQueue], val actionFactory: Battle.ActionFactory) {
    def hasEvent(progress: Int): Boolean = {
      for (queue: BattlerEventQueue <- this.queues)
        if (queue.hasEvent(progress)) return true
      false
    }

    def nextProgress(progress: Int) = {
      progress + 1 // Here is the increment
    }

    def event(progress: Int): Battle.Action = {
      for (queue: BattlerEventQueue <- this.queues)
        if (queue.hasEvent(progress)) return queue.event(progress)
      this.actionFactory.createFinishAction()
    }
  }

  class Director(val queue: MultiEventQueue, var progress: Int) {
    def nextEvent: Battle.Action = {
      this.progress = this.queue.nextProgress(this.progress)
      println("Progress: " + progress)
      this.queue.event(this.progress)
    }

    def hasEvent: Boolean = {
      this.queue.hasEvent(this.progress)
    }
  }

  class Battle(val Battle.BattlerManager: Battle.BattlerManager, val eventHandler: Battle.EventHandler, val director: Director) {

    def playRound(): Unit = {
      while (this.director.hasEvent) {
        //for (event <- this.queue.event if this.queue.hasEvent) {

        val event = this.director.nextEvent

        if (this.eventHandler.canHandle(event))
          this.eventHandler.handle(event)

        // Debug output
        for (group <- Battle.BattlerManager.groups)
          for (member <- group.members)
            println(member.name + ": HP: " + member.stats("hp").current + "/" + member.stats("hp").max)
      }
    }
  }
  */
  // ## // ## // ## // ## // ## // ## // ## // ## // ## // ##

  val player = new Battler("player", Map(
    "hp" -> new StatusValue(100),
    "mp" -> new StatusValue(50),
    "strength" -> new StatusValue(29),
    "magic" -> new StatusValue(7)
  ))

  val encounter = new Battler("encounter", Map(
    "hp" -> new StatusValue(100),
    "mp" -> new StatusValue(20),
    "strength" -> new StatusValue(19),
    "magic" -> new StatusValue(5)
  ))

  val players = new BattlerGroup(List(player), true)
  val encounters = new BattlerGroup(List(encounter))
  //
  //val eventHandler = new ActionEventHandler

  val BattlerManager = new BattlerManager(List(players, encounters))
  val actionFactory = new ActionFactory(BattlerManager)
  /*
  val playerEventQueue = new BattlerEventQueue(player, actionFactory)
  val encounterEventQueue = new BattlerEventQueue(encounter, actionFactory)
  val multiQueue = new MultiEventQueue(List(playerEventQueue, encounterEventQueue), actionFactory)

  val director = new Director(multiQueue, 0)

  val battle = new Battle(
    Battle.BattlerManager,
    eventHandler,
    director
  )

  println(player.name + ": HP: " + player.stats("hp").current + "/" + player.stats("hp").max)
  println(encounter.name + ":  HP: " + encounter.stats("hp").current + "/" + encounter.stats("hp").max)

  battle.playRound()
  */

  // Test for BattlerEventQueue
  val queue = new BattlerActionQueue(player)

  val eventHandler = new EventHandler(actionFactory)
  def main(args: Array[String]) {
    var next: Int = queue.nextEventProgress(queue.currentProgress)

    for (i <- 0 to 7) {
      val event = queue.getEvent(queue.nextEventProgress(queue.currentProgress))
      println(event)
      eventHandler.handle(event)
      println(player.name + ": " + player.stats("hp").current)
      println(encounter.name + ": " + encounter.stats("hp").current)
    }
  }
}
/*
Think about some kind of "environment" to keep game data like players, items, skills, animations, triggers, savegame etc.
This could be used by the Battle.EventHandler, and/or the handle methods could return an update for the environment
 */
