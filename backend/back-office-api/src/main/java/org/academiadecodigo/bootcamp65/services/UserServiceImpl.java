package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> userList;

    private UserServiceImpl() {
        userList = new LinkedList<>();
    }

    public List<User> list() {
        for(User user: userList) {
            System.out.println(user.getName());
        }

        return userList;
    }

    public User save(User user) {
        userList.add(user);

        return user;
    }

    public void remove(int id) {
        for(User user: userList) {
            if (user.getId() == id) {
                userList.remove(user);
            }
        }
    }

    public User update(User user) {
        remove(user.getId());
        save(user);

        return user;
    }

    public User get(int id) {
        for(User user: userList) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
