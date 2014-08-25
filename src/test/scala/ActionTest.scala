package com.somunia.battle

import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory

class ActionSuite extends FunSuite with MockFactory {
 
  test("Action can be initiliazed") {
    val effect = mock[Effect]
    val action = new Action(effect, 1, 1.5, 2)

    assert(action.effect      == effect)
    assert(action.progress    == 1)
    assert(action.preparation == 1.5)
    assert(action.cooldown    == 2)
    assert(action.toEffect    == 2.5)
    assert(action.toSelect    == 4.5)
  }

  test("Action can calulate progress no next event") {
    val effect = mock[Effect]
    val action = new Action(effect, 1, 1.5, 2)

    assert(action.distanceTo(0) == 2.5)
    assert(action.distanceTo(2.5) == 0) // Effect

    assert(action.distanceTo(2.6) == 1.9) 
    assert(action.distanceTo(4.5) == 0) // Choose Action

    assert(action.distanceTo(5) == 0) // Choose Action 
  }
}

