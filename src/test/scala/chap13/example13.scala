package chap13

import org.scalatest.FunSuite

/**
 * Created by kwonyoungjoo on 2014. 10. 7..
 */
class example13 extends FunSuite{

  /* exampl 6 */
  val lst = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  test("compare list"){
    assert( (lst :\ List[Int]())(_ :: _) == (lst :\ List[Int]())(_ +: _) )
  }

  test("reverse test"){
     //assert(lst.reduceLeft(_-_) == lst.foldLeft(0)(_-_)) // 0- vs 1-
     //assert(lst.reduceLeft(_+_) == lst.foldLeft(0)(_+_))
     assert((0 /: lst)(_-_) == lst.foldLeft(0)(_-_))
     assert(( List[Int]() /: lst)( (lst, elem) => elem :: lst) == lst.reverse)
   }

  /* exampl 7 */
  def mulOneParam(x:Int) =  (y: Int) => x * y

  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  test("zipping"){
    val zippedList = (prices zip quantities)
    val mulList = zippedList map { p => p._1 * p._2}

    assert( (prices zip quantities) == List( (5.0, 10), (20.0, 2), (9.95, 1) ) )
    assert( ( (prices zip quantities ) map ((_:Double) * (_:Int) ).tupled ) == mulList )

    Map(1 -> "one", 2 -> "two") map ((_: Int) -> (_: String).length).tupled

  }



}
