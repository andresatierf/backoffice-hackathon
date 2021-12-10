package org.academiadecodigo.bootcamp65.persistence.model;

public enum RoomType {
    CEO_OFFICE(100),
    REGULAR_OFFICE(50),
    CAFETERIA(25),
    BAR(25),
    BATHROOM(15),
    GARAGE(10),
    CLEANING_ROOM(10),
    HALL(10),
    ELEVATOR(10),
    COMMON_ROOM(35),
    ARCHIVE(10),
    SERVER_ROOM(10);

    private double price;

    RoomType(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }


}
