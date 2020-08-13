object CatWorld extends App {
  println("Welcome to Category Theory")
  import com.logixal.pfl.core._
  import com.logixal.pfl.TypeclassInstances._
  def myMap(l: List[Int])(f: Int => List[String])(implicit lm: Monad[List]): List[String] = lm.flatMap(l)(f)

  def sum(l: List[Int])(implicit lm: Monoid[Int]): Int = l.reduce((x,y) => lm.combine(x,y))

  println(sum(List(1,2,3)))

  println(myMap(List(1,2,3,4))( x => List("sabuj")))
}