package org.academiadecodigo.bootcamp65.persistence.model;

public enum CarType {

    ECONOMY(15),
    NORMAL(30),
    LUXURY(100);

    private int price;

    CarType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
