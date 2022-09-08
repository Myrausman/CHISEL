package lab3
import chisel3._
import chisel3.util._
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input ( UInt (2. W ) )
    val out = Valid ( Output ( UInt (4. W ) ) )
    }
class decoder_with_valid extends Module {
    val io = IO (new LM_IO_Interface_decoder_with_valid )
    // Start coding here
        io.out.bits := 0.U
        io.out.valid := false.B
        switch (io.in) {
            is ("b00".U){
                io.out.bits := "b0001".U
                io.out.valid := true.B
            }
            is ("b01".U){
                io.out.bits := "b0010".U
                io.out.valid := true.B
            }
            is ("b10".U){
                io.out.bits := "b0100".U
                io.out.valid := true.B
            }

        // End coding here
    }
}