package lab1
import chisel3._
import org.scalatest._
import chiseltest._
class Counter3test extends FreeSpec with ChiselScalatestTester{
    "Counter3 Test" in {
        test(new Counter3(8,255)){ c =>
        c.clock.step(1)
        c.io.result.expect(0.B)
        }
    }
}