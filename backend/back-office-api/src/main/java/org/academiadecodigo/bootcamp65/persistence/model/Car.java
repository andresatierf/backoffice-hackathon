package org.academiadecodigo.bootcamp65.persistence.model;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Repository;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car implements Model {
    private Integer id;
    private String plate;
    private CarType carType;

    @Id
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

}
