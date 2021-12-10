package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userList = new HashMap<>();
    private Map<String, String> namePw = new HashMap<>();

    protected Integer getNextId() {
        return userList.isEmpty() ? 1 : Collections.max(userList.keySet()) + 1;
    }

    public List<User> list() {
        return new ArrayList<>(userList.values());
    }

    public User save(User user) {
        for(User userList: userList.values()) {
            System.out.println(userList.getName());
           if(userList.getName().equals(user.getName())) {
               System.out.println("not saved");
               return null;
           }
        }

        if (user.getId() == null) {
            user.setId(getNextId());
        }

        namePw.put(user.getName(), user.getPassword());

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

    public User getByName(String name) {
        for(User user: userList.values()) {
            if (user.getName().equals(name)) {
                System.out.println(name + "fuck");
                return user;
            }
        }
        return null;
    }

    @Override
    public Map getNamePW() {
        return namePw;
    }
}
