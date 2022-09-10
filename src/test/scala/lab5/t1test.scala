package lab5
import chisel3._
import org.scalatest._
import chiseltest._
class l5t1test extends FreeSpec with ChiselScalatestTester{
    "lab5 Test" in {
        test(new Addr(4)){ c =>
        c.io.in_0.poke(2.U)
        c.io.in_1.poke(1.U)
        c.clock.step(3)
        c.io.sum.expect(3.U)
    }
}
}