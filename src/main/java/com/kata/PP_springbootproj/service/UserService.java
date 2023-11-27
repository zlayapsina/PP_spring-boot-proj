package com.kata.PP_springbootproj.service;
import com.kata.PP_springbootproj.model.User;
import com.kata.PP_springbootproj.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void removeUser(long id) {
        usersRepository.deleteById(id);
    }

    @Transactional
    public void editUser(long id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    public User showId(long id) {
        Optional<User> showedPerson = usersRepository.findById(id);
        return showedPerson.orElse(null);
    }

}
