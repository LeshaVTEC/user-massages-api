package by.it_academy.team1.usermassages.service.api;

import by.it_academy.team1.usermassages.core.dto.UserLoginDto;

/**
 * @author qeliathus@gmail.com
 */
public interface IUserLoginService {

    /**
     * Если не нашли пользователя или не подошел пароль, выдать ошибку
     * Вход =сохранить в текущую сессию в атрибут user пользователя под которым вошли
     * @param dto DTO with credentials
     */
    void authenticate(UserLoginDto dto);
}
