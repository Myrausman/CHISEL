package lab3
import chisel3._
import org.scalatest._
import chiseltest._
class Muxtest extends FreeSpec with ChiselScalatestTester{
    "mux3 Test" in {
        test(new mux3()){ c=>
        c.io.in.poke(4.U)
        c.clock.step(1)
        c.io.out.expect(2.U)
    }
}
}