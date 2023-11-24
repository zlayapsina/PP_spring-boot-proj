package com.kata.PP_springbootproj.dao;



import com.kata.PP_springbootproj.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void saveUser(User user);
    void removeUser(long id);
    void editUser(User user);
    User showId(long id);
}
