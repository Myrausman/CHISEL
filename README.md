# CHISEL

<p><em>Chisel</em> (Constructing
Hardware In a Scala Embedded Language) is a hardware
construction language embedded in the high-level programming language
Scala.
 Chisel is a library of special class
definitions, predefined objects, and usage conventions within <a href="https://www.scala-lang.org/">Scala</a>,
so when you write Chisel you are actually writing a Scala
program that constructs a hardware graph.
As you gain experience and want to make your code simpler or more
reusable, you will find it important to leverage the underlying power
of the Scala language. We recommend you consult one of the excellent
Scala books to become more expert in Scala programming.</p>
<p>For a tutorial covering both Chisel and Scala, see the 
<a href="https://mybinder.org/v2/gh/freechipsproject/chisel-bootcamp/master"><strong>online Chisel Bootcamp</strong></a>.</p>

<p>For quick reference “How-To” guides see the <a href="cookbooks/cookbooks">Cookbooks</a>.</p>
# Verilog vs Chisel Side-By-Side

This page serves as a quick introduction to Chisel for those familiar with Verilog. It is by no means a comprehensive guide of everything Chisel can do. Feel free to file an issue with suggestions of things you'd like to see added to this page. 


# Verilog vs Chisel Side-By-Side

This page serves as a quick introduction to Chisel for those familiar with Verilog. It is by no means a comprehensive guide of everything Chisel can do. Feel free to file an issue with suggestions of things you'd like to see added to this page. 


<body>
    <!-- This script is needed so that Markdown and HTML will render together, see link to Stack overflow -->
    <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
    <table border="0">
        <h1>Creating a Module</h1>
        <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>
         <tr>
<td>

```verilog
module Foo (
  input  a,
  output b
);
  assign b = a;
endmodule
```

</td>
    <td>

```scala
class Foo extends Module {
  val a = IO(Input(Bool()))
  val b = IO(Output(Bool()))
  b := a
}
```
</td>
         </tr>
    </table>
</body>
</html>

<h1 id="parameterizing-a-module">Parameterizing a Module</h1>

<html>
<body>
    <table border="0">
          <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>

<tr>
<td>

```verilog
module PassthroughGenerator(
  input  [width-1:0] in,
  output [width-1:0] out
);
 
  parameter width = 8;
  
  assign out = in;
endmodule
```
</td>
<td>

```scala
class PassthroughGenerator(width: Int = 8) extends Module {
    val in = IO(Input(UInt(width.W)))
    val out = IO(Output(UInt(width.W)))
    
    out := in
}
```
</td>
         </tr>
         <tr>
<td>

```verilog
module ParameterizedWidthAdder(
  input [in0Width-1:0] in0,
  input [in1Width-1:0] in1,
  output [sumWidth-1:0] sum
);
  parameter in0Width = 8;
  parameter in1Width = 1;
  parameter sumWidth = 9;

  assign sum = in0 + in1;

endmodule
```

</td>
<td>

```scala
class ParameterizedWidthAdder(
  in0Width: Int,
  in1Width: Int,
  sumWidth: Int) extends Module {
  
  val in0 = IO(Input(UInt(in0Width.W)))
  val in1 = IO(Input(UInt(in1Width.W)))
  val sum = IO(Output(UInt(sumWidth.W)))
  
  // a +&amp; b includes the carry, a + b does not
  sum := in0 +&amp; in1
}
```
</td>
</tr>
    </table>
<html>
<body>

# Wire Assignment and Literal Values

<html>
<body>
    <table border="0">
          <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>
<tr>
<td>

