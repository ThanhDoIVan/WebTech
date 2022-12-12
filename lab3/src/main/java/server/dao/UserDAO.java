package server.dao;

import server.model.User;

public interface UserDAO {

    void printAll();

    User findUserByEmailAndPassword(String email, String password);
}
