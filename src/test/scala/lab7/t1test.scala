package lab7
import chisel3._
import org.scalatest._
import chiseltest._
class l7t1test extends FreeSpec with ChiselScalatestTester{
    "lab7 t1 Test" in {
        test(new task1()){ c =>
            c.io.f1.poke(1.B)
            c.io.f2.poke(0.B)
            c.io.r1.poke(0.B)
            c.io.r2.poke(0.B)
            c.clock.step(18)
            c.io.out.expect(3.U)
        }
    }}