package com.somunia.battle

import org.scalatest.FunSuite

class DirectorTest extends FunSuite
{    
    test("Director tests") {
    }

  def assertRound(competitor: Competitor, name: String, progress: Int) = {
    assert(competitor.name == name)
  }
}
