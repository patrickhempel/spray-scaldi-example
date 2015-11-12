name := "spray-scaldi"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-json"    % "1.3.2",
    "io.spray"            %%  "spray-routing-shapeless2" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
    "org.specs2"          %%  "specs2-core"   % "2.3.11",
    "org.scalatest"       %% "scalatest"      % "2.2.4",
    "org.scaldi" %% "scaldi" % "0.5.6",
    "org.scaldi" %% "scaldi-akka" % "0.5.6",
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )
}