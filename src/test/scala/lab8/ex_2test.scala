package lab8
import chisel3._
import org.scalatest._
import chiseltest._
class l8e2test extends FreeSpec with ChiselScalatestTester{
    "lab8 e2 Test" in {
        test(new l8ex2()){ c =>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(2.U)
        c.io.mask(0).poke(1.B)
        c.io.mask(1).poke(1.B)
        c.io.dataIn(0).poke(2.U)
        c.io.dataIn(1).poke(3.U)
        c.clock.step(20)
        c.io.dataOut(0).expect(2.U)
        c.io.dataOut(1).expect(3.U)
        }
  }
}