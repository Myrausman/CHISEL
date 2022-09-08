// Immediate ( Assignment )
package lab3
import chisel3._
import chisel3.util._
object instructions{
    
// ALU Operations , may expand / modify in future
// i type: 0010011
// s:0100011
// u:0110111
// b:1100011
// j:1101111
// load instructions :0000011
    val i_type = "b0010011".U (7.W )
    val s_type = "b0100011".U (7.W )
    val u_type = "b0110111".U (7.W )
    val b_type = "b1100011".U (7.W )
    val j_type ="b1101111".U (7.W )
    val ld_ins = "b0000011".U (7.W )
}

class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    val immd_se = Output ( UInt (32. W ) )
}
import instructions._
class ImmdValGen extends Module {
    val io = IO (new LM_IO_Interface_ImmdValGen )
// Start coding here
    io.immd_se := 0. U
    switch(io.instr(6,0)){
        is( i_type){
            val out=Fill(20,io.instr(31))
            io.immd_se := Cat(out, io.instr(31,20))
        }
        is( s_type ){
            val out=Fill(20,io.instr(31))
            io.immd_se := Cat(out,io.instr(31,25),io.instr(11,7))
        }
        is(u_type){
            val out=Fill(12,io.instr(31))
            io.immd_se := Cat(out,io.instr(31,12))
        }
        is(b_type){
            val out=Fill(19,io.instr(31))
            io.immd_se := Cat(out,io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8))
        }
        is( j_type ){
            val out=Fill(11,io.instr(31))
            io.immd_se := Cat(out,io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21))
        }
        is(ld_ins){
            val out=Fill(20,io.instr(31))
            io.immd_se := Cat(out, io.instr(31,20))
        }
    }
}