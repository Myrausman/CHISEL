package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

class imm4test extends FreeSpec with ChiselScalatestTester {
    "lab 4 imm_instr" in {
    test(new ImmdValGen()) { c =>
        val array_instr = Array ( "b1010101011010101010101010010011","b1010101011010101010101010100011","b1010101011010101010101010110111","b1010101011010101010101011100011","b1010101011010101010101011101111","b1010101011010101010101010000011")
             for ( i <- 0 until 100) {       
                val type_ = Random.nextInt (6)
                val inst = array_instr(type_)
                val result = inst match {
                    case "b1010101011010101010101010010011" => 1366//i
                    case "b1010101011010101010101010100011" => 1365//s
                    case "b1010101011010101010101010110111"=> 349866//u
                    case "b1010101011010101010101011100011" => 1706//b
                    case "b1010101011010101010101011101111" => 348843//j
                    case "b1010101011010101010101010000011"=> 1366//ld
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