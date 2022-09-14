package lab6
import chisel3._
import org.scalatest._
import chiseltest._
class l6t1test extends FreeSpec with ChiselScalatestTester{
    "lab6 Test" in {
        test(new counter_with_xor()){ c =>
        
        
        c.clock.step(20)
        // c.io.out.expect(4.U)
    }
}
}