package Battle

/**
 * Created by kolibri on 14.08.14.
 */
abstract class Effect {
  val cooldown: Int = 7

  def execute(): Unit
}
