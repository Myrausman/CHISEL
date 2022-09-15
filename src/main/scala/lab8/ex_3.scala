package lab8
import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
class l8ex3 extends Module {
    val width : Int = 16
    val io = IO (new Bundle {
        val write = Input ( Bool () )
        val instWr = Input(UInt(32.W))
        val addr = Input ( UInt (32. W ) )
        val instRead = Output(UInt(32.W))
    })
    val mem=Mem(32,UInt(32.W))
    when (io.write){
        mem.write(io.addr,io.instWr)

    }
    io.instRead:=mem.read(io.addr)

}
