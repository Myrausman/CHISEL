package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class l5t3test extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Task 3" in {
    test(new eMuxt3(UInt(16.W), UInt(16.W))) { c =>
      c.io.in1.poke(10.U)
      c.io.in2.poke(20.U)
      c.io.sel.poke(1.B)
      c.io.out.expect(10.U)
    }
  }
}