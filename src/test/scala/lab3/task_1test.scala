package lab3
import chisel3._
import org.scalatest._
import chiseltest._
class branchtest extends FreeSpec with ChiselScalatestTester{
    "aluTest" in {
        test(new BranchControl()){ c=>
        c.io.funct3.poke(1.U)
        c.io.branch.poke(1.B)
        c.io.arg_x.poke(2.U)
        c.io.arg_y.poke(2.U)
        c.clock.step(1)
        c.io.br_taken.expect(0.B)
    }
}
}