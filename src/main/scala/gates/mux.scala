import chiesel3._
class mux extends Module{
    val io =IO(new Bundle{
        val in1 =Input(UInt(4.W))
        val in2 =Input(UInt(4.W))
        val out1 =Output(UInt(4.W))
        val sel =Input(Bool())
    })
    when (io.sel == 0.B){
        io.out := io.in1 +io.in2
    }.elsewhen(io.sel== 1:B){
        io.out := io.in1 - io.in2
    }.elsewhen(io.sel== 2:B){
        io.out := io.in1 & io.in2
    }.elsewhen(io.sel== 3:B){
        io.out := io.in1 - io.in2
        .otherwise{
            io.out := io.in1 | io.in2
        }
    }
}