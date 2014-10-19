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

