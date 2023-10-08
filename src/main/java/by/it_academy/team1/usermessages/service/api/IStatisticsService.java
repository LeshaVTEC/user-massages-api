package by.it_academy.team1.usermessages.service.api;

import java.util.Map;

public interface IStatisticsService {
    Map<String, Integer> getStats();
    Integer incSessionCount();
    Integer decSessionCount();
    Integer getSessionCount();

}

