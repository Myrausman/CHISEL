package lab2
import chisel3._ 
import chisel3.util._
class LM_IO_Interfac extends Bundle {
    val s0 = Input ( Bool () )
    val s1 = Input ( Bool () )
    val s2 = Input ( Bool () )
    val out = Output ( UInt (32. W ) )
}
class Mux_5to1 extends Module {
    val io = IO (new LM_IO_Interfac )
        val sel = Cat(io.s2,io.s1,io.s0).asInstanceOf[UInt]
    // Start coding here
    io.out := MuxCase(false.B, Array(
        (sel === 0.U) -> 0.U,
        (sel === 1.U) -> 8.U,
        (sel === 2.U) -> 16.U,
        (sel === 3.U) -> 24.U,
        (sel === BitPat("b1??")) -> 32.U
    ))
    // End your code here
}
