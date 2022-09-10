package lab5
import chisel3._
import org.scalatest._
import chiseltest._
class l5ex3test extends FreeSpec with ChiselScalatestTester{
    "lab5  Test 3" in {
        test(new Operator(3,UInt(4.W))(_+_)) { c =>
            c.io.in(0).poke(6.U)
            c.io.in(1).poke(2.U)
            c.io.in(2).poke(1.U)
            c.clock.step(20)
            c.io.out(1).expect(9.U)
            c.io.out(0).expect(9.U)
            c.io.out(2).expect(9.U)
    }
}
}