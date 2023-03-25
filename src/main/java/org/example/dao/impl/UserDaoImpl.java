package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.entity.User;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final List<User> userList;

    public UserDaoImpl() {
        userList = List.of(
                new User("user1"),
                new User("user2"),
                new User("user3")
        );
    }

    @Override
    public User getUserByName(String name) {
        return userList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return Collections.unmodifiableList(userList);
    }
}