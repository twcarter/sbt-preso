import sbt._

object BuildSettings extends Build {
    
    // declar setting key
    lazy val foo   = settingKey[String]("foo key 2")
    
    // declare task key
    lazy val hello = taskKey[Unit]("say hello")




}