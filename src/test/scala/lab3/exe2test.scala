package lab3
import chisel3._
import org.scalatest._
import chiseltest._
class alutest extends FreeSpec with ChiselScalatestTester{
    "aluTest" in {
        test(new ALU()){ c=>
        c.io.alu_Op.poke(1.U)
        c.io.in_A.poke(2.U)
        c.io.in_B.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(1.U)
    }
}
}