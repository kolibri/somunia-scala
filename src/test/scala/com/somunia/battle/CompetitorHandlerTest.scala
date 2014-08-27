package com.somunia.battle

import org.scalatest.FunSuite

class CompetitorHandlerTest extends FunSuite {
    test("CompetitorHandler assings new action to Competitor") {
        val handler = new CompetitorHandler(new ActionHandler, new ActionCreator)

        val competitor = new Competitor(new Action(new Effect(3,1), 7))

        handler.handle(competitor, 0) 
    }
}