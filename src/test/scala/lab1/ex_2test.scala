package lab1
import chisel3._
import org.scalatest._
import chiseltest._
class Counter2test extends FreeSpec with ChiselScalatestTester{
    "Counter Test" in {
        test(new Counter2()){ c =>
        // c.io.counterBits.poke(3.U)
        c.clock.step(1)
        c.io.result.expect(1.B)
        }
    }
}