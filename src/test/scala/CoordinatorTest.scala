package com.somunia.battle

import org.scalatest.FunSuite

class CoordinatorTest extends FunSuite {
  val actionA = new Action(new Effect(3,4), 7)
  val competitorA  = new Competitor(actionA)
  val actionB = new Action(new Effect(8,2), 4)
  val competitorB  = new Competitor(actionB)
  val coordinator = new Coordinator(List(competitorA, competitorB))
 
  test("Coordinator tests") {
    var currentProgress = 0
    var current = coordinator.nextCompetitor(currentProgress)

    // order: a:10, b:12, a:1, b:10

    assert(current == competitorA)
    current.action.takeEffect()

    currentProgress = currentProgress + current.distanceTo(currentProgress)
    current = coordinator.nextCompetitor(currentProgress)
    assert(current == competitorB)

    current.action.takeEffect()
    currentProgress = currentProgress + current.distanceTo(currentProgress)
    current = coordinator.nextCompetitor(currentProgress)
    assert(current == competitorA, "currentProgress: " + currentProgress)

    //current.action.takeEffect()
    //currentProgress = currentProgress + current.distanceTo(currentProgress)
    //current = coordinator.nextCompetitor(currentProgress)
    //assert(current == competitorB, "currentProgress: " + currentProgress)


    current.action.takeEffect()
//    currentProgress = current.distanceTo(currentProgress)

//    assert(coordinator.distanceTo(0) == 10, "should be 10 is " + coordinator.distanceTo(0) == 10)
//    assert(coordinator.distanceTo(0) == 10, "should be 10 is " + coordinator.distanceTo(0) == 10)
  }
}

