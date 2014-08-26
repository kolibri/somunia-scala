package com.somunia.battle

class Coordinator(val competitors: List[Competitor]) {
    def nextCompetitor(progress: Int): Competitor = {
        var competitor = competitors.head
        for (current: Competitor <- competitors) {
            if (current.distanceTo(progress) < competitor.distanceTo(progress)) competitor = current
        }
        competitor
    }
}