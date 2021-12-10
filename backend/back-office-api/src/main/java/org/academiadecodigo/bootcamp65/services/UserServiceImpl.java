package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userList = new HashMap<>();

    protected Integer getNextId() {
        return userList.isEmpty() ? 1 : Collections.max(userList.keySet()) + 1;
    }

    public List<User> list() {
        return new ArrayList<>(userList.values());
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(getNextId());
        }

        userList.put(user.getId(), user);
        return user;
    }

    public void remove(Integer id) {
        userList.remove(id);
    }

    public User update(User user) {
        save(user);

        return user;
    }

    public User get(Integer id) {
        return userList.get(id);
    }
}
