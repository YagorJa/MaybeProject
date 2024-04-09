package by.ankudovich.api.User;

import by.ankudovich.enums.UserRole;
import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;

    public UserRequest(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public UserRequest() {

    }
}
