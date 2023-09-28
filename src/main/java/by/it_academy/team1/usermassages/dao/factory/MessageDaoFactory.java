package by.it_academy.team1.usermassages.dao.factory;

import by.it_academy.team1.usermassages.dao.MessageDao;
import by.it_academy.team1.usermassages.dao.api.IMessageDao;

public class MessageDaoFactory {
    private volatile static MessageDao instance;

    private MessageDaoFactory() {
    }

    public static IMessageDao getInstance() {
        if(instance == null){
            synchronized (MessageDaoFactory.class){
                if(instance == null){
                    instance = new MessageDao();
                }
            }
        }
        return instance;
    }
}
