package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> userList;

    public UserServiceImpl() {
        userList = new LinkedList<>();
    }

    public List<User> list() {
        for(User user: userList) {
            System.out.println(user.getName() + ", id: " + user.getId());
        }

        return userList;
    }

    public User save(User user) {
        userList.add(user);
        return user;
    }

    public void remove(Integer id) {
        for(User user: userList) {
            if (user.getId().equals(id)) {
                userList.remove(user);
            }
        }
    }

    public User update(User user) {
        remove(user.getId());
        save(user);

        return user;
    }

    public User get(Integer id) {
        for(User user: userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}
