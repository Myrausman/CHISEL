package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

class imm4test extends FreeSpec with ChiselScalatestTester {
    "lab 4 imm_instr" in {
    test(new ImmdValGen()) { c =>
        val array_instr = Array ( "h556AAA93","h556AAAA3","h556AAAB7","h556AAAE3","h556AAAEF","h556AAA83")
             for ( i <- 0 until 100) {       
                val type_ = Random.nextInt (5)
                val inst = array_instr(type_)
                val result = inst match {
                    case "h556AAA93" => 1366
                    case "h556AAAA3" => 1365
                    case "h556AAAB7"=> 349866
                    case "h556AAAE3" => 1706
                    case "h556AAAEF" => 348843
                    case "h556AAA83" => 1366
                    case _ => 0
                }
                
                
                    c.io.instr.poke(inst.U)
                    c.clock.step(2)
                    c.io.immd_se.expect(result.U)
                println("inst: ",inst)
                println("result: " ,result)
                
            
        
        
        
                
         }
}}
}