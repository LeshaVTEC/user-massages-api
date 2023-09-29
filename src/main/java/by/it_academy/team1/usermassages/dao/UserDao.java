package by.it_academy.team1.usermassages.dao;

import by.it_academy.team1.usermassages.core.entity.User;
import by.it_academy.team1.usermassages.core.entity.UserRole;
import by.it_academy.team1.usermassages.dao.api.IUserDao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {

    private static Map<Integer, User> registrationUsers = new HashMap<>(

            Map.of(
            0, createAdmin()
    ));


    private static User createAdmin() {
        User admin = new User();
        admin.setUsername("Admin");
        admin.setPassword("Admin");
        admin.setFullName("Admin A.A.");
        admin.setBirthday(LocalDate.of(2000,01,01));
        admin.setRole(UserRole.ADMIN);
        admin.setRegisteredDate(LocalDateTime.now());
        return admin;
    }

    @Override
    public Map<Integer, User> getRegistrationUsers() {
        return registrationUsers;
    }


    @Override
    public void saveNewUser(User user) {
        Integer key = 1;
        registrationUsers.put(key, user);
        key = key + 1;
    }

    @Override
    public User findUser(String username) {
        for (Map.Entry<Integer, User> entry : registrationUsers.entrySet()) {
            if (entry.getValue().getUsername().equals(username)) {
                return entry.getValue();
            }
        }
        return null;
    }

}
