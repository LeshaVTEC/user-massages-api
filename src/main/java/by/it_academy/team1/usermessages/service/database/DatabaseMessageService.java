package by.it_academy.team1.usermessages.service.database;

import by.it_academy.team1.usermessages.core.dto.MessageDto;
import by.it_academy.team1.usermessages.core.entity.Message;
import by.it_academy.team1.usermessages.dao.api.IMessageDao;
import by.it_academy.team1.usermessages.service.api.IMessageService;

import java.util.List;

public class DatabaseMessageService implements IMessageService {

    IMessageDao messageDao;
    public DatabaseMessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> getMessagesOfUser(String username) {
        return null;
    }

    @Override
    public void sendMessage(MessageDto message) {

    }

    @Override
    public List<Message> get() {
        return null;
    }
}
