package lab6
import chisel3._
import chisel3.util._
//import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
class My_Queue extends Module {
    // your code begin
    val io = IO ( new Bundle {
    val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready = Output , bits = Input
    val out = Decoupled ( UInt (8. W ) ) // valid = Output , ready =Input , bits = Output
    })
    val queue1 = Queue(io.in,5)
    queue1.deq()
    val queue2 = Queue(queue1,5)
    queue2.ready:=false.B
    when(queue2.valid && io.out.ready){
        io.out.enq(queue2.deq())
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }

}

// your code end here