package com.kata.PP_springbootproj.service;


import com.kata.PP_springbootproj.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    void removeUser(long id);
    void editUser(User user);
    User showId(long id);
}
