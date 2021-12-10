package org.academiadecodigo.bootcamp65.model;

import java.sql.Time;
import java.util.Date;

public class Match {

    private Integer id;

    private Integer user1Id;
    private Integer user2Id;
    private Room room;

    private Car car;

    private double finalPrice;

    private long time;
    private int duration;

    public Match() {
    }

    public Match(Integer id, Integer user1Id, Integer user2Id, Room room, Car car, double finalPrice, long time, int duration) {
        this.id = id;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.room = room;
        this.car = car;
        this.finalPrice = finalPrice;
        this.time = time;
        this.duration = duration;
    }

    public Integer getId() {
        if (id == null) {
            id = (int)(Math.random() * 100000000000L);
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
