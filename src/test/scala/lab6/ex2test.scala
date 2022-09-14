package lab6
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class l6ex2Tests extends FreeSpec with ChiselScalatestTester {
  "Lab 6 Ex 1" in {
    test(new countr(10)) { c =>
    //   c.io.in.poke("b1100".U)
      c.clock.step(20)
      c.io.out.expect(9.U)
    }
  }
}