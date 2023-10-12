package by.it_academy.team1.usermessages.service.api;

import by.it_academy.team1.usermessages.core.dto.MessageDto;
import by.it_academy.team1.usermessages.core.entity.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @author makatrov_anton@mail.ru
 */
public interface IMessageService extends ICRUDService<Message> {
    List<Message> getMessagesOfUser(String username) throws SQLException;

    void sendMessage(MessageDto message);
}
