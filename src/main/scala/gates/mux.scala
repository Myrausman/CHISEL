package gates
import chisel3._
class mux extends Module{
    val io =IO(new Bundle{
        val in1 =Input(SInt(4.W))
        val in2 =Input(SInt(4.W))
        val out =Output(SInt(4.W))
        val sel =Input(UInt(4.W))
    })
    when (io.sel === 0.U){
        io.out := io.in1 +io.in2
    }.elsewhen(io.sel === 1.U){
        io.out := io.in1 - io.in2
    }.elsewhen(io.sel === 2.U){
        io.out := io.in1 & io.in2
    }.elsewhen(io.sel=== 3.U){
        io.out := io.in1 | io.in2
    }.elsewhen(io.sel === 4.U){
        io.out := io.in1 ^ io.in2
    }.otherwise{
        io.out := ~(io.in1 ^ io.in2)
    }   
}
