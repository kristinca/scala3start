name := "scala3start"

version := "0.1"

scalaVersion := "3.0.2"

libraryDependencies += ("org.scalameta" %% "munit" % "0.7.29" % Test)
testFrameworks += TestFramework("munit.Framework")