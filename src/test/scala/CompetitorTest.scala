package com.somunia.battle

import org.scalatest.FunSuite

class CompetitorSuite extends FunSuite {
  val action = new Action(new Effect(3,4), 7)
  val competitor  = new Competitor(action)
 
  test("Competitor knows, if he needs an action") {
    assert(competitor.needsAction(14)   == false, "should be false, is "  + competitor.needsAction(14))
    assert(competitor.distanceTo(0)     == 10,  "should be '10', is "  + competitor.distanceTo( 0))
    assert(competitor.distanceTo(10)    == 0,   "should be '0',  is "   + competitor.distanceTo(10))

    var e = competitor.action.takeEffect()
    assert(competitor.distanceTo(10)    == 4,    "should be '4', is "   + competitor.distanceTo(10))
    assert(competitor.needsAction(14)   == true, "should be true, is "  + competitor.needsAction(14))
  }
}

