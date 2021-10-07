

val greeting = "Hello, sbt! ^^"

@main def run(): Unit = println(greeting+true)

// incremental compilation
//sbt will compile only the changed file
//and the files that depend on it

//sbt :

//compile, run, console, test

//main concepts:
//1. settings : are evaluated only once,
//such as sourceDirectory, libraries, etc
//2. tasks: are evaluated at each invocation
//such as run, compile, publish, update, etc

//sbt file is written in scala, has just some keys
//libraryDependencies, scalaVersion, etc.

//plugins: sbt errors, sbt site