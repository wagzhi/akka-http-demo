name := "akka-http-demo"

version := "0.1"

scalaVersion := "2.12.2"

lazy val versions = new {
  val scalaVersion = "2.12.4"
  val inject = "1"
  val guice = "4.1.0"
  val akkaHttp = "10.0.11"
  val scalamock = "4.0.0"
  val scalatest = "3.0.5"
  val spray = "1.3.4"
  val slick = "3.2.1"
}

libraryDependencies ++= Seq(
  "javax.inject" % "javax.inject" % versions.inject,
  "com.google.inject" % "guice" % versions.guice,
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
  "io.spray" %% "spray-json" % versions.spray,
  "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
  "com.typesafe.akka" %% "akka-parsing" % versions.akkaHttp,

  //mysql
  "com.h2database" % "h2" % "1.4.187",
  "com.typesafe.slick" %% "slick" % versions.slick,
  "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,

  //test
  "org.scalatest" %% "scalatest" % versions.scalatest % Test
)

mainClass := Some("web.WebServer")
