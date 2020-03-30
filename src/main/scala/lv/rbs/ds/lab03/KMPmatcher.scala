package lv.rbs.ds.lab03

import scala.collection.mutable.ListBuffer

class KMPmatcher(var pattern: String) {

  var listToReturn = new ListBuffer[Int]()

  def getPrefixFun: List[Int] = {

    val m = pattern.length
    var k = 0

    for (i <- 1 to m) {
      listToReturn += i
    }
    listToReturn(0) = -1
    listToReturn(1) = 0

    for (q <- 2 to m) {
      while (k > 0 && this.pattern(k) != this.pattern(q-1)) {
        k = listToReturn(k)
      }
      if (this.pattern(k) == this.pattern(q-1)) {
        k += 1
      }
      listToReturn(q) = k
    }
    listToReturn.toList
  }

  def findAllIn(text: CharSequence): Iterator[Int] = {
    val newText = "DEMO"
    listToReturn.iterator
  }

  def toJson(text: CharSequence): String = {
    ""
  }

}
