package by.it_academy.team1.usermessages.dao.api;

import by.it_academy.team1.usermessages.core.entity.Message;

import java.util.List;

public interface IMessageDao {

    List<Message> get();

    void save(Message message);

}
