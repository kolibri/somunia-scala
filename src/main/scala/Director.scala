package com.somunia.battle

class Director(val coordinator: Coordinator, val handler: CompetitorHandler) {
    var progress: Int = 0;

    // todo: this should return something like a board, a list of units, or something else with value
    def doTurn(): Unit = {
        var currentCoordinator = coordinator.nextCompetitor(progress)
        handler.handle(currentCoordinator, progress)

        progress = progress + currentCoordinator.distanceTo(progress)
    }
}