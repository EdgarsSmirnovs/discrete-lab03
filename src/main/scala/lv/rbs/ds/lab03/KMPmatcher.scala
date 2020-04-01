package lv.rbs.ds.lab03

import scala.collection.mutable.ListBuffer

class KMPmatcher(var pattern: String) {

  def getPrefixFun: List[Int] = {

    var listToReturn = new ListBuffer[Int]()
    val m = pattern.length
    var k = 0

    for (i <- 1 to m) {
      listToReturn += i
    }
    listToReturn(0) = -1
    listToReturn(1) = 0

    for (q <- 2 to m) {
      while (k > 0 && this.pattern(k) != this.pattern(q - 1)) {
        k = listToReturn(k)
      }
      if (this.pattern(k) == this.pattern(q - 1)) {
        k += 1
      }
      listToReturn(q) = k
    }
    listToReturn.toList
  }

  def findAllIn(text: CharSequence): Iterator[Int] = {

    var stringSearch = new ListBuffer[Int]()
    val textLength = text.length
    val prefixLength = this.pattern.length
    val f = getPrefixFun
    var k = 0

    for (i <- 0 until textLength) {
      while (k > 0 && this.pattern(k) != text.charAt(i)) {
        k = f(k)
      }
      if (this.pattern(k) == text.charAt(i)) {
        k += 1
      }
      if (k == prefixLength) {
        var printOut = i - prefixLength + 1
        println("Pattern appears with shift: " + printOut)
        stringSearch += printOut
        k = f(k)
      }
    }
    stringSearch.toList.iterator
  }
}

//  def toJson(text: CharSequence): String = {
//    val offsets = findAllIn(text)
//    val json: JValue = ("algorithm" -> "KMP") ~
//      ("pattern" -> pattern) ~
//      ("text" -> text.toString) ~
//      ("steps" -> {
//        for (number <- 1 until 3) {}
//      }
//  }
//}

