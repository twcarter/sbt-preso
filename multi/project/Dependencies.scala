import sbt._

object Dependencies {

  lazy val versions = Map(
    "akka"       -> "2.1.4",
    "slick"      -> "2.1.0",
    "scalatest"  -> "2.1.6",
    "unfiltered" -> "0.8.0",
    "argonaut"   -> "6.0.4",
    "scalaz"     -> "7.0.6"
  )

  lazy val akka               = "com.typesafe.akka"  %  "akka" % versions("akka")
  lazy val slick              = "com.typesafe.slick" %% "slick" % versions("slick")  
  lazy val unfilteredFilter   = "net.databinder" %% "unfiltered-filter" % versions("unfiltered")
  lazy val unfilteredJetty    = "net.databinder" %% "unfiltered-jetty" %  versions("unfiltered")
  lazy val argonaut           = "io.argonaut" %% "argonaut" %  versions("argonaut")
  lazy val argonautUnfiltered = "io.argonaut" %% "argonaut-unfiltered" %  versions("argonaut")
  lazy val scalazCore         = "org.scalaz" %% "scalaz-core" % versions("scalaz")
    
  lazy val servletApi         = "javax.servlet" % "servlet-api" % "2.3" % "provided"

  lazy val scalatest          = "org.scalatest"  %% "scalatest" % versions("scalatest") % "test"

  lazy val testLibs   = Seq( scalatest )
    lazy val libs     = Seq( slick, scalazCore )
    lazy val weblibs  = Seq( argonaut, argonautUnfiltered, unfilteredJetty, unfilteredFilter, servletApi) ++ libs
}
