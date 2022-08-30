package gates
import chisel3._
import org.scalatest._
import chiseltest._
class Fulladdertest extends FreeSpec with ChiselScalatestTester{
    "Fulladder gate Test" in {
        test(new Fulladder()){ c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.io.cin.poke(1.S)
        c.clock.step(1)
        c.io.sum.expect(-8.S)
        c.io.cout.expect(-7.S)
        }
    }
}