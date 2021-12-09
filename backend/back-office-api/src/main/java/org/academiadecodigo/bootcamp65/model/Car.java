package org.academiadecodigo.bootcamp65.model;

import java.util.ArrayList;
import java.util.List;

public class Car implements Model
{
    private Integer id;
    private String plate;
    private CarType carType;

    private List<Car> plates = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
       this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType cartype) {
        this.carType = cartype;
    }

    public List<Car> getPlates() {
        return plates;
    }
}
