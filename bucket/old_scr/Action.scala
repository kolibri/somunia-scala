package com.somunia.battle

/**
 * Created by kolibri on 14.08.14.
 */
class Action(val effect: Effect, val prep: Int, val cooldown: Int) {
  val preparation: Int = this.prep
  val duration: Int = this.preparation + this.cooldown
}
