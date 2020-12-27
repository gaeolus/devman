name := """play"""

version := ""

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
///   cache,
 /// javaWs
 "net.sf.barcode4j" % "barcode4j" % "2.1"

///  javaEbean,
//  "org.webjars" % "jquery" % "2.1.1",
//  "org.webjars" % "bootstrap" % "3.3.1",
  )

//libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.37"
//libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc4"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

libraryDependencies += evolutions

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//routesGenerator := InjectedRoutesGenerator

sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false
