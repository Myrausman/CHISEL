package lab3
import chisel3._
import org.scalatest._
import chiseltest._
class validtest extends FreeSpec with ChiselScalatestTester{
    "mux3 Test" in {
        test(new decoder_with_valid()){ c=>
        c.io.in.poke(2.U)
        c.clock.step(1)
        c.io.out.bits.expect(4.U)
        c.io.out.valid.expect(1.B)
    }
}
}