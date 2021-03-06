name := """christmas"""

organization := "com.jamesneve"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.4", "2.11.7")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

import bintray.Keys._

lazy val commonSettings = Seq(
  version := "0.0.1",
  organization := "com.jamesneve"
)

lazy val root = (project in file(".")).
  settings(commonSettings ++ bintrayPublishSettings: _*).
  settings(
    sbtPlugin := true,
    name := "Christmas",
    description := "Implementation of the presenter pattern for Play 2.4",
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    publishMavenStyle := false,
    repository := "sbt-plugins",
    bintrayOrganization in bintray := None
  )

com.typesafe.sbt.SbtGit.versionWithGit
