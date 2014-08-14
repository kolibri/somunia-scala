package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class AttackEffect(val actor: Battler, val target: Battler) extends Effect {
  def execute(): Unit = {
    target.stats("hp").current = target.stats("hp") - actor.stats("strength")

    println(actor.name + "hits " + target.name + " with " + actor.stats("strength").current)
  }
}
