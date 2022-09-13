package lab6
// Up - down counter example
import chisel3._
import chisel3.util._
// import java.io.File
class up_down_counter ( val max : Int = 10) extends Module {
    val io = IO (new Bundle {
    val out = Output ( UInt ( log2Ceil ( max ) . W ) )
    val up_down1 = Input ( Bool () )
})
// Start code here
    val counter = RegInit (0.U ( log2Ceil ( max ).W ) )
    val up_down=RegInit(io.up_down1)
    io.out:=0.B
    
    when(counter=/=max.U && up_down ===1.U){
        counter:=counter+1.U
        
    }.elsewhen(counter===max.U){
        up_down :=0.U
        counter:=counter-1.U
        io.out:= 0.B
    }.elsewhen(counter===0.U){
        up_down :=1.U
        io.out:=1.B
        counter:= counter+1.U
    
    }.elsewhen (up_down ===0.U){
        counter := counter-1.U
        io.out:=1.B
    
    }
    
}