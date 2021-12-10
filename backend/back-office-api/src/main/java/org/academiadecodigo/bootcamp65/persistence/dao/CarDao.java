package org.academiadecodigo.bootcamp65.persistence.dao;

import org.academiadecodigo.bootcamp65.persistence.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao extends GenericDao<Car>{

    public CarDao() {
        super(Car.class);
    }

}
