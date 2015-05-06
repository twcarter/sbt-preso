import sbt.Keys._
import complete.DefaultParsers._
import complete.Parser


// -----------------------------------------------------------------------
// BASIC STUFF
// -----------------------------------------------------------------------
name         := "basic+"
version      := "1.0"
scalaVersion := "2.11.4"

libraryDependencies += "com.typesafe.akka"  %  "akka" % "2.1.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % Test


// -----------------------------------------------------------------------
// Custom settings & tasks
// -----------------------------------------------------------------------

// Declare
lazy val foo     = settingKey[String]("foo key")
lazy val hello   = taskKey[Unit]("hello task key")
lazy val goodbye = taskKey[Unit]("goodbye task key")

// define
foo     := "bar"
hello   := println(s"hello, atlanta, let's go to a ${foo.value}")
goodbye := println(s"goodbye, atlanta, time to leave the ${foo.value}")


// add task dependency
goodbye <<= goodbye.dependsOn(hello)


// inputKey
lazy val demo = inputKey[Unit]("demo input task")
demo := {
  // get the result of parsing
  val args: Seq[String] = spaceDelimited("<args>").parsed
  println("The current Scala version is " + scalaVersion.value)
  println("The arguments to demo were:")
  args foreach println
}





lazy val showConfigurations = taskKey[Unit]("Shows all configurations")

lazy val inAnyProjectAndConfiguration = ScopeFilter(inAnyProject, inAnyConfiguration)

showConfigurations := {
  val configs = configuration.all(inAnyProjectAndConfiguration).value.toSet
  configs.filter(_.isPublic).foreach(c => println(s"${c.name} ${c.description}"))
}
