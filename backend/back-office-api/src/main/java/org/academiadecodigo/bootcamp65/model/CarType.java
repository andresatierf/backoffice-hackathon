package org.academiadecodigo.bootcamp65.model;

import java.util.LinkedList;
import java.util.List;

public enum CarType {

    ECONOMY(15, "https://www.allcarsbrands.net/wp-content/uploads/2014/08/chery-QQ-cheap-car.png", "Economy"),
    NORMAL(30, "http://pngimg.com/uploads/volkswagen/volkswagen_PNG1794.png", "Normal"),
    LUXURY(100, "https://i.pinimg.com/originals/71/cf/73/71cf735975b977a92979975724d353b9.png", "Luxury");

    private int price;
    private String img;
    private String name;

    CarType(int price, String img, String name) {
        this.price = price;
        this.img = img;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Car> carList() {
        List<Car> cars = new LinkedList<>();
        for (CarType carType : CarType.values()) {
            Car car = new Car();
            car.setCarName(carType);
            car.setPrice(carType.price);
            car.setImg(carType.img);
            car.setName(carType.name);
            cars.add(car);
        }
        return cars;
    }
    public static class Car {
        private CarType carName;
        private double price;
        private String img;
        private String name;

        public CarType getCarName() {
            return carName;
        }

        public void setCarName(CarType carName) {
            this.carName = carName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
