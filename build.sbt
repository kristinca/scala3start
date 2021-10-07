name := "scala3start"

version := "0.1"

scalaVersion := "3.0.2"

libraryDependencies += ("org.scalameta" %% "munit" % "0.7.29" % Test)
testFrameworks += TestFramework("munit.Framework")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.4.1")

unmanagedSources / includeFilter := new io.ExtensionFilter(
  "java"
  "scala"
  "sc"
)

makeSite / mappings := {
val indexFile = target.value / "index.html"
  IO.write(indexFile,"<h1>Hello, sbt!</h1>")
  Seq(indexFile -> "index.html")

}