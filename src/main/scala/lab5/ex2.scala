package lab5
import chisel3._
import chisel3.util._
class IO_Interface [ T <: Data ] ( gen:T) extends Bundle {
    val out = Output ( gen )
    val in1 = Input ( gen )
    val in2 = Input ( gen)
    val sel = Input ( Bool () )   
}
class eMux( size : UInt ) extends Module {
    val io = IO (new IO_Interface ( size ) )

         io.out := Mux( io.sel , io.in1 , io.in2 )
    // println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new eMux ( UInt (2. W ) ) ) )
}
    

   