package lab2
import chisel3._
import org.scalatest._
import chiseltest._
class Mux1test extends FreeSpec with ChiselScalatestTester{
    "mux1 Test" in {
        test(new Mux_2to1()){ c =>
        c.io.in_A.poke(5.U)
        c.io.in_B.poke(8.U)
        c.io.select.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(8.U)
        
        }
    }
}