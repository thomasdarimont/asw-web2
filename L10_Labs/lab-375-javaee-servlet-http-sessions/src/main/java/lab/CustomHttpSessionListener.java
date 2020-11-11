package lab;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@???
public class CustomHttpSessionListener implements ??? {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session erzeugt ID:" + se.get???().get???());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session zerstört ID:" + se.get???().get???());
	}

}
