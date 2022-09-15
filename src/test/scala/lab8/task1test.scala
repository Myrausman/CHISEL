package lab8
import chisel3._
import org.scalatest._
import chiseltest._
class l8t1test extends FreeSpec with ChiselScalatestTester{
    "lab8 t1 Test" in {
        test(new memory_assignment()){ c =>
        c.clock.step(2)
        c.io.requestor(0).bits.poke(2.U)
        c.io.requestor(1).bits.poke(4.U)
        c.io.requestor(2).bits.poke(6.U)
        c.io.requestor(3).bits.poke(3.U)
        c.io.requestor(0).valid.poke(1.B)
        c.io.requestor(1).valid.poke(0.B)
        c.io.requestor(2).valid.poke(0.B)
        c.io.requestor(3).valid.poke(0.B)
        c.io.Readaddr.poke(5.U)
        c.io.Writeaddr.poke(5.U)
        c.clock.step(20)
        
        }
    }
}