package gates
import chisel3._
class Fulladder extends Module{
    val io =IO(new Bundle{
    val a=Input(SInt(4.W))
    val b=Input(SInt(4.W))
    val cin=Input(SInt(4.W))
    val sum=Output(SInt(4.W))
    val cout=Output(SInt(4.W))
    })
     
    io.sum:=  io.a ^ io.b ^ io.cin
    io.cout:= (io.a & io.b) | (io.a ^ io.b & io.cin)
}