package lab1
import chisel3._
import org.scalatest._
import chiseltest._
class Counter_up_downtest extends FreeSpec with ChiselScalatestTester{
    "Counter Test" in {
        test(new counter_up_down(3)){ c =>
        

        c.clock.step(20)
        // c.io.out.expect(1.B)
        }
    }
}