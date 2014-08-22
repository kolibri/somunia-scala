package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class EventHandler(val actionFactory: ActionFactory) {
  def handle(someEvent: Option[Event]): Unit = someEvent match {

    case Some(event) => {
      println("BAR")
      println(event)
//      println(event.action.effect)
      event match {
        case event: ActionEvent => {

                println(event.action)
          event.action.effect.execute()
        }
        case event: CreateActionEvent => event.queue.action = this.actionFactory.createAction(event.battler)
      }
    }
    case None => {}
  }

  def canHandle(someEvent: Option[Event]): Boolean = someEvent match {
    case Some(event) => {
      event match {
        case event: ActionEvent => true
        case event: CreateActionEvent => true
        case _ => false
      }
    }
    case None => false
  }


}
