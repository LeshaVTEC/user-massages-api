package by.it_academy.team1.usermassages.service.api;

import by.it_academy.team1.usermassages.core.dto.MessageDto;
import by.it_academy.team1.usermassages.core.entity.Message;
import by.it_academy.team1.usermassages.core.entity.User;

import java.util.List;

/**
 * @author makatrov_anton@mail.ru
 */
public interface IMessageService extends ICRUDService<Message>{
    List<Message> getMessagesOfUser(String username);

    void sendMessage(MessageDto message);
}
