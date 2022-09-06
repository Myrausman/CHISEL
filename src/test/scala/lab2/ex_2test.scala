package lab2
import chisel3._
import org.scalatest._
import chiseltest._
class Muxtest extends FreeSpec with ChiselScalatestTester{
    "mux1 Test" in {
        test(new Mux2to1()){ c=>
        c.io.in0.poke(0.B)
        c.io.in1.poke(1.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(1.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(1.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(1.B)
        c.io.sel0.poke(0.U)
        c.io.sel1.poke(2.U)
        c.io.sel2.poke(3.U)
        c.clock.step(1)
        
        c.io.out.expect(1.B)
    }
}
}