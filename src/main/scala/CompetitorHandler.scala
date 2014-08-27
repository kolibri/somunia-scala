package com.somunia.battle

class CompetitorHandler(val actionHandler: ActionHandler) {
    def handle(competitor: Competitor, progress: Int): Unit = {
        if (competitor.needsAction(progress)) {

            competitor.action = new Action(new Effect(3, 5), progress)
            println("Choosed action")
            } else
            actionHandler.handle(competitor.action)
    }
}