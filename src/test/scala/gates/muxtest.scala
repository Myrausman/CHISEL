package gates
import chisel3._
import org.scalatest._
import chiseltest._
class muxtest extends FreeSpec with ChiselScalatestTester{
    "Multiplexer Test" in {
        test(new mux()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.sum.expect(-7.S)
        c.io.cout.expect(0.S)
        }
    }
}