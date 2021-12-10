package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> list();

    User save(User user);

    void remove(Integer id);

    User update(User user);

    User get(Integer id);

    User getByName(String name);

    Map getNamePW();
}
