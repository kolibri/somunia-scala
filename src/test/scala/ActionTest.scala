package com.somunia.battle

import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory

class BattleSuite extends FunSuite with MockFactory {
 
  test("Action can be initiliazed") {
    val effect = mock[Effect]
    val action = new Action(effect, 1, 1.5, 2)

    assert(action.effect      == effect)
    assert(action.progress    == 1)
    assert(action.preparation == 1.5)
    assert(action.cooldown    == 2)
  }
}

