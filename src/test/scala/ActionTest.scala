package com.somunia.battle

import org.scalatest._

class ActionSuite extends FunSuite {
    val effect = new Effect(3,4)
    val action = new Action(effect, 7)
 
  test("Action can be initiliazed") {
    assert(action.effect      == effect)
    assert(action.progress    == 7)
    assert(action.toEffect    == 10)
    assert(action.toSelect    == 14)
  }

  test("Action can calulate progress no next event") {
    // Effect
    assert(action.distanceTo(0)     == 10,  "should be '10', is "  + action.distanceTo( 0))
    assert(action.distanceTo(10)    == 0,   "should be '0', is "   + action.distanceTo(10))
    assert(action.distanceTo(11)    == 0,   "should be '0', is "   + action.distanceTo(11))
    assert(action.distanceTo(14)    == 0,   "should be '0', is "   + action.distanceTo(14))

    var e = action.takeEffect()

    assert(action.distanceTo(10)    == 4,   "should be '4', is "   + action.distanceTo(10))
    //assert(action.distanceTo(10)    == 0,   "should be '4', is "   + action.distanceTo(10))
    // Choose Action
    assert(action.distanceTo(11)    == 3,   "should be '3', is "   + action.distanceTo(11))
    assert(action.distanceTo(12)    == 2,   "should be '2', is "   + action.distanceTo(12))
    // Choose Action 
    assert(action.distanceTo(14)    == 0,   "should be '0', is "   + action.distanceTo(14))
    assert(action.distanceTo(15)    == 0,   "should be '0', is "   + action.distanceTo(15))
    assert(action.distanceTo(43)    == 0,   "should be '0', is "   + action.distanceTo(43))
  }
}

