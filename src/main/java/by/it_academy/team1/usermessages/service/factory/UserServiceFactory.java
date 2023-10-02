package by.it_academy.team1.usermessages.service.factory;

import by.it_academy.team1.usermessages.dao.factory.UserDaoFactory;
import by.it_academy.team1.usermessages.service.UserService;
import by.it_academy.team1.usermessages.service.api.IUserService;

public class UserServiceFactory {

    private volatile static UserService instance;

    private UserServiceFactory() {
    }

    public static IUserService getInstance() {
        if(instance == null){
            synchronized (UserServiceFactory.class){
                if(instance == null){
                    instance = new UserService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
