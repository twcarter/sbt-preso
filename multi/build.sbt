import sbt.Keys._
import Dependencies._
import sbt.complete.DefaultParsers._

//import BuildSettings._

name := "multi"


lazy val commonSettings = Seq(	
	scalaVersion := "2.11.4",
	organization := "me.tcarter",
	version := "1.0",
	foo := "bar",
	hello := println( s"hello, ${foo.value}" ),
	libraryDependencies ++= libs ++ testLibs
)

lazy val root = (project in file("."))
	.dependsOn(core,util)
	.aggregate(core,util)
	.settings(commonSettings: _*)
	.settings( 
		description := "root project"
	)

lazy val core = project 
	.dependsOn(util)
	.settings(commonSettings: _*)
	.settings(	
		foo := "baz",	
		description := "core project"
	)

lazy val util = project
	.settings(commonSettings: _*)
	.settings( 
		name := "utilities",
		description := "util project"
	)

//lazy val demo = inputKey[Unit]("demo input key")
//demo := {
//	// get the result of parsing
//	val args: Seq[String] = spaceDelimited("<arg>").parsed
//	// Here, we also use the value of the `scalaVersion` setting
//	println("The current Scala version is " + scalaVersion.value)
//	println("The arguments to demo were:")
//	args foreach println
//}