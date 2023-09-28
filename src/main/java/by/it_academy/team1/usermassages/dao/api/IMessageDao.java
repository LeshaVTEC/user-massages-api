package by.it_academy.team1.usermassages.dao.api;

import by.it_academy.team1.usermassages.core.entity.Message;

import java.util.List;

public interface IMessageDao {

    List<Message> get();

    void save(Message message);

}
