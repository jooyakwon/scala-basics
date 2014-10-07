package chap09

import org.scalatest.FunSuite

import scala.io.Source

/**
 * Created by kwonyoungjoo on 14. 9. 17..
 */
class example09 extends FunSuite{

  class DoubleDataSet(fileName:String) {

    def readFile(fileName:String) {
      val data = Source.fromFile(fileName, "UTF-8")
      val lineIter = data.getLines

      for (line <- lineIter) println(line)
    }
  }


  test("DoubleDataSet test") {
    var fileName = "./test.log"
    var doubleDataSet = new DoubleDataSet(fileName)



  }
}






