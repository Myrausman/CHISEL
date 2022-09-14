package lab7
import chisel3._
import chisel3.util._

class task1 extends Module {
    val io = IO( new Bundle{
        val f1 =Input(Bool())
        val f2 =Input(Bool())
        val r1 =Input(Bool())
        val r2 =Input(Bool())
        val out = Output(UInt(4.W))
    })
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 ::  Nil = Enum (6) // Enumeration type
    val state = RegInit(s0)
    io.out := 0.U
    switch(state){
        is(s0){
            io.out:=0.U
            when(io.f1 === 0.B && io.f2 === 0.B){
                state := s0
                
            }.elsewhen(io.f1 === 1.B && io.f2 === 0.B){
                state := s1
            }.elsewhen(io.f1 === 0.B && io.f2 === 1.B){
                state := s5
                
            }.elsewhen(io.f1 === 1.B && io.f2 === 1.B){
                state := s1
            }
        }
        is(s1){
            io.out:=0.U
            when(io.f1 === 0.B && io.r1===0.B){
                state :=s1
                
            }.elsewhen(io.f1 === 1.B ){
                state := s2
            }.elsewhen(io.f1 === 0.B && io.r1===1.B){
                state := s0
            }
        }
        is(s2){
            io.out:=3.U
            when(io.f1 === 0.B && io.r1===0.B){
                state :=s2
                
            }.elsewhen(io.f1 === 1.B ){
                state := s3
                
            }.elsewhen(io.f1 === 0.B && io.r1===1.B){
                state := s1
            }
        }
        is(s3){
            state :=s0
            io.out:=0.U

        }
        is(s4){
            io.out:=7.U
            when(io.f2 === 1.B){
                state :=s3
                
            }.elsewhen(io.f2 === 0.B && io.r2 ===0.B){
                state := s4
                
            }.elsewhen(io.f2 === 0.B && io.r2===1.B){
                state := s5
            }

        }
        is(s5){
            io.out:=0.U
            when(io.f2 === 1.B){
                state :=s4
                
            }.elsewhen(io.f2 === 0.B && io.r2 ===0.B){
                state := s5
                
            }.elsewhen(io.f2 === 0.B && io.r2===1.B){
                state := s0
            }
        }
    
}}