package com.somunia.battle

class CompetitorHandler(val actionHandler: ActionHandler) {
    def handle(competitor: Competitor, progress: Int): Unit = {
        if (competitor.needsAction(progress)) {
            println("Attach new action")
            val oldAction = competitor.action
            competitor.action = new Action(new Effect(3, 5), progress + oldAction.distanceTo(progress))
        } else {
            actionHandler.handle(competitor.action)
        }
    }
}