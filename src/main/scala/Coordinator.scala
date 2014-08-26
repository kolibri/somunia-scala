package com.somunia.battle

class Coordinator(val competitors: List[Competitor]) {
    def nextCompetitor(progress: Int): Competitor = {
        var competitor = competitors.head
        for (current: Competitor <- competitors) {
            if (current.distanceTo(progress) < competitor.distanceTo(progress)) competitor = current
        }

        if (competitor.needsAction(progress)) {
            competitor.action = new Action(new Effect(3, 5), progress)
            competitor = nextCompetitor(progress)
        }
        competitor
    }
}