package lab2
import chisel3._
import chisel3.util._
// Mux IO interface class
class Mux_2to1_IO extends Bundle {
    val in_A = Input ( UInt (32.W ) )
    val in_B = Input ( UInt (32.W ) )
    val select = Input ( Bool () )
    val out = Output ( UInt () )
    // val out1 = Output ( UInt (4.W) )
}

// 2 to 1 Mux implementation
class Mux_2to1 extends Module {
    val io = IO (new Mux_2to1_IO)
    val new1 = Fill(32,io.select.asUInt)
// update the output
    io.out := io.in_A & new1 | io.in_B & (~ new1 )
// update the output
    // io.out1 := Mux ( io.select , io.in_A , io.in_B )

}