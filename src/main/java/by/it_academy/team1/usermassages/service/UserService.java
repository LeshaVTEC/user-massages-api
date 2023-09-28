package by.it_academy.team1.usermassages.service;

import by.it_academy.team1.usermassages.core.dto.UserRegistrationDto;
import by.it_academy.team1.usermassages.core.entity.User;
import by.it_academy.team1.usermassages.dao.UserDao;
import by.it_academy.team1.usermassages.dao.api.IUserDao;
import by.it_academy.team1.usermassages.service.api.IUserService;

import java.util.Map;

public class UserService implements IUserService {

    private static boolean uniquenessLoginCheck(String username) {
        Map<Integer, User> map = UserDao.getRegistrationUsers();

        for (Map.Entry<Integer, User> entry : map.entrySet()) {

            if (entry.getValue().getUsername().equals(username)) {

                throw new IllegalArgumentException("Данный Логин уже зарегистрирован, попробуйте другой Логин");
            }
        } return true;
    }

    private IUserDao userDao;
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

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
        if (UserService.uniquenessLoginCheck(dto.getUsername()))
        userDao.saveNewUser(new User(dto.getUsername(), dto.getPassword(), dto.getFullName(), dto.getBirthday()));
    }


}
