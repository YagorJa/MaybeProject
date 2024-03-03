package by.ankudovich.repository;

import by.ankudovich.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements ShopRepository {
    private final String filename = "C:\\tms\\TempDz4\\src\\main\\resources\\Users";
    private List<User> users;
    public UserRepository() {
        users = deserializeUser();
    }
    @Override
    public void add(User user) {

        List<User> users = allUsers();
//        if (users.isEmpty()) {
//            user.setRole(User.Role.ADMIN);
//        }else {
//            user.setRole(User.Role.USER);
//        }

        users.add(user);

        serializeUser();
        }


    @Override
    public void deleteUserById(long userId) {
        users.removeIf(userOk -> userOk.getId().equals(userId));
        serializeUser();
    }

    @Override
    public List<User> allUsers() {
        return users;
    }

    public User authentication(String login, String password){
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
               return user;
            }
        }
        throw new RuntimeException("ПОльзователь с таким логином не найден");

    }
    public long userIdGenerator() {
        long lastId = 0;
        List<User> users = allUsers();
        if (!users.isEmpty()) {
            lastId = users.get(users.size() - 1).getId();
        }
        return lastId + 1;
    }
    private void serializeUser() {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(users);

            out.close();
            file.close();

            System.out.println("Юзеры были сериализованы");
        } catch (IOException ex) {
            throw new RuntimeException("Юзеры не сериализовались",ex);
        }

    }
    private List<User> deserializeUser() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<User> deserUsers = (List<User>) ois.readObject();
            return deserUsers;


        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException("файл не найден");
        }
        return new ArrayList<>();
    }

}