package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class EventHandler(val actionFactory: ActionFactory) {
  def handle(someEvent: Option[Event]) = someEvent match {
    case Some(event) => {
      event match {
        case event: ActionEvent => event.action.effect.execute()
        case event: CreateActionEvent => event.queue.action = this.actionFactory.createAction(event.battler)
      }
    }
    case None => {}
  }

}
