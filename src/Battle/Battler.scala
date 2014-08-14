package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class Battler(val name: String, val stats: Map[String, StatusValue]) {
  require(stats.contains("hp"))

  def canAct: Boolean = stats("hp").current > 0
}
