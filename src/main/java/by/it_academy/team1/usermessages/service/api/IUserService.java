package by.it_academy.team1.usermessages.service.api;

import by.it_academy.team1.usermessages.core.dto.UserRegistrationDto;

public interface IUserService {

    /**
     * При регистрации у пользователя роль Пользователь, зарегистрировать пользователя,
     * значит сохранить данные о нём в приложении.
     * @param dto DTO with User credentials
     */
    void saveNewUser(UserRegistrationDto dto);
    boolean uniquenessLoginCheck(String username);
}
