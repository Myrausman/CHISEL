package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

class branch4test extends FreeSpec with ChiselScalatestTester {
    "lab 4 branch" in {
    test(new BranchControl()) { c =>
        val array_func3 = Array ( 0,1,4,5,6,7)
             for ( i <- 0 until 100) {
                val x = Random . nextLong () & 0xFFFFFFFFL
                val y = Random . nextLong () & 0xFFFFFFFFL
                val branch = Random.nextBoolean()
                val opr = Random . nextInt (6)
                val func3 = array_func3(opr)
                val result = func3 match {
                case 0 => if (x == y) {1} else {0}
                case 1 => if (x != y) {1} else {0}
                case 4 => if (x < y) {1} else {0}
                case 5 => if (x > y) {1} else {0}
                case 6 => if (x < y) {1} else {0}
                case 7 => if (x >= y) {1} else {0}
                case _ => 0
                }
            c.io.funct3.poke(func3.U)
            c.io.branch.poke(branch.B)
            c.io.arg_x.poke(x.U)
            c.io.arg_y.poke(y.U)
            c.clock.step(1)
            if (branch ==1.B ) {
                c.io.br_taken.expect(result.B)
                }
            else if (branch == 0.B) {
                c.io.br_taken.expect(0.B)
                }
        
        println("f: ",func3)
        println("x: ",x)
        println("y: ",y)
        println("branch: ",branch)
        println("result:" ,result)
             }
    }}
}