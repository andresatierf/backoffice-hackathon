package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    void delete(Integer id);

    Car get(Integer id);

    List<Car> list();

}
