package com.somunia.battle

class Competitor(var action: Action) {
    def distanceTo(targetProgress: Int): Int = action.distanceTo(targetProgress)
    def needsAction(progress: Int) = (0 == action.distanceTo(progress) && false == action.effectIsNotTaken)
}