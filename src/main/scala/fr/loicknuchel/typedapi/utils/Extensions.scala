package fr.loicknuchel.typedapi.utils

import cats.data.NonEmptyList

import scala.collection.generic.CanBuildFrom
import scala.collection.mutable

object Extensions {

  implicit class RichOption[A](val in: Option[A]) extends AnyVal {
    def toEither[E](e: => E): Either[E, A] = in match {
      case Some(v) => Right(v)
      case None => Left(e)
    }
  }

  implicit class RichOptionEither[A, E](val in: Option[Either[E, A]]) extends AnyVal {
    def sequence: Either[E, Option[A]] = in match {
      case Some(Right(a)) => Right(Some(a))
      case Some(Left(e)) => Left(e)
      case None => Right(None)
    }
  }

  implicit class RichTraversableOnce[A, M[X] <: TraversableOnce[X]](val in: M[A]) extends AnyVal {
    def toNel: Either[IllegalArgumentException, NonEmptyList[A]] =
      NonEmptyList.fromList(in.toList).toEither(new IllegalArgumentException("List should not be empty"))
  }

  implicit class RichTraversableOnceOption[A, M[X] <: TraversableOnce[X]](val in: M[Option[A]]) extends AnyVal {
    def sequence(implicit cbf: CanBuildFrom[M[Option[A]], A, M[A]]): Option[M[A]] = {
      val init = Option(cbf(in))
      in.foldLeft(init) { (acc, cur) =>
        acc.flatMap { results =>
          cur.map { result => results += result }
        }
      }.map(_.result())
    }
  }

  implicit class RichTraversableOnceEither[E, A, M[X] <: TraversableOnce[X]](val in: M[Either[E, A]]) extends AnyVal {
    def sequence(implicit cbf: CanBuildFrom[M[Either[E, A]], A, M[A]]): Either[E, M[A]] = {
      val init = cbf(in) -> List.empty[E]
      sequenceResultEither[E, A, M](in.foldLeft(init) { (acc, cur) =>
        val (results, errors) = acc
        cur match {
          case Right(result) => (results += result, errors)
          case Left(error) => (results, error +: errors)
        }
      }).left.map(_.head)
    }
  }

  private def sequenceResultEither[E, A, M[X] <: TraversableOnce[X]](in: (mutable.Builder[A, M[A]], List[E])): Either[NonEmptyList[E], M[A]] = {
    val (results, errors) = in
    errors.reverse.toNel.swap.map(_ => results.result())
  }
}
