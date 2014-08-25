package com.somunia.battle

/**
 * Created by kolibri on 14.08.14.
 */
class BattlerGroup(val members: List[Battler], val isPlayer: Boolean) {
  def this(members: List[Battler]) = this(members, false)

  def allDead: Boolean = {
    for (member <- this.members) {
      if (member.canAct) return false
    }
    true
  }

  def isMember(Battler: Battler): Boolean = {
    for (member <- this.members) {
      if (member == Battler) return true
    }
    false
  }

  def random: Battler = members.head // todo: not really random
}
