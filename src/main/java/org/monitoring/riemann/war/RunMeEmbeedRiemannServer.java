package org.monitoring.riemann.war;

/**
 * @author tomerb
 * on 15/10/14.
 */
public class RunMeEmbeedRiemannServer {
    public static void startEmbeddedRiemannServer() {
        System.out.println("Starting up embedded riemann server...");
        riemann.bin.main(new String[]{"riemann.config"});
        System.out.println("Embedded riemann server started up...");
    }
}
