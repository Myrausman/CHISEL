package lab5

import chisel3 . _
import chisel3 . util . _

class IOs ( width : Int ) extends Bundle {
    val alu_oper = Input ( UInt ( width . W ) )
    val arg_x = Input ( UInt ( width . W ) )
    val arg_y = Input ( UInt ( width . W ) )
    val alu_out = Output ( UInt ( width . W ) )
}

class ALU5 ( width_parameter : Int ) extends Module {
    val io = IO (new IOs ( width_parameter ) )
    // io . alu_out := 0. U
    val index = log2Ceil ( width_parameter )
        when(io.alu_oper === 0.U){io . alu_out := io . arg_x & io . arg_y}
        .elsewhen(io.alu_oper === 1.U){
            io . alu_out := io . arg_x | io . arg_y}
        .elsewhen(io.alu_oper === 2.U){
            io . alu_out := io . arg_x + io . arg_y}
        .elsewhen(io.alu_oper === 6.U){
            io . alu_out := io . arg_x - io . arg_y}
        .elsewhen(io.alu_oper === 3.U){
            io . alu_out := io . arg_x ^ io . arg_y}
        .elsewhen(io.alu_oper === 4.U){
            io . alu_out := io . arg_x << io . arg_y ( index -1 , 0)}
        .elsewhen(io.alu_oper === 5.U){
            io . alu_out := io . arg_x >> io . arg_y ( index -1 , 0)}
        .elsewhen(io.alu_oper === 7.U){
            io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index -1 , 0) ) . asUInt}
        .elsewhen(io.alu_oper === 8.U){
            io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt}
        .elsewhen(io.alu_oper === 9.U){
            io . alu_out := io . arg_x < io . arg_y}
        .otherwise{io . alu_out := 0.U}
}

