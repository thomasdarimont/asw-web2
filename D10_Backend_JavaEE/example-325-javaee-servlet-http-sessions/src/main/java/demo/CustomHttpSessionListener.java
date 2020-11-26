package demo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("### Session erzeugt " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("### Session zerstört " + se.getSession().getId());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.printf("### Session Attribute hinzugefügt: name=%s value=%s%n", event.getName(), event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.printf("### Session Attribute entfernt: name=%s value=%s%n", event.getName(), event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.printf("### Session Attribute ersetzt: name=%s value=%s%n", event.getName(), event.getValue());
	}
}
