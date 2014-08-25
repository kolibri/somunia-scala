package com.somunia

import com.somunia.battle

object Somunia {
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

  val battlerManager = new BattlerManager(List(players, encounters))
  val actionFactory = new ActionFactory(battlerManager)

  // Test for BattlerEventQueue

  val playerQueue = new BattlerActionQueue(player)
  val encounterQueue = new BattlerActionQueue(encounter)
  val multiQueue = new MultiBattlerQueue(List(playerQueue, encounterQueue))

  val eventHandler = new EventHandler(actionFactory)

  val director = new Battle.Director(multiQueue, 0)

  val battle = new Battle(
    battlerManager,
    eventHandler,
    director
  )

  def main(args: Array[String]) {

    println(player.name + ": HP: " + player.stats("hp").current + "/" + player.stats("hp").max)
    println(encounter.name + ":  HP: " + encounter.stats("hp").current + "/" + encounter.stats("hp").max)

    battle.playRound()

    println(player.name + ": HP: " + player.stats("hp").current + "/" + player.stats("hp").max)
    println(encounter.name + ":  HP: " + encounter.stats("hp").current + "/" + encounter.stats("hp").max)

/*    var next: Int = multiQueue.nextEventProgress(multiQueue.currentProgress)

    for (i <- 0 to 7) {
      val event = multiQueue.getEvent(multiQueue.nextEventProgress(multiQueue.currentProgress))
      println(event)
      eventHandler.handle(event)
      println(player.name + ": " + player.stats("hp").current)
      println(encounter.name + ": " + encounter.stats("hp").current)
    }*/
  }
}
/*
Think about some kind of "environment" to keep game data like players, items, skills, animations, triggers, savegame etc.
This could be used by the Battle.EventHandler, and/or the handle methods could return an update for the environment
 */
