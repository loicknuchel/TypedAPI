name := "TypedAPI"
// version := "0.1.0-SNAPSHOT" set by 'sbt-dynver' plugin, brought in by 'sbt-ci-release' plugin

// see https://www.scala-sbt.org/1.x/docs/Cross-Build.html
// can't build for 2.11 as doobie is no longer available for scala 2.11
scalaVersion := "2.12.13"
crossScalaVersions := List("2.12.13", "2.13.3")

// publishing informations
organization := "fr.loicknuchel"
homepage := Some(url("https://github.com/loicknuchel/TypedAPI"))
licenses += ("MIT", url("https://opensource.org/licenses/mit-license.php"))
developers := List(Developer("loicknuchel", "Loïc Knuchel", "loicknuchel@gmail.com", url("https://loicknuchel.fr")))
scmInfo := Some(ScmInfo(url("https://github.com/loicknuchel/TypedAPI"), "git@github.com:loicknuchel/TypedAPI.git"))

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.1.1",
  "com.typesafe.play" %% "play-json" % "2.9.1",
  "org.slf4j" % "slf4j-api" % "1.7.30",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scalatest" %% "scalatest" % "3.2.2" % Test)

// option added by addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.14")
// but as I have an unused import in generated file, I can't remove it and I can't ignore one package for this option :(
scalacOptions --= Seq("-Wunused:imports", "-Ywarn-unused:imports") // 2.13 and 2.12 options
scalacOptions --= Seq("-Xfatal-warnings") // removed as Extensions classes have warnings due to cross compile, need to find a way to handle them
