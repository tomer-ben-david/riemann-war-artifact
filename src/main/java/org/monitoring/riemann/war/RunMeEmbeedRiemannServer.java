package org.monitoring.riemann.war;

/**
 * @author tomerb
 * on 15/10/14.
 */
public class RunMeEmbeedRiemannServer {
    public static void startEmbeddedRiemannServer(String riemannConfPath) {
        System.out.println("Starting up embedded riemann server conf: " + riemannConfPath);
        riemann.bin.main(new String[]{riemannConfPath});
        System.out.println("Embedded riemann server started up...");
    }
}
