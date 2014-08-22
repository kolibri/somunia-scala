package Battle

/**
 * Created by kolibri on 15.08.14.
 */
class Director(val queue: MultiBattlerQueue, var progress: Int) {
  def nextEvent: Option[Event] = {
    val newProgress = this.queue.nextEventProgress(progress)
    val event = queue.getEvent(progress)
    progress = newProgress

    event
  }

  def hasEvent: Boolean = {
    true
//    this.queue.hasEvent(this.progress)
  }
}
