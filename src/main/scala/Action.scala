package com.somunia.battle

class Action(val effect: Effect, val progress: Double) {
    def distanceTo(targetProgress: Double): Double = {
        if (targetProgress <= this.toEffect) return this.toEffect - targetProgress
        if (targetProgress <= this.toSelect) return this.toSelect - targetProgress
        0
    }

    val toEffect: Double = progress + effect.preparation
    val toSelect: Double = progress + effect.preparation + effect.cooldown
}