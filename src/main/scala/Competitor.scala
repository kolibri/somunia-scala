package com.somunia.battle

class Competitor(var action: Action, val name: String) {
    def this(action: Action) = this(action, "Unnamed")
    def distanceTo(targetProgress: Int): Int = action.distanceTo(targetProgress)
    def needsAction(progress: Int) = (0 == action.distanceTo(progress) && false == action.effectIsNotTaken)
}