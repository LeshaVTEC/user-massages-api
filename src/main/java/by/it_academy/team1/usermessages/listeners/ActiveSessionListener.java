package by.it_academy.team1.usermessages.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ActiveSessionListener implements HttpSessionListener {

    public static final String TOTAL_USERS_SESSION_KEY = "total_users_session";
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Object contextValue = context.getAttribute(TOTAL_USERS_SESSION_KEY);
        if (contextValue == null) {
            context.setAttribute(TOTAL_USERS_SESSION_KEY, 1);
        } else {
            context.setAttribute(
                    TOTAL_USERS_SESSION_KEY,
                    Integer.parseInt(contextValue.toString()) + 1
            );
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Object contextValue = context.getAttribute(TOTAL_USERS_SESSION_KEY);
        context.setAttribute(
                TOTAL_USERS_SESSION_KEY,
                Integer.parseInt((contextValue).toString()) - 1);
    }
}
