package by.ankudovich.api.User;

import by.ankudovich.enums.UserRole;
import lombok.Data;

@Data

public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private UserRole.Role role;
}
