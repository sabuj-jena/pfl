package com.logixal.pfl

object TypeclassInstances {
  import com.logixal.pfl.core._
  //Monoids
  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def unit = 0
    override def combine(x:Int,y: Int) = x + y
  }
  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    override def unit = ""
    override def combine(x: String,y: String) = x + y
  }

  //Functors
  implicit val listFunctor: Functor[List] = new Functor[List]{
    override def map[A,B](listA: List[A])(f: A => B): List[B] =
      listA.map(f)
  }

  //Monads
  implicit val listMonad : Monad[List] = new Monad[List]{
    override def unit[A](a: A): List[A] = List(a)
    override def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] =
      l.flatMap(f)
  }
}