package by.it_academy.team1.usermessages.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

public class ActiveSessionUsersListener implements HttpSessionAttributeListener {

    private static final String TOTAL_USERS_KEY = "totalusers";

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        ServletContext context = event.getSession().getServletContext();
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
    public void attributeRemoved(HttpSessionBindingEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Object contextValue = context.getAttribute(TOTAL_USERS_KEY);
        context.setAttribute(TOTAL_USERS_KEY, Integer.parseInt(contextValue.toString()) - 1);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
