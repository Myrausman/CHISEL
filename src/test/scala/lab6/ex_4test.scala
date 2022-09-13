package lab6

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex4Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 6 Ex 4" in {
    test(new My_Queue) { c =>
      c.io.in.bits.poke(8.U)
      c.io.in.valid.poke(1.B)
      c.clock.step(20)
      c.io.out.ready.poke(1.B)
      c.io.out.bits.expect(8.U)
    }
  }

  }
