lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Vaadin Components wrapper for Scala.js"

normalizedName := "scalajs-vaadin-components"

version := "0.1.0-SNAPSHOT"

organization := "org.vaadin.addons"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.4", "2.11.6")

//resolvers += Resolver.url("scala-js-releases",
//  url("http://dl.bintray.com/scala-js/scala-js-releases/"))(
//    Resolver.ivyStylePatterns)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"

homepage := Some(url("http://vaadin.com/components"))

licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
