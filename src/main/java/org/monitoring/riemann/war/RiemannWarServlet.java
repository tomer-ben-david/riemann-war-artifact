package org.monitoring.riemann.war;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author tomerb
 * on 19/10/14.
 */
public class RiemannWarServlet extends GenericServlet {
    public void init(ServletConfig c) throws ServletException {
        RunMeEmbeedRiemannServer.startEmbeddedRiemannServer(c.getInitParameter("riemann.conf.filepath"));
    }

    @Override public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hmm nothing here, simple wrapper for init riemann inprocess");
    }
}
