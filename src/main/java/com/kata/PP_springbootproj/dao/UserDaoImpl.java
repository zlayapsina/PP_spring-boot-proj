package com.kata.PP_springbootproj.dao;

import com.kata.PP_springbootproj.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User showId(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
       em.persist(user);
    }

    @Override
    public void removeUser(long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void editUser(User editedUser) {
        em.merge(editedUser);
    }
}
