package by.it_academy.team1.usermessages.service;

import by.it_academy.team1.usermessages.core.dto.UserRegistrationDto;
import by.it_academy.team1.usermessages.core.entity.User;
import by.it_academy.team1.usermessages.dao.api.IUserDao;
import by.it_academy.team1.usermessages.service.api.IUserService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class UserService implements IUserService {

    private IUserDao userDao;


    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean uniquenessLoginCheck(String username) {
        Map<String, User> map = userDao.getRegistrationUsers();

        for (Map.Entry<String, User> entry : map.entrySet()) {

            if (entry.getValue().getUsername().equals(username)) {

                throw new IllegalArgumentException("Данный Логин уже зарегистрирован, попробуйте другой Логин");
            }
        } return true;
    }




    @Override
    public void saveNewUser(UserRegistrationDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Нет информации о пользователе");
        }
        if (StringUtils.isBlank(dto.getUsername())) {
            throw new IllegalArgumentException("Нет информации о логине");
        }
        if (StringUtils.isBlank(dto.getPassword())) {
            throw new IllegalArgumentException("Нет информации о пароле");
        }
        if (StringUtils.isBlank(dto.getFullName())) {
            throw new IllegalArgumentException("Нет информации о ФИО");
        }
        if (dto.getBirthday() == null) {
            throw new IllegalArgumentException("Нет информации о дате рождения");
        }
        if (this.uniquenessLoginCheck(dto.getUsername())) {
            userDao.saveNewUser(new User(dto.getUsername(), dto.getPassword(), dto.getFullName(), dto.getBirthday()));
        }
    }


}
