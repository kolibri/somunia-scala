package com.somunia.battle

import org.scalatest.FunSuite

class EffectSuite extends FunSuite {
    test("Effect can be initialized") {
        val effect = new Effect(3, 1)

        assert(effect.preparation == 3)
        assert(effect.cooldown    == 1)
    }
}