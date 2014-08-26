package com.somunia.battle

class Competitor(var action: Action) {
    def distanceTo(targetProgress: Int): Int = action.distanceTo(targetProgress)
}