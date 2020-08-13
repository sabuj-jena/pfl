package com.logixal.pfl.core

trait SemiGroup[T] {
  //def (x: T ) combine(y: T): T
  def combine(x: T, y: T): T
}

trait Monoid[T] extends SemiGroup[T] {
  def unit: T
}

trait Functor[F[_]] {
  // def (functorA: F[A] ) map(f: A => B): F[B]
  def map[A,B](functorA: F[A])(f: A => B): F[B]
}

trait Monad[F[_]] {
  def unit[A](a: A): F[A]
  //def (monadA: F[A]) flatMap (f: A => B): F[B]
  def flatMap[A,B](monadA: F[A])(f: A => F[B]): F[B]
}

trait Semigroupal[F[_]] {
  def product[A,B](fa: F[A], fb: F[B]): F[(A,B)]
}

trait Apply[F[_]] extends Semigroupal[F] with Functor[F] {
  def ap[A,B](ff: F[A => B])(fa: F[A]) : F[B]

  override def product[A, B](fa: F[A], fb: F[B]): F[(A,B)] =
    ap(map(fa) (a => (b:B)=>(a,b)))(fb)
}

trait Applicative[F[_]] extends Apply[F] {
  def pure[A](a:A): F[A]
}