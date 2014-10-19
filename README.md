riemann-war-artifact
====================
check out the project then use sbt to start up the container


~/dev/projects/riemann-war-artifact$ sbt
[info] Loading project definition from ~/dev/projects/riemann-war-artifact/project
[info] Set current project to riemann-org.monitoring.riemann.war-artifact (in build file:~/dev/projects/riemann-war-artifact/)
> container:start
[info] starting server ...
[success] Total time: 1 s, completed Oct 19, 2014 3:02:04 PM
> 2014-10-19 15:02:04.780:INFO::main: Logging initialized @60ms
2014-10-19 15:02:04.786:INFO:oejr.Runner:main: Runner
2014-10-19 15:02:04.861:INFO:oejs.Server:main: jetty-9.2.1.v20140609
2014-10-19 15:02:09.003:WARN:oeja.AnnotationConfiguration:main: ServletContainerInitializers: detected. Class hierarchy: empty
Starting up embedded riemann server...
loading bin
INFO [2014-10-19 15:02:13,112] main - riemann.bin - PID 6903
INFO [2014-10-19 15:02:13,286] clojure-agent-send-off-pool-4 - riemann.transport.websockets - Websockets server 127.0.0.1 5556 online
INFO [2014-10-19 15:02:13,286] clojure-agent-send-off-pool-1 - riemann.transport.tcp - TCP server 127.0.0.1 5555 online
INFO [2014-10-19 15:02:13,293] clojure-agent-send-off-pool-5 - riemann.transport.udp - UDP server 127.0.0.1 5555 16384 online
INFO [2014-10-19 15:02:13,294] main - riemann.core - Hyperspace core online
Embedded riemann server started up...
2014-10-19 15:02:13.295:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@2c59e61a{/,file:/~/dev/projects/riemann-war-artifact/target/webapp/,AVAILABLE}{file:~/dev/projects/riemann-war-artifact/target/webapp/}
2014-10-19 15:02:13.296:WARN:oejsh.RequestLogHandler:main: !RequestLog
2014-10-19 15:02:13.305:INFO:oejs.ServerConnector:main: Started ServerConnector@2f51e2fe{HTTP/1.1}{0.0.0.0:8080}
2014-10-19 15:02:13.305:INFO:oejs.Server:main: Started @8605ms


vwalla, riemann is up in your jetty/tomcat conatiner as a deployable war.
