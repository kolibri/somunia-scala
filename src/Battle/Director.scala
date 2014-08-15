package Battle

/**
 * Created by kolibri on 15.08.14.
 */
class Director(val queue: MultiBattlerQueue, var progress: Int) {
  def nextEvent: Option[Event] = {
    queue.getEvent(this.progress)
  }

  def hasEvent: Boolean = {
    this.queue.hasEvent(this.progress)
  }
}
