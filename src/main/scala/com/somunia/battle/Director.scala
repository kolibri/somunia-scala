package com.somunia.battle

class Director(val coordinator: Coordinator, val handler: CompetitorHandler) {
    var progress: Int = 0;

    // todo: this should return something like a board, a list of units, or something else with value
    def doTurn(): Unit = {
        val currentCoordinator = coordinator.nextCompetitor(progress)
        val newProgress = progress + currentCoordinator.distanceTo(progress)
        handler.handle(currentCoordinator, newProgress)

        progress = newProgress
    }
}