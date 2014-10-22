name := "riemann-org.monitoring.riemann.war-artifact"

version := "1.0"

jetty()

resolvers ++= Seq(
  "Clojars" at "http://clojars.org/repo",
  "MavenCentral" at "http://repo1.maven.org/maven2/",
  "fusesource" at "http://repo.fusesource.com/nexus/content/groups/public/"
)


libraryDependencies ++= Seq(
  "com.boundary" % "high-scale-lib" % "1.0.6",
  "riemann" % "riemann" % "0.2.6",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"
)

// Publish to mavencentral
publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/tomer-ben-david/riemann-war-artifact</url>
    <licenses>
      <license>
        <name>BSD-style</name>
        <url>http://www.opensource.org/licenses/bsd-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:tomer-ben-david/riemann-war-artifact.git</url>
      <connection>scm:git:git@github.com:tomer-ben-david/riemann-war-artifact</connection>
    </scm>
    <developers>
      <developer>
        <id>tomer-ben-david</id>
        <name>Tomer Ben David</name>
        <url>http://tomer-ben-david.github.io</url>
      </developer>
    </developers>)
