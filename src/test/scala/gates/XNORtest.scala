package gates
import chisel3._
import org.scalatest._
import chiseltest._
class XNORtest extends FreeSpec with ChiselScalatestTester{
    "xnor gate Test" in {
        test(new XNOR()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.c.expect(6.S)
        }
    }
}