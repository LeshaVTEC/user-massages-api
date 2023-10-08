package by.it_academy.team1.usermessages.listeners;

import by.it_academy.team1.usermessages.service.StatisticsService;
import by.it_academy.team1.usermessages.service.api.IStatisticsService;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class ActiveSessionUsersListener implements HttpSessionAttributeListener {
    private final IStatisticsService statisticsService = StatisticsService.getInstance();


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
//        if("user".equalsIgnoreCase(event.getName()) && event.getValue() != null){
        var servletContext = event.getSession().getServletContext();
        servletContext.log("attributeAdded: " + event.getName() + event.getValue());
            this.statisticsService.incSessionCount();
//        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if("user".equalsIgnoreCase(event.getName())){
            this.statisticsService.decSessionCount();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
