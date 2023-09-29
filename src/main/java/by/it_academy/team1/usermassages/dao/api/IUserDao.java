package by.it_academy.team1.usermassages.dao.api;

import by.it_academy.team1.usermassages.core.entity.User;

import java.util.Map;

public interface IUserDao {
    void saveNewUser(User user);
    Map<Integer, User> getRegistrationUsers();
    User findUser(String username);
}
