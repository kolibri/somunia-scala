package com.somunia.battle

import org.scalatest._

class ActionSuite extends FunSuite with Matchers {
 
  test("Action can be initiliazed") {
    val effect = new Effect(3,1)
    val action = new Action(effect, 7)

    assert(action.effect      == effect)
    assert(action.progress    == 7)
    assert(action.toEffect    == 10)
    assert(action.toSelect    == 11)
  }

  test("Action can calulate progress no next event") {
    val effect = new Effect(3,1)
    val action = new Action(effect, 7)

    var progress = 0;

    progress = action.distanceTo(progress);
    progress should be (10)


//    assert(action.distanceTo(0) == 10)
//    assert(action.distanceTo(10) == 0) // Effect
//    action.distanceTo(10.1) should be (0.9)
//    assert(action.distanceTo(11) == 0) // Choose Action
//
//    assert(action.distanceTo(11.01) == 0) // Choose Action 
  }
}

