package by.ankudovich.repository.exception;

public class UserNotFound extends RuntimeException {
    public long id;
    public UserNotFound(long id){
        super("Пользователь с таким ID " + id+ " не найден!");
    }
}
