package Battle

/**
 * Created by kolibri on 14.08.14.
 */
/*
abstract class Battle.EventHandler() {
  def canHandle(event: Battle.Action): Boolean

  def handle(event: Battle.Action): Unit
}

class ActionEventHandler() extends Battle.EventHandler {
  def canHandle(event: Battle.Action): Boolean = true

  def handle(event: Battle.Action): Unit = event.execute()
}
*/
class ActionFactory(val battlerManager: BattlerManager) {
  def createAction(battler: Battler): Action = {
    println(battler.name + " -> " + battlerManager.enemiesOf(battler).random.name + "(2, 1)")
    new Action(new AttackEffect(battler, battlerManager.enemiesOf(battler).random), 2, 1)
  }
}
