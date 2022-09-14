package lab8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


class l8ex2 extends Module {
    val width : Int = 16
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (2 , Bool () ) )
        val dataIn = Input ( Vec (2 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (2 , UInt ( width . W ) ) )
    })
    val mem = SyncReadMem(1024,Vec(2,UInt(width.W)))
    val wrReg = RegNext(io.dataIn)
    val memData = mem.read(io.addr,io.enable)
    val do_forwarding = RegNext(io.enable === true.B && io.write === true.B)
    when(io.write){
        mem.write(io.addr, io.dataIn, io.mask)
    }
    when (do_forwarding){
        io.dataOut(0):= Mux(io.mask(0),wrReg(0),0.U)
        io.dataOut(1):= Mux(io.mask(1),wrReg(1),0.U)
    }.otherwise{
        io.dataOut:= memData
    }

}