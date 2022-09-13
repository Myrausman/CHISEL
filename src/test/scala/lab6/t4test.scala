package lab6
import chisel3._
import org.scalatest._
import chiseltest._
class up_downcountertest extends FreeSpec with ChiselScalatestTester{
    "Counter Test t4" in {
        test(new up_down_counter()){ c =>
        c.io.up_down1.poke(0.B)
        c.clock.step(20)
        c.io.out.expect(1.B)
        }
    }
}