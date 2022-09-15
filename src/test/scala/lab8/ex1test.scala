package lab8
import chisel3._
import org.scalatest._
import chiseltest._
class l8e1test extends FreeSpec with ChiselScalatestTester{
    "lab8 e1 Test" in {
        test(new l8ex1()){ c =>
        c.io.dataIn(0).poke(15.U)
        c.io.dataIn(1).poke(7.U)
        c.io.dataIn(2).poke(10.U)
        c.io.dataIn(3).poke(99.U)
        c.io.addr.poke(3.U)
        c.io.enable.poke(true.B)
        c.io.write.poke(1.B)
        c.io.mask(0).poke(0.B)
        c.io.mask(1).poke(1.B)
        c.io.mask(2).poke(0.B)
        c.io.mask(3).poke(0.B)
        c.clock.step(20)
        }
  }
}