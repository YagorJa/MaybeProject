package by.ankudovich.service;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.mapper.UserMapper;
import by.ankudovich.repository.user.UserRepository;
import by.ankudovich.repository.user.UserRepositoryJDBC;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryJDBC();
    }

    public UserResponse register(UserRequest userRequest) {
        String login = userRequest.getLogin();

        if (isLoginOccupied(login)) {
            throw new RuntimeException("Логин такой занят");
        }

        UserMapper userMapper = new UserMapper();
//        UserRole.Role role = userRepository.allUsers().isEmpty() ? UserRole.Role.ADMIN : UserRole.Role.USER;
        User user = userMapper.toEntity(userRequest);
//        user.setRole(role);
        user = userRepository.add(user);
        return userMapper.toUserResponse(user);
    }


    private boolean isLoginOccupied(String login) {
        List<User> allUsers = (List<User>) userRepository.allUsers();
        for (User user : allUsers) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public void updateUser(long currentUserId, String name, String surname, String login, String password) {
        userRepository.updateUser(currentUserId, name, surname, login, password);
    }

    public UserResponse authentication(String login, String password) {
        List<User> users = (List<User>) userRepository.allUsers();
        UserMapper userMapper = new UserMapper();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return userMapper.toUserResponse(user);
            }
        }
            throw new RuntimeException("ПОльзователь с таким логином не найден");

        }

}