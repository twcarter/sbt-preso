import sbt.Keys._
import Dependencies._
import sbt.complete.DefaultParsers._


name := "multi"


lazy val commonSettings = Seq(	
	scalaVersion := "2.11.4",
	organization := "me.tcarter",
	version := "1.0",
	foo := "bar",
	hello := println( s"hello, ${foo.value}" ),
	libraryDependencies ++= libs ++ testLibs
)


/*
 *  Projects ...
 */
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
		description := "core project",
        libraryDependencies += akka
	)

lazy val util = project
	.settings(commonSettings: _*)
	.settings( 
		name := "utilities",
		description := "util project"
	)

