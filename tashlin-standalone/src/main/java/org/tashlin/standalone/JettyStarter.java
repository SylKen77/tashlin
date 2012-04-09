package org.tashlin.standalone;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class JettyStarter {

	public static void main(String[] args) throws Exception {
		System.out.println("HELLO!");
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/tashlin");
		webapp.setWar("../war/tashlin-web.war");
		
		Server server = new Server(8090);
		server.setHandler(webapp);
        server.start();
        server.join();
		
	}
	
}
