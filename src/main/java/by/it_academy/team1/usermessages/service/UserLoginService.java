package by.it_academy.team1.usermessages.service;

import by.it_academy.team1.usermessages.core.dto.UserLoginDto;
import by.it_academy.team1.usermessages.core.entity.User;
import by.it_academy.team1.usermessages.core.exceptions.UserNotFoundException;
import by.it_academy.team1.usermessages.dao.api.IUserDao;
import by.it_academy.team1.usermessages.dao.factory.UserDaoFactory;
import by.it_academy.team1.usermessages.service.api.IUserLoginService;

public class UserLoginService implements IUserLoginService {

    private static volatile UserLoginService instance;

    public static UserLoginService getInstance() {
        if (instance == null) {
            synchronized (UserLoginService.class) {
                if (instance == null) {
                    instance = new UserLoginService();
                }
            }
        }
        return instance;
    }

    IUserDao userDao = UserDaoFactory.getInstance();

    @Override
    public void authenticate(UserLoginDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Нет информации о пользователе");
        }
        if (dto.getUsername() == null) {
            throw new IllegalArgumentException("Нет информации о логине");
        } else if (dto.getPassword() == null) {
            throw new IllegalArgumentException("Нет информации о пароле");
        }

        User user = userDao.findUser(dto.getUsername());
        if (user == null) {
            throw new UserNotFoundException("Не существет такого пользователя");
        }
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new UserNotFoundException("Пароль был неверно введен");
        }


    }
}
