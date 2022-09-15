package lab8
import chisel3 . _
import chisel3 . util . _
class memory_assignment extends Module {
    val io = IO (new Bundle {
        val dataOut = Vec (4 , Output ( UInt (32. W ) ) )
        val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
        val Readaddr = Input ( UInt (5. W ) )
        val Writeaddr = Input ( UInt (5. W ) )
        })
        // Start your code from here
    val q0=Queue(io.requestor(0))
    val q1=Queue(io.requestor(1))
    val q2=Queue(io.requestor(2))
    val q3=Queue(io.requestor(3))
    val arb_priority = Module (new Arbiter ( UInt () , 4) )
        // connect the inputs to different producers

        arb_priority.io.in (0) <> q0
        arb_priority.io.in (1) <> q1
        arb_priority.io.in (2) <> q2
        arb_priority.io.in (3) <> q3
    arb_priority.io.out.ready := 1.B
    val mem = SyncReadMem(1024,Vec(4,UInt(32.W)))
    val data=Reg(Vec(4, UInt()))
    when( io.requestor(0).valid ){
        data(0) := arb_priority.io.out.bits
        data(1) := 0.U
        data(2) := 0.U
        data(3) := 0.U
        mem.write(io.Writeaddr, data)
    }.elsewhen( io.requestor(1).valid){
        data(0) := 0.U
        data(1) := arb_priority.io.out.bits
        data(2) := 0.U
        data(3) := 0.U
        mem.write(io.Writeaddr, data)
    }.elsewhen( io.requestor(2).valid){
        data(0) := 0.U
        data(1) := 0.U
        data(2) := arb_priority.io.out.bits
        data(3) := 0.U
        mem.write(io.Writeaddr, data)
    }.elsewhen( io.requestor(2).valid){
        data(0) := 0.U
        data(1) := 0.U
        data(2) := 0.U
        data(3) :=arb_priority.io.out.bits
        mem.write(io.Writeaddr, data)
    }
    // End your code here
    io.dataOut:=mem.read(io.Readaddr)
}