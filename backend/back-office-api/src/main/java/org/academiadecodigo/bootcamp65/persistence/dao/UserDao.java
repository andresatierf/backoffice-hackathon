package org.academiadecodigo.bootcamp65.persistence.dao;

import org.academiadecodigo.bootcamp65.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User>{

    public UserDao() {
        super(User.class);
    }

}
