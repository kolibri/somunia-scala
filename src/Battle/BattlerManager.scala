package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class BattlerManager(val groups: List[BattlerGroup]) {
  def enemiesOf(Battler: Battler): BattlerGroup = {
    for (group <- this.groups if !group.isMember(Battler)) {
      return group
    }
    this.groups.head
  }
}
