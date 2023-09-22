package by.it_academy.team1.usermassages.service;

import by.it_academy.team1.usermassages.core.dto.UserRegistrationDto;
import by.it_academy.team1.usermassages.core.entity.User;
import by.it_academy.team1.usermassages.dao.UserDao;
import by.it_academy.team1.usermassages.dao.api.IUserDao;
import by.it_academy.team1.usermassages.service.api.IUserService;

public class UserService implements IUserService {

    IUserDao userDao = UserDao.getInstance();
    @Override
    public void saveNewUser(UserRegistrationDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Нет информации о пользователе");
        }
        if (dto.getUsername() == null) {
            throw new IllegalArgumentException("Нет информации о логине");
        } else if (dto.getPassword() == null) {
            throw new IllegalArgumentException("Нет информации о пароле");
        } else if (dto.getFullName() == null) {
            throw new IllegalArgumentException("Нет информации о ФИО");
        } else if (dto.getBirthday() == null) {
            throw new IllegalArgumentException("Нет информации о дате рождения");
        }
        userDao.saveNewUser(new User(dto.getUsername(), dto.getPassword(), dto.getFullName(), dto.getBirthday()));
    }
}
