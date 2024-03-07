package by.ankudovich.mapper;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;

public class UserMapper {
    //метотд который записывает ответ,который формирует бэк.
    public UserResponse toUserResponse (User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setRole(user.getRole());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setLogin(user.getLogin());
        userResponse.setPassword(user.getPassword());
        return  userResponse;
    }

    //метод для работы с полями из фронта
    public User toEntity (UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        return user;
    }
}
