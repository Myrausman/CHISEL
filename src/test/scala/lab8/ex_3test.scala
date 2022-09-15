package lab8
import chisel3._
import org.scalatest._
import chiseltest._
class l8e3test extends FreeSpec with ChiselScalatestTester{
    "lab8 e3 Test" in {
        test(new l8ex3()){ c =>
        c.io.write.poke(1.B)
        c.io.instWr.poke(7.U)
        c.io.addr.poke(10.U)
        c.clock.step(5)
        c.io.instRead.expect(7.U)
        c.io.instWr.poke(8.U)
        c.io.addr.poke(11.U)
        c.clock.step(5)
        c.io.instRead.expect(8.U)
        }
    }
}