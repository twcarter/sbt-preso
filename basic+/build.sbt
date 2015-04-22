import sbt.Keys._

// custom settings
lazy val foo     = settingKey[String]("foo key")

// custom tasks
lazy val hello   = taskKey[Unit]("hello task key")
lazy val goodbye = taskKey[Unit]("goodbye task key")



lazy val root = (project in file("."))
  .settings(
    name		 := "basic+",
    version 	 := "1.0",
    scalaVersion := "2.11.4",
    foo          := "bar"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"


hello   := println(s"hello, atlanta, let's go to a ${foo.value}")
goodbye := println(s"goodbye, atlanta, time to leave the ${foo.value}")



// add task dependency
goodbye <<= goodbye.dependsOn(hello)