package lab2
import chisel3._
import org.scalatest._
import chiseltest._
class Mux4test extends FreeSpec with ChiselScalatestTester{
    "task1 Test" in {
        test(new Mux_5to1 ()){ c=>
        c.io.s0.poke(1.B)
        c.io.s1.poke(1.B)
        c.io.s2.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(24.U)
    }
}
}