package com.somunia.battle

class Action(val effect: Effect, val progress: Int) {
    def distanceTo(targetProgress: Int): Int = {
        if (targetProgress <= this.toEffect) return this.toEffect - targetProgress
        if (targetProgress <= this.toSelect) return this.toSelect - targetProgress
        0
    }

    val toEffect: Int = progress + effect.preparation
    val toSelect: Int = progress + effect.preparation + effect.cooldown
}