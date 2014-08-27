package com.somunia.battle

class ActionCreator {
  def createFor(competitor: Competitor, progress: Int): Action = {
    new Action(new Effect(3, 5), progress)
  }
}
