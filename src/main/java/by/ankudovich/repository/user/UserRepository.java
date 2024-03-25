package by.ankudovich.repository.user;

import by.ankudovich.entity.User;

import java.util.Collection;

public interface UserRepository {
    public User add(User user);

    public void deleteUserById(long userId);

    public Collection<User> allUsers();

    public void updateUser(long id, String newName, String newSurname, String newLogin, String newPassword);

    public User authentication(String login, String password);

    public long userIdGenerator();

    User getUserById(Long userId);

    User findByLogin(String userLogin);
}
