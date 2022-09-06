package practice
import chisel3._
class Counter ( counterBits : Int ) {
    val max = (1 << counterBits ) - 1
    var count = 0
    if( count == max ) {
        count = 0
    }
    else {
        count = count + 1
    println ( s" counter created with max value $max ")
    }
}
object Main{
    def main ( args : Array [ String ]) : Unit =
    {
    var abc = new Counter(3)
    }
    
}
