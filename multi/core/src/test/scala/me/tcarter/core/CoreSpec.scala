package me.tcarter.core 

import org.scalatest._

class CoreSpec extends FunSuite {

  test("smoke") {
    assert(true, "Smoke test passed")
  }

  test("name") {
  	assert (Core.name == "Core.name")
  }

}
