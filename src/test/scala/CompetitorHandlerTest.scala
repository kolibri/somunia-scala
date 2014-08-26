package com.somunia.battle

import org.scalatest.FunSuite

class CompetitorHandlerSuite extends FunSuite {
    test("CompetitorHandler assings new action to Competitor") {
        val handler = new CompetitorHandler

        val competitor = new Competitor(new Action(new Effect(3,1), 7))

        handler.handle(competitor, 0) 
    }
}