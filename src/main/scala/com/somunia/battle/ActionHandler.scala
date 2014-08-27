package com.somunia.battle

class ActionHandler {
    def handle(action: Action): Unit = {
        val effect = action.takeEffect()
        println("Execute " + effect.text)
    }
}