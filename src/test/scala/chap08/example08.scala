package chap08

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

/**
 * Created by kwonyoungjoo on 14. 9. 17..
 */
class example08 extends FunSuite{

  abstract class Item{
    def price:Double
    def description:String
  }

  class SimpleItem(val price:Double, val description:String) extends Item

  class Bundle extends Item{
    private val items = ArrayBuffer[Item]()

    def addItem(item:Item){
      this.items += item
    }

    def price = {
      var sumPrice:Double = 0 ;
      for(item <- items) { sumPrice += item.price }

      sumPrice
    }

    def description = {
      (for(item <- this.items) yield item.description).mkString("[", "-", "]")
    }
  }

  test("extends test"){
    val firstItem = new SimpleItem(100.0, "first Item")
    val secondItem = new SimpleItem(200.0, "second Item")
    val thirdItem = new SimpleItem(300.0, "third Item")

    val bundle = new Bundle
    bundle.addItem(firstItem)
    bundle.addItem(secondItem)
    bundle.addItem(thirdItem)

    assertResult(600.0)(bundle.price)
    assertResult("[first Item-second Item-third Item]")( bundle.description)
  }

}
