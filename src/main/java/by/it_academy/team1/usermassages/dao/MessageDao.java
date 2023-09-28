package by.it_academy.team1.usermassages.dao;

import by.it_academy.team1.usermassages.core.entity.Message;
import by.it_academy.team1.usermassages.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {
    private List<Message> data = new ArrayList<>();

    @Override
    public List<Message> get() {
        return this.data;
    }

    @Override
    public void save(Message message) {
        // Добавьте новое сообщение в список
        this.data.add(message);
    }
}
