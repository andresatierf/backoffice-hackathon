package org.academiadecodigo.bootcamp65.persistence.model;

public enum CarType {

    ECONOMY(15, "https://www.allcarsbrands.net/wp-content/uploads/2014/08/chery-QQ-cheap-car.png"),
    NORMAL(30, "http://pngimg.com/uploads/volkswagen/volkswagen_PNG1794.png"),
    LUXURY(100, "https://i.pinimg.com/originals/71/cf/73/71cf735975b977a92979975724d353b9.png");

    private int price;
    private String img;

    CarType(int price, String img) {
        this.price = price;
        this.img = img;
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
}
