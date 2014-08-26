package com.somunia.battle

class Action(val effect: Effect, val progress: Int) {
    var effectIsNotTaken: Boolean = true

    def distanceTo(targetProgress: Int): Int = {
        if (effectIsNotTaken) {
            if (targetProgress <= this.toEffect) return this.toEffect - targetProgress
        } else {
            if (targetProgress <= this.toSelect) return this.toSelect - targetProgress
        }
        0
    }

    def takeEffect(): Effect = {
        effectIsNotTaken = false
        effect
    }

    val toEffect: Int = progress + effect.preparation
    val toSelect: Int = progress + effect.preparation + effect.cooldown
}