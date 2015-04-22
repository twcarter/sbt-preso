package me.tcarter

import me.tcarter.core.Core
import me.tcarter.util._

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, Atlanta ! ")
    println(Util.name)
    println(Core.name)
    println(Core.util)
  }
}