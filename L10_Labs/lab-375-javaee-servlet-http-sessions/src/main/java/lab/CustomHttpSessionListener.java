package lab;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// @??? // YOURCODE use the proper Annotation for Session Listeners
public class CustomHttpSessionListener 
	// implements ??? { // YOURCODE use the proper interface for Http Session listeners
	{ // remove this line

	public void sessionCreated(HttpSessionEvent se) {
		// access the session id from the HttpSessionEvent
		System.out.println("Session erzeugt ID:" + se.get???().get???());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// access the session id from the HttpSessionEvent
		System.out.println("Session zerstört ID:" + se.get???().get???());
	}

}
