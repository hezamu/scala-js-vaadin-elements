lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "scala-js-vaadin-components"

version := "0.1.0-SNAPSHOT"

organization := "org.vaadin.addons"

scalaVersion := "2.11.6"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"

homepage := Some(url("http://vaadin.com/components"))

licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

publishTo := Some(Resolver.file("GitHub", file("../hezamu.github.io/repository/snapshots")))
