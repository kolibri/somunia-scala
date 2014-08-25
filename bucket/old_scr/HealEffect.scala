package com.somunia.battle

/**
 * Created by kolibri on 14.08.14.
 */
class HealEffect(val actor: Battler, val target: Battler) extends Effect {
  def execute(): Unit = {
    target.stats("hp").current = target.stats("hp") + actor.stats("magic")
    actor.stats("mp").current = actor.stats("mp") - actor.stats("magic")

    println(actor.name + "heals " + target.name + " with " + actor.stats("strength").current)
  }
}
