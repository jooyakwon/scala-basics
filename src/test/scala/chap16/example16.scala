package chap16

import org.scalatest.FunSuite

import scala.xml.{Atom, NodeSeq, Text}

/**
 * Created by kwonyoungjoo on 14. 11. 6..
 */
class example16 extends FunSuite{

  test("example 1 - xml parser test"){
      <fred/>(0)
  }

  test("example 2"){
      val data = <ul>
        <li>Opening bracket: [</li>
        <li>Closing bracket: ]</li>
        <li>Opening bracket: {{</li>
        <li>Closing bracket: }}</li>
      </ul>

    // {{ }} 하지 않으면 컴파일 에러남
  }

  def matchFunc(node:NodeSeq): String = {
    node match {
      case <li>{Text(t)}</li> => t
    }
  }

  test("example 3"){
    val src = <li>Fred</li>
    val des = <li>{"Fred"} </li>
    val des_atom = <li>{new Atom("Fred")} </li> //위에 데이터랑 같은 건가 ?

    assert( src != des )
    assert( des == des_atom )

    assertResult("Fred")( matchFunc(src))
    intercept[MatchError] {
      matchFunc(des) == "Fred"
    }


  }

}
