package Battle

/**
 * Created by kolibri on 14.08.14.
 */
class StatusValue(val max: Int, var current: Int) {
  def this(max: Int) = this(max, max)

  def -(value: StatusValue): Int = {
    if (0 < this.current - value.current)
      this.current - value.current
    else
      0
  }

  def +(value: StatusValue): Int = {
    if (this.max > this.current + value.current)
      this.current + value.current
    else
      this.max
  }
}
