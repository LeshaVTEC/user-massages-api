package by.it_academy.team1.usermassages.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ActiveSessionListener implements HttpSessionListener {

    private static final String TOTAL_USERS_KEY = "totalusers";
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Object contextValue = context.getAttribute(TOTAL_USERS_KEY);
        if (contextValue == null) {
            context.setAttribute(TOTAL_USERS_KEY, 1);
        } else {
            context.setAttribute(
                    TOTAL_USERS_KEY,
                    Integer.parseInt(contextValue.toString()) + 1
            );
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Object contextValue = context.getAttribute(TOTAL_USERS_KEY);
        context.setAttribute(
                TOTAL_USERS_KEY,
                Integer.parseInt((contextValue).toString()) - 1);
    }
}
