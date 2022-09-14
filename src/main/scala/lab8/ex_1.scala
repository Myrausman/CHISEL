package lab8
import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
class l8ex1 extends Module {
    val width : Int = 8
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (4 , Bool () ) )
        val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
        val dataOut = Output (  Vec(4,UInt ( width . W ) )) 
        })
    
    val mem = SyncReadMem(1024,Vec(4,UInt(width.W)))

    when(io.write === true.B){
        val Mask = Cat(io.mask(3),io.mask(2),io.mask(1),io.mask(0)).asUInt
        val data_wr = Reg(Vec(4, UInt()))
        when(Mask === 0.U){
            
            data_wr(0) := 0.U
            data_wr(1) := 0.U
            data_wr(2) := 0.U
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 1.U){
            data_wr(0) := io.dataIn(0)
            data_wr(1) := 0.U
            data_wr(2) := 0.U
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 2.U){
            
            data_wr(0) := 0.U
            data_wr(1) := io.dataIn(1)
            data_wr(2) := 0.U
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 3.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := io.dataIn(1)
            data_wr(2) := 0.U
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 4.U){
            
            data_wr(0) := 0.U
            data_wr(1) := 0.U
            data_wr(2) := io.dataIn(2)
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 5.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := 0.U
            data_wr(2) := io.dataIn(2)
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 6.U){
            
            data_wr(0) := 0.U
            data_wr(1) := io.dataIn(1)
            data_wr(2) := io.dataIn(2)
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 7.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := io.dataIn(1)
            data_wr(2) := io.dataIn(2)
            data_wr(3) := 0.U
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 8.U){
            
            data_wr(0) := 0.U
            data_wr(1) := 0.U
            data_wr(2) := 0.U
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 9.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := 0.U
            data_wr(2) := 0.U
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 10.U){
            
            data_wr(0) := 0.U
            data_wr(1) := io.dataIn(1)
            data_wr(2) := 0.U
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 11.U){
            
            data_wr(0) := 0.U
            data_wr(1) := io.dataIn(1)
            data_wr(2) := io.dataIn(2)
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 12.U){
            
            data_wr(0) := 0.U
            data_wr(1) := 0.U
            data_wr(2) := io.dataIn(2)
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 13.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := 0.U
            data_wr(2) := io.dataIn(2)
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 14.U){
            
            data_wr(0) := 0.U
            data_wr(1) := io.dataIn(1)
            data_wr(2) := io.dataIn(2)
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }.elsewhen(Mask === 15.U){
            
            data_wr(0) := io.dataIn(0)
            data_wr(1) := io.dataIn(1)
            data_wr(2) := io.dataIn(2)
            data_wr(3) := io.dataIn(3)
            mem.write(io.addr, data_wr)
        }

    }

    io.dataOut := mem.read(io.addr,io.enable)
}


