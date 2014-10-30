package chap15

import org.scalatest.FunSuite

/**
 * Created by kwonyoungjoo on 14. 10. 30..
 */

import scala.io.Source
import java.io.IOException

class example15 extends FunSuite{

  /*
  파일의 모든 줄은 포함하고 있는 문자열을 리턴하는 스칼라 메소드를 작성하라 이름 자바에서 호출 하라
   */
}

object example15{

  @throws(classOf[IOException])
  def readAll(filename:String) = Source.fromURL(getClass.getResource(filename)).mkString
}

