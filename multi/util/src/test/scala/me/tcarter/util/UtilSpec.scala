package me.tcarter.util

import org.scalatest._

class UtilSpec extends FunSuite {

  test("smoke") {
    assert(true, "Smoke test passed")
  }

  test("name") {
  	assert (Util.name == "Util.name")
  }

}
