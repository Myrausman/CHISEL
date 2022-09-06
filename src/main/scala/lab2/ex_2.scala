package lab2
import chisel3._
import chisel3.util._
class LM_IO_Interface extends Bundle {
    val in0 = Input ( Bool () )
    val in1 = Input ( Bool () )
    val in2 = Input ( Bool () )
    val in3 = Input ( Bool () )
    val in4 = Input ( Bool () )
    val in5 = Input ( Bool () )
    val in6 = Input ( Bool () )
    val in7 = Input ( Bool () )
    val sel0 = Input ( UInt(1.W) )
    val sel1 =Input(UInt(2.W))
    val sel2 =Input(UInt(2.W))
    val out = Output ( Bool () )
    }
class Mux2to1 extends Module {
    val io = IO(new LM_IO_Interface)
    io.out := MuxLookup ( io.sel0 , false.B , Array (
    (0. U ) -> MuxLookup(io.sel1,false.B,Array(
        (0.U) -> io.in0,
        (1.U) -> io.in1,
        (2.U) -> io.in2,
        (3.U) -> io.in3,
        )) ,
    (1. U ) -> MuxLookup(io.sel2,false.B,Array(
        (0.U) -> io.in4,
        (1.U) -> io.in5,
        (2.U) -> io.in6,
        (3.U) -> io.in7,
    ))))
}