package by.ankudovich.service;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;
import by.ankudovich.mapper.UserMapper;
import by.ankudovich.repository.UserFileRepository;
import by.ankudovich.repository.UserRepository;

import java.util.List;

public class UserService {


    private List<User> users;

    public UserResponse register(UserRequest userRequest) {
        UserMapper userMapper = new UserMapper();
        UserRepository userFileRepository = new UserFileRepository();
        UserRole.Role role = userFileRepository.allUsers().isEmpty() ? UserRole.Role.ADMIN : UserRole.Role.USER;
        User user = userMapper.toEntity(userRequest);
        user=userFileRepository.add(user);
        return userMapper.toUserResponse(user);
    }

//    public UserResponse authentication(String login, String password) {
//        UserRepository userRepository =new UserFileRepository();
//
//        for (User user : users) {
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                return user;
//            }
//        }
//        throw new RuntimeException("ПОльзователь с таким логином не найден");
//
//    }

}

