package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Car;

import java.util.*;

public class CarServiceImpl implements CarService {

    private Map<Integer, Car> carMap = new HashMap<>();

    protected Integer getNextId() {
        return carMap.isEmpty() ? 1 : Collections.max(carMap.keySet()) + 1;
    }

    @Override
    public Car save(Car car) {

        if (car.getId() == null) {
            car.setId(getNextId());
        }

        carMap.put(car.getId(), car);
        return car;
    }

    @Override
    public Car get(Integer id) {
        return carMap.get(id);
    }

    @Override
    public void delete(Integer id) {
        carMap.remove(id);
    }

    @Override
    public List<Car> list() {
        return new ArrayList<>(carMap.values());
    }

    }
