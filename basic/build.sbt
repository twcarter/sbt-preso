import sbt._
import complete.DefaultParsers._
import complete.Parser

name := """basic"""

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"



lazy val demo = inputKey[Unit]("demo input task")

demo := {
  // get the result of parsing
  val args: Seq[String] = spaceDelimited("<args>").parsed
  println("The current Scala version is " + scalaVersion.value)
  println("The arguments to demo were:")
  args foreach println
}
