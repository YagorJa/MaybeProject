package by.ankudovich.service;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;
import by.ankudovich.mapper.UserMapper;
import by.ankudovich.repository.UserRepository;

import java.util.List;

public class UserService  {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(UserRequest userRequest) {
        String login = userRequest.getLogin();


        if (isLoginOccupied(login)) {
           throw new RuntimeException("Логин такой занят");
        }

        UserMapper userMapper = new UserMapper();
        UserRole.Role role = userRepository.allUsers().isEmpty() ? UserRole.Role.ADMIN : UserRole.Role.USER;
        User user = userMapper.toEntity(userRequest);
        user.setRole(role);
        user = userRepository.add(user);
        return userMapper.toUserResponse(user);
    }

    // Метод для проверки занятости логина
    private boolean isLoginOccupied(String login) {
        List<User> allUsers = (List<User>) userRepository.allUsers();
        for (User user : allUsers) {
            if (user.getLogin().equals(login)) {
                return true; // Логин занят
            }
        }
        return false; // Логин свободен
    }

    public void updateUser(long currentUserId, String name, String surname, String login, String password) {
        userRepository.updateUser(currentUserId,name,surname,login,password);
    }
}
