package by.it_academy.team1.usermassages.dao.factory;

import by.it_academy.team1.usermassages.dao.UserDao;
import by.it_academy.team1.usermassages.dao.api.IUserDao;

public class UserDaoFactory {
    private volatile static UserDao instance;

    private UserDaoFactory() {
    }

    public static IUserDao getInstance() {
        if(instance == null){
            synchronized (UserDaoFactory.class){
                if(instance == null){
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }
}
