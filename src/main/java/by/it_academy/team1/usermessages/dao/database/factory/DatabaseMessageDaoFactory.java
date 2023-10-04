package by.it_academy.team1.usermessages.dao.database.factory;

import by.it_academy.team1.usermessages.dao.api.IMessageDao;
import by.it_academy.team1.usermessages.dao.database.DatabaseMessageDao;
import by.it_academy.team1.usermessages.dao.memory.MemoryMessageDao;
import by.it_academy.team1.usermessages.dao.memory.factory.MemoryMessageDaoFactory;

public class DatabaseMessageDaoFactory {
    private volatile static DatabaseMessageDao instance;

    private DatabaseMessageDaoFactory() {
    }

    public static IMessageDao getInstance() {
        if(instance == null){
            synchronized (DatabaseMessageDaoFactory.class){
                if(instance == null){
                    instance = new DatabaseMessageDao();
                }
            }
        }
        return instance;
    }
}
