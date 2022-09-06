package gates
import chisel3._
import org.scalatest._
import chiseltest._
class muxtest extends FreeSpec with ChiselScalatestTester{
    "Multiplexer Test" in {
        test(new mux()){ c=>
        c.io.in1.poke(8.S)
        c.io.in2.poke(-15.S)
        c.io.sel.poke(3.U)
        c.clock.step(1)
        c.io.out.expect(-7.S)
        
        }
    }
}