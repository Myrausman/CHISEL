package lab6
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class l6e1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 6 Ex 1" in {
    test(new l6ex1) { c =>
      c.io.in.poke("b1100".U)
      c.clock.step(20)
      c.io.out.expect(0.B)
    }
  }
}