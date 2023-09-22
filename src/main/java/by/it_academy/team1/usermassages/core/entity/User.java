package by.it_academy.team1.usermassages.core.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String username;
    private String password;
    private String fullName;
    private LocalDate birthday;
    private LocalDateTime registeredDate;
    private UserRole role;

    public User() {
    }

    public User(String username, String password, String fullName, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.registeredDate = LocalDateTime.now();
        this.role = UserRole.USER;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", registeredDate=" + registeredDate +
                ", role=" + role +
                '}';
    }

}
