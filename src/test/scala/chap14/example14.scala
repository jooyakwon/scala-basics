package chap14

import org.scalatest.FunSuite

/**
 * Created by kwonyoungjoo on 2014. 10. 14..
 */

class example14 extends FunSuite{

  /*
  연습 문제 2
  */
  def swap(t:(Int, Int)): (Int, Int) ={
    t match {
      case (x, y) => (y, x)
    }
  }

  test("swap int tuple"){
    val t = (1,9)
    val swap_t = (9, 1)

    assertResult(swap_t)(swap(t))
  }

  /*
  연습 문제 4
  */
  abstract class Item

  case class Product(desc:String, price:Double) extends Item
  case class Bundle(desc:String, items:List[Item]) extends Item
  case class Multiple(count:Int, items:Item) extends Item

  def price(item:Item) :Double ={
    var sum = 0.0
    item match{
      case Product(_,price) => price
      case Bundle(desc,items) => for (tmp <- items)  sum += price(tmp); sum
      case Multiple(count, item) => count * price(item)
    }
  }

  test(" case class "){
    val product1 = Product("body", 100.0)
    val product2 = Product("lenz", 80.0)
    val bundle = Bundle("body+lenz", List(product1, product2))
    val multiple = Multiple(10, product1)

    assertResult(100.0)(price(product1))
    assertResult(180.0)(price(bundle))
    assertResult(1000.0)(price(multiple))
  }

}
