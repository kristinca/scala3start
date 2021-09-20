import scala.collection.immutable.IntMap.Nil.find
import scala.io.Codec.fallbackSystemCodec.name

// this is scala 3.0.2 ^^

// My work and notes from the book "Programming in Scala"
//by Martin Odersky, Lex Spoon, and Bill Venners
//and other random web examples :D

//An integer that can become arbitrarily large
// without overflow or "wrap-around" of arithmetic operations
// -> there is a library class scala.BigInt :
// we can use * and - with values of this type

def factorial(x:BigInt): BigInt =
  if x == 0 then 1
  else x * factorial(x-1)

factorial(28)

"in Scala a function value is an object!".toUpperCase()

//Scala re-uses Java types

//this is Java
/*
class MyClass {
  private int index;
  private String name;

  public MyClass(int index, String name) {
    this.index = index;
    this.name  = name;
  }
} */

// this is Scala
class MyClass1(index: Int, name: String)

// this is Java
/*
boolean nameHasUpperCase = false;
for (int i = 0; i < name.length(); ++i) {
  if (Character.isUpperCase(name.charAt(i))) {
    nameHasUpperCase = true;
    break;
  }
}*/

//this is Scala


class exists(name: String) {
  def hasProperty(ch: Char) = Character.isUpperCase(ch)
}


//Scala has two kinds of variables:
//-> vals: once initialized can NEVER be reassigned
//-> vars: can be reassigned


val msg  = "This is a msg"
val msg2 = "This is another msg"
print(msg)
//msg = "This is an error :D "
var msg1 = "This is a var msg"
msg1 = "This is not an error cause this is var"
print(msg1)

// functions
def max(x: Int, y:Int): Int =
  if (x > y) x
  else y

max(2,3)

//Scala is designed to build very large-scale systems
// it also scales down to scripting

// while, if, for, foreach
// the syntax for a function literal
// -> a list of named parameters in parentheses
// + a right arrow
// then the body of the function

//example of a function literal :
//(x: Int, y: Int) => x + y

//for loops with range
/*for( var x <- Range ){
   statement(s);
}*/
object Demo {
  def main(args: Array[String]) = {
    var a = 0;

    // for loop execution with a range
    for( a <- 1 to 10){
      println( "Value of a: " + a );
    }
  }
}

object Demo1 {
  def main(args: Array[String]) = {
    var a = 0;

    // for loop execution with a range
    for( a <- 1 until 10){
      println( "Value of a: " + a );
    }
  }
}

//for loop w/ collections
/*for( var x <- List ){
   statement(s);
}*/

object Demo2 {
  def main(args: Array[String]) = {
    var a = 0
    val numList = List(1,2,3,4,5)

    //for loop w/ a collection
    for (a <- numList) {
      println("Value of num: "+a)
    }
  }
}

//for loop w/ filters
/*for( var x <- List
      if condition1; if condition2...
   ){
   statement(s);
}*/
object Demo3{
  def main(args: Array[String]) ={
    var a = 1;
    val numList = List(2,3,4,5,6)

  // for loop w/ multiple filters
  for(a <- numList
      if a != 3; if a < 6){
    println("Value of a: "+a)
  }
  }
}

//for loop w/ yield -> yield = return in python function
/*var retVal = for{ var x <- List
   if condition1; if condition2...
}
yield x*/

object Demo4 {
  def main(args: Array[String]) ={
    var a = 0;
    val numList = List(1,2,3,4,5,6,7,8,9,10)

    // for loop execution with a yield
    var retVal = for{ a <- numList if a != 3; if a < 8 }yield a

    // Now print returned values using another loop.
    for( a <- retVal){
      println( "Value of a: " + a )
    }
  }
}

//no goto, no break, no continue, no semicolons
//every expression computes to a value
//every value has a type
// there are no operators -> only method calls

//a class is an istance of a class,
// is also a constructor of the object

// val, var, def, lazy val, type

val const =
  println("This is a constant value...\n")
  64154

println(const)

var nonconst =
  println("This is a variable and CAN BE CHANGED..\n")
  215412
println(nonconst)
//nonconst = 85345
//println(nonconst)

def square(a: Int): Int =
  a * a

square(10)

square(2-5)

lazy val ex1 =
  println("We're seeing them ONLY when we're using them")

println("A lazy val".length)
//nothing has 0 values
val novalue: Nothing = throw new Exception

println("Something")
// unit has 1 value
val unit1: Unit = ()

println(unit1)
//null has 1 value
val hellonull: Null = null

//Booleans
val oui: Boolean = true
println(oui)

//numeric types:
// Byte, Short, Int, Long, Float, Double

val bytemini: Byte = Byte.MinValue
val bytemax: Byte = Byte.MaxValue
print(bytemini, bytemax)

//hexadecimal
val c1 = 0x1C
println(c1)

val c2 = -1e2

//Strings
val c3 = "This is a string"
println(c3+'.')

println(""" This is a string too """)

//string formatting -> s"input string here $val_name "
println(s"Yet another string ${c2+5}. $c3")

//if contitions return a val, ofc

var a = 1
var b = 1
var c = 2

// if conditions
if (a+b > c ) then
  println(s"a + b > c : $a + $b > $c")
else if (a+c > b) then
  println(s"a + c > b : $a + $c > $b")
else
  println(a)

// while -> avoid while ofc
while (a < c+5)
  println(a)
  a += 1

// functions
// partial functions -> NOT defined for every value in the type

val A = List(1,2,5,10,2)
