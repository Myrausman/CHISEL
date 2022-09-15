package lab7
import chisel3._
import org.scalatest._
import chiseltest._
class l7e1test extends FreeSpec with ChiselScalatestTester{
    "lab7 e1 Test" in {
        test(new ex1()){ c =>
        c.io.in1.bits.poke(1.U)
        c.io.in1.valid.poke(1.B)
        c.io.in2.bits.poke(2.U)
        c.io.in2.valid.poke(1.B)
        c.io.in3.bits.poke(3.U)
        c.io.in3.valid.poke(1.B)
        c.clock.step(7)
        c.io.out.bits.expect(3.U)
        c.clock.step(5)
        c.io.in1.bits.poke(5.U)
        c.io.in1.valid.poke(1.B)
        c.io.in2.bits.poke(4.U)
        c.clock.step(5)

        c.io.out.bits.expect(3.U)
    }
}
}