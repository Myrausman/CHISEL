// Branch control ( Assignment )
package lab3
import chisel3._
import chisel3.util._
class LM_IO_Interface_BranchControl extends Bundle {
    val funct3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}
object fun3 {
// ALU Operations , may expand / modify in future
    val beq = 0. U (3. W )
    val bne = 1. U (3. W )
    val blt = 4. U (3. W )
    val bgt = 5. U (3. W )
    val bltu = 6. U (3. W )
    val bgeu = 7. U (3. W )
}
import fun3._
class BranchControl extends Module {
val io = IO (new LM_IO_Interface_BranchControl )
// Start Coding here
io.br_taken:=0.B
switch (io.funct3){
    is (beq) {
        val check = io.arg_x === io.arg_y
            io.br_taken:= Mux(check,1.B,0.B) && io.branch
        }
    is (bne) {
            io.br_taken:= Mux(io.arg_x =/= io.arg_y,1.B,0.B) && io.branch
        }
    is (blt) {
            io.br_taken:= Mux(io.arg_x < io.arg_y,1.B,0.B) && io.branch
        }
    is (bgt ) {
            io.br_taken:= Mux(io.arg_x> io.arg_y,1.B,0.B) && io.branch
        }
    is (bltu ) {
            io.br_taken:= Mux(io.arg_x< io.arg_y,1.B,0.B) && io.branch
        }
    is (bgeu) {
            io.br_taken:= Mux(io.arg_x<= io.arg_y,1.B,0.B) && io.branch
        }

}
}

// End your code here
// Well , you can actually write classes too . So , technically you have no
