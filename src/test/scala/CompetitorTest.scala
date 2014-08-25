package com.somunia.battle

import org.scalatest.FunSuite

class CompetitorSuite extends FunSuite {
 
  test("Competitor can be initiliazed") {
    val action = new Action(new Effect(0,0), 0)
    val competitor  = new Competitor(action)

    assert(competitor.distanceTo(0) == 0)
    assert(competitor.distanceTo(3) == 0)
  }
}

