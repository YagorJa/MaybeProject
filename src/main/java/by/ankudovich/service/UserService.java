package by.ankudovich.service;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.mapper.UserMapper;
import by.ankudovich.repository.user.UserRepository;
import by.ankudovich.repository.user.UserRepositoryJDBC;

import java.util.Collection;
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

    public void updateUser(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        userRepository.updateUser(user);
    }

    public UserResponse authentication(String login, String password) {
        UserResponse userResponse = new UserResponse();
        List<User> users = (List<User>) userRepository.allUsers();
        UserMapper userMapper = new UserMapper();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return userMapper.toUserResponse(user);
            }
            if (user.getLogin().equals(login) && !user.getPassword().equals(password)) {
                return userResponse;
            }
        }
        return null;

//            throw new RuntimeException("Пользователь с таким логином не найден");

        }

    public void deleteUserById(Long userId) {
        userRepository.deleteUserById(userId);
    }

    public UserResponse getUserByLogin(String userLogin) {
        UserMapper userMapper = new UserMapper();
        User user = userRepository.findByLogin(userLogin);
        if (user != null) {
            return userMapper.toUserResponse(user);
        } else {
            return null;
        }
    }


    public UserResponse getUserById(long userId) {
        UserMapper userMapper = new UserMapper();
        User user = userRepository.getUserById(userId);
        if (user != null) {
            return userMapper.toUserResponse(user);
        } else {
            return null;
        }
    }
    public Collection<User> allUsers() {
        return userRepository.allUsers();
    }

}