```verilog
module MyWireAssignmentModule ();

  wire [31:0] aa = 'd42;
  // Logical reg for use in always block, not real register
  reg [31:0] a;
  
  //
  always @(*) begin
    a = aa;
  end 
  
  // Hex value initialization
  wire [31:0] b = 32'hbabecafe;
  
  // Declaration separate from Assignment
  wire [15:0] c;
  wire d;
  
  assign c = 16'b1;
  assign d = 1'b1;
  
  // Signed values
  wire signed [63:0] g;
  assign g = -’d5;
  
  wire signed [31:0] h = 'd5;
  
  reg signed[31:0] f;
  always@(*) begin
    f = ‘d5;
  end
endmodule
```


</td>
<td>

```scala


class MyWireAssignmentModule extends Module {

    val aa = 42.U(32.W)
    val a = Wire(UInt(32.W))
    a := aa
    val b = "hbabecafe".U(32.W)
    val c = Wire(UInt(16.W))
    val d = Wire(Bool())
    c := "b1".U(16.W)
    d := true.B
    val g = Wire(SInt(64.W))
    g := -5.S
    val h = 5.asSInt(32.W)
    val f = Wire(SInt(32.W))
    f := 5.S
}
```

</td>
</tr>
    </table>
<html>
<body>

# Register Declaration and Assignment

<html>
<body>
    <table border="0">
          <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>
 <tr>
<td>

```verilog
module RegisterModule(
  input        clock,
  input        reset,
  input  [7:0] in,
  output [7:0] out,
  input        differentClock,
  input        differentSyncReset,
  input        differentAsyncReset
);

  reg [7:0] registerWithoutInit;
  reg [7:0] registerWithInit;
  reg [7:0] registerOnDifferentClockAndSyncReset;
  reg [7:0] registerOnDifferentClockAndAsyncReset;


  always @(posedge clock) begin
    registerWithoutInit &lt;= in + 8'h1;
  end
  
  always @(posedge clock) begin
    if (reset) begin
      registerWithInit &lt;= 8'd42;
    end else begin
      registerWithInit &lt;= registerWithInit - 8'h1;
    end
  end
  
  always @(posedge differentClock) begin
    if (differentSyncReset) begin
      registerOnDifferentClockAndSyncReset &lt;= 8'h42;
    end else begin
      registerOnDifferentClockAndSyncReset &lt;= in - 8'h1;
    end
  end
   
  always @(posedge differentClock or posedge differentAsyncReset) begin
    if (differentAsyncReset) begin
      registerOnDifferentClockAndAsyncReset &lt;= 8'h24;
    end else begin
      registerOnDifferentClockAndAsyncReset &lt;= in + 8'h2;
    end
  end
  
  assign out = in + 
    registerWithoutInit + 
    registerWithInit + 
    registerOnDifferentClockAndSyncReset + 
    registerOnDifferentClockAndAsyncReset;
endmodule
  
```
</td>
<td>

```scala
class RegisterModule extends Module {
  val in  = IO(Input(UInt(8.W)))
  val out = IO(Output(UInt(8.W)))

  val differentClock = IO(Input(Clock()))
  val differentSyncReset = IO(Input(Bool()))
  
  val differentAsyncReset = IO(Input(AsyncReset()))
  
  val registerWithoutInit = Reg(UInt(8.W))
  
  val registerWithInit = RegInit(42.U(8.W))
  
  registerWithoutInit := in + 1.U
  
  registerWithInit := registerWithInit - 1.U
  
  val registerOnDifferentClockAndSyncReset = withClockAndReset(differentClock, differentSyncReset) {
    val reg = RegInit("h42".U(8.W))
    reg
  }
  registerOnDifferentClockAndSyncReset := in - 1.U
  
  val registerOnDifferentClockAndAsyncReset = withClockAndReset(differentClock, differentAsyncReset) {
    val reg = RegInit("h24".U(8.W))
    reg
  }
  registerOnDifferentClockAndAsyncReset := in + 2.U
  
  out := in + 
    registerWithoutInit + 
    registerWithInit + 
    registerOnDifferentClockAndSyncReset + 
    registerOnDifferentClockAndAsyncReset
}
```
</td>
         </tr>
    </table>
<html>
<body>

