package server.dao;

import server.model.User;
import server.util.DBLoader;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    static List<User> userList = DBLoader.loadAllFromDB();

    @Override
    public void printAll(){
        userList.forEach(System.out::println);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
