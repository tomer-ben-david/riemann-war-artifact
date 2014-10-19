riemann-war-artifact
====================
So you would like to use [riemann](http://riemann.io) but your company uses tomcat/jetty .war deployments and would like to stay with same flavor.  There might be some good reasons for that (or not..).  For instance if your admins are used to monitor tomcat, and are already in the hang of it (have tweaked its memory, customized puppet module, permgen, whatever), it could be easier to persuade them to install a new .war rather than a whole new server.

In anyway if you are in this situation, here is a small project which would package riemann in a `.war` and thus you can simply start it in process with any tomcat/jetty other web server deployment you are having.

To have it working locally

1. git clone https://github.com/tomer-ben-david/riemann-war-artifact.git
2. sbt
3. container:start 

Basically this project is a simple server where in its init its starting up an embedded riemann.

So we have a simple `web.xml` which references this servlet and starts it upon its deployment:

```xml
<servlet>
    <servlet-name>RiemannWarServlet</servlet-name>
    <servlet-class>org.monitoring.riemann.war.RiemannWarServlet</servlet-class>
    <init-param><param-name>riemann.conf.filepath</param-name>
        <param-value>src/main/resources/riemann.conf</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
```

Then our `RiemannWarServlet` would just start up the embedded riemann.

```java
public void init(ServletConfig c) throws ServletException {
    RunMeEmbeedRiemannServer.startEmbeddedRiemannServer();
}

public static void startEmbeddedRiemannServer() {
    System.out.println("Starting up embedded riemann server...");
    riemann.bin.main(new String[]{"riemann.config"});
    System.out.println("Embedded riemann server started up...");
}    
```

See example startup:

<pre>
<b>~/dev/projects/riemann-war-artifact$ sbt</b>
[info] Loading project definition from ~/dev/projects/riemann-war-artifact/project
[info] Set current project to riemann-org.monitoring.riemann.war-artifact (in build file:~/dev/projects/riemann-war-artifact/)
> container:start
[info] starting server ...
[success] Total time: 1 s, completed Oct 19, 2014 3:02:04 PM
> 2014-10-19 15:02:04.780:INFO::main: Logging initialized @60ms
2014-10-19 15:02:04.786:INFO:oejr.Runner:main: Runner
2014-10-19 15:02:04.861:INFO:oejs.Server:main: jetty-9.2.1.v20140609
2014-10-19 15:02:09.003:WARN:oeja.AnnotationConfiguration:main: ServletContainerInitializers: detected. Class hierarchy: empty
<b>Starting up embedded riemann server...
loading bin
INFO [2014-10-19 15:02:13,112] main - riemann.bin - PID 6903
INFO [2014-10-19 15:02:13,286] clojure-agent-send-off-pool-4 - riemann.transport.websockets - Websockets server 127.0.0.1 5556 online
INFO [2014-10-19 15:02:13,286] clojure-agent-send-off-pool-1 - riemann.transport.tcp - TCP server 127.0.0.1 5555 online
INFO [2014-10-19 15:02:13,293] clojure-agent-send-off-pool-5 - riemann.transport.udp - UDP server 127.0.0.1 5555 16384 online
INFO [2014-10-19 15:02:13,294] main - riemann.core - Hyperspace core online
Embedded riemann server started up...
</b>
2014-10-19 15:02:13.295:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@2c59e61a{/,file:/~/dev/projects/riemann-war-artifact/target/webapp/,AVAILABLE}{file:~/dev/projects/riemann-war-artifact/target/webapp/}
2014-10-19 15:02:13.296:WARN:oejsh.RequestLogHandler:main: !RequestLog
2014-10-19 15:02:13.305:INFO:oejs.ServerConnector:main: Started ServerConnector@2f51e2fe{HTTP/1.1}{0.0.0.0:8080}
2014-10-19 15:02:13.305:INFO:oejs.Server:main: Started @8605ms
</pre>

vwalla, riemann is up in your jetty/tomcat conatiner as a deployable war.
