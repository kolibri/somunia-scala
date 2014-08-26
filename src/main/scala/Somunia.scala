package com.somunia

import com.somunia.battle

object Somunia {
  val actionA = new Action(new Effect(3,4), 7)
  val competitorA  = new Competitor(actionA)
  val actionB = new Action(new Effect(8,2), 4)
  val competitorB  = new Competitor(actionB)
  val coordinator = new Coordinator(List(competitorA, competitorB))
  val competitorHandler = new CompetitorHandler
  var director = new Director(coordinator, competitorHandler)

  def play = {
    // run game here
    director.doTurn()
  }

  def main(args: Array[String]) {
    println("Somunia game started.")
    play
    println("game over - bye! \\(^)>")
  }
}
/*
Think about some kind of "environment" to keep game data like players, items, skills, animations, triggers, savegame etc.
This could be used by the Battle.EventHandler, and/or the handle methods could return an update for the environment
 */
