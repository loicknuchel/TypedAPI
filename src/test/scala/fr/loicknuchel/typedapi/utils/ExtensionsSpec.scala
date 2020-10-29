package fr.loicknuchel.typedapi.utils

import cats.data.NonEmptyList
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import fr.loicknuchel.typedapi.utils.Extensions._

class ExtensionsSpec extends BaseSpec {
  describe("Extensions") {
    describe("RichOption") {
      it("should transform to Either") {
        Option(1).toEither("2") shouldBe Right(1)
        Option.empty[Int].toEither("2") shouldBe Left("2")
        Option(1).toEither(throw new Exception) shouldBe Right(1) // lazy param
      }
    }
    describe("RichOptionEither") {
      it("should reverse monads") {
        Option[Either[String, Int]](Right(1)).sequence shouldBe Right(Some(1))
        Option[Either[String, Int]](Left("1")).sequence shouldBe Left("1")
        Option.empty[Either[String, Int]].sequence shouldBe Right(None)
      }
    }
    describe("RichTraversableOnce") {
      it("should transform to NonEmptyList") {
        Seq().toNel shouldBe a[Left[_, _]]
        Seq(1).toNel shouldBe Right(NonEmptyList.of(1))
      }
    }
    describe("RichTraversableOnceOption") {
      it("should reverse monads") {
        Seq(Option(1), Option(2), Option(3)).sequence shouldBe Some(Seq(1, 2, 3))
        Seq(Option(1), Option.empty[Int], Option(3)).sequence shouldBe None
        Seq(Option(1), Option.empty[Int], Option.empty[Int]).sequence shouldBe None
      }
    }
    describe("RichTraversableOnceEither") {
      it("should reverse monads") {
        Seq(Either.cond(test = true, 1, "1"), Either.cond(test = true, 2, "2"), Either.cond(test = true, 3, "3")).sequence shouldBe Right(Seq(1, 2, 3))
        Seq(Either.cond(test = true, 1, "1"), Either.cond(test = false, 2, "2"), Either.cond(test = true, 3, "3")).sequence shouldBe Left("2")
        Seq(Either.cond(test = true, 1, "1"), Either.cond(test = false, 2, "2"), Either.cond(test = false, 3, "3")).sequence shouldBe Left("2")
      }
    }
  }
}
