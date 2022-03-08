ThisBuild / useCoursier := false
organization := "com.iv"
scalaVersion := "2.13.8"
version := "0.1.0-SNAPSHOT"
name := "generator-demo"

// https://mvnrepository.com/artifact/org.apache.poi/poi
libraryDependencies ++= Seq("com.deepoove" % "poi-tl" % "1.11.1",
  "fr.opensagres.xdocreport" % "fr.opensagres.poi.xwpf.converter.pdf" % "2.0.3",
  // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-full
//  "org.apache.poi" % "poi-ooxml-full" % "5.2.0"
)
