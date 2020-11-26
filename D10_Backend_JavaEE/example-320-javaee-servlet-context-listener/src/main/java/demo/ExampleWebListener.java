package demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ExampleWebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// Here you can add code that should run when your application starts
		System.out.println("### Web App Started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		// Here you can add code that should run when your application stops
		System.out.println("### Web App Destroyed");
	}
}
