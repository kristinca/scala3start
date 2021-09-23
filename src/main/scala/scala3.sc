
import scala.io.Codec.fallbackSystemCodec.name

// this is scala 3.0.2 ^^

// My work and notes from the book "Programming in Scala"
// by Martin Odersky, Lex Spoon, and Bill Venners
// && Effective Programming in Scala
// && other random web examples :D

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

// Iterable

object Main
def main(args: Array[String]): Unit =
{
  println(Iterable(6,5,6))
  println(Seq(3,3,2))
}

//Iterable have dynamic size
//sequences -> immutable; ordered collections
//sets -> unordered; unique elements
//maps -> sets of keys and associated values
// like dictionaries python huh?

// Lists

/*case class AddressBook (contacts: List[String]):
  case class Contact {
    name: String
    email: String
    phone numbers: List[String]
  }

// we can nest list in list:
// ex. List[List[Int]]

val matjaz = Contact("Matjaz", "matjaz@neki.si", List())
val mojca = Contact("Mojca", "mojca@neki.si", List("+123456789"))
val AddresBook(List(matjaz,mojca))

// list size -> .size -> returns Int
val numberofcontacts: Int = AddressBook.contacts.size

// specific element -> .contains ->returns Boolean
val isMojcaInContacts = AddressBook.contains(mojca)

// transforming a list -> getting a list out of a list
// .map -> returns a list of elements
AddressBook.contacts.map(contact => name)

// .filter -> returns someth specific
AddressBook.contacts.filter(contact => contact.phoneNumbers.nonEmpty)
*/
// .apply method

// match .... case _ means all other not possible cases

// index of a list aaa YEEEYYYY THIS IS IIIITTT AAAA :D
val fruits = List("apples","oranges","pears")

fruits.head == "apples"
fruits.tail.head == "oranges"
fruits.tail == List("pears", "oranges")
fruits(0) == "apples"
fruits(2) == "oranges"

// methods on list vs complexity
// ::   Constant time
// head    Constant time
// tail    Constant time
// Random access   Linear time
// size     Linear time

// Collections :
// List is an immutable sequence
// ArrayBuffer is a mutable sequence
// Map is a immutable dictionary
import scala.collection.mutable

List.empty[Int]
mutable.ArrayBuffer.empty[Double]
Map.empty[String, Boolean]
//the first type : string is the key type,
// boolean is the value type

// +:  adds an element to the front of the list
// :+  adds an element to the tail of the list
// in map we add w/ +
// find returns the FIRST ELEMENT that maches a predicate
// filter returns ALL OF THE ELEMENTS that match a predicate
// isEmpty , nonEmpty
// contains

// flatMap  to change the number of elements in a collections
// map and flatMap return collection as a result
// foldLeft transforms a collection to any other type
// GroupBy groups the elements of a collection ...
// ... acording to a partition function
// sortBy to sort a sequence

// Option[String]


// Loops
// for (s) yield e
// for (x <- e1 if f; s) yield e2
// for (x <- e1.withFilter(x => f); s) yield e2
// e1.foreach(x =>) does not return a new collection
