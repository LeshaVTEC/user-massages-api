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
}
