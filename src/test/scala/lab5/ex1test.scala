package lab5
import chisel3._
import org.scalatest._
import chiseltest._
class l5ex1test extends FreeSpec with ChiselScalatestTester{
    "lab5 Test" in {
        test(new ALU5(4)){ c =>
        c.io.alu_oper.poke(2.U)
        c.io.arg_x.poke(1.U)
        c.io.arg_y.poke(1.B)
        c.clock.step(3)
        c.io.alu_out.expect(2.U)
    }
}
}