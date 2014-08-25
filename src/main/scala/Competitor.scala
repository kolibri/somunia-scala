package com.somunia.battle

class Competitor(var action: Action) {
    def distanceTo(targetProgress: Double): Double = action.distanceTo(targetProgress)
}