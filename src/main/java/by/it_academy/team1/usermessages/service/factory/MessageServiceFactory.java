package by.it_academy.team1.usermessages.service.factory;

import by.it_academy.team1.usermessages.dao.factory.MessageDaoFactory;
import by.it_academy.team1.usermessages.service.MessageService;
import by.it_academy.team1.usermessages.service.api.IMessageService;

public class MessageServiceFactory {
    private volatile static MessageService instance;

    private MessageServiceFactory() {
    }

    public static IMessageService getInstance() {
        if(instance == null){
            synchronized (MessageServiceFactory.class){
                if(instance == null){
                    instance = new MessageService(MessageDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
