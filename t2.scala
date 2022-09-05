package lab1
import chisel3._
import chisel3.util._
import java.io.File
class counter_up_down ( n : Int ) extends Module {
    val io = IO (new Bundle {
        val out = Output ( Bool () )
    })
    var counter = RegInit (0.U ( n.W ) )
    val max_count = RegInit (6.U ( n.W ) )
    val flag=RegInit(0.U)
    io.out:=0.B
    dontTouch(flag)
    when(counter=/=max_count && flag ===0.U){
        counter:=counter+1.U
        
    }.elsewhen(counter===max_count){
        flag:=1.U
        counter:=counter-1.U
        io.out:= 0.B
    }.elsewhen(counter===0.U){
        flag:=0.U
        io.out:=1.B
        counter:= counter+1.U
    
    }.elsewhen (flag===1.U){
        counter := counter-1.U
        io.out:=1.B
    
    }
    
}