package com.somunia.battle

class CompetitorHandler {
    def handle(competitor: Competitor, progress: Int): Unit = {
        if (competitor.needsAction(progress))
            competitor.action = new Action(new Effect(3, 5), progress)
        else
            println("handle effect")
    }
}