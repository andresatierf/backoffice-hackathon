package org.academiadecodigo.bootcamp65.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.academiadecodigo.bootcamp65.model.Car;
import org.academiadecodigo.bootcamp65.model.Room;

import java.sql.Time;
import java.util.Date;

@JsonIgnoreProperties
public class MatchDto {

    private Integer id;

    private Integer user1Id;
    private Integer user2Id;
    private Room room;

    private Car car;

    private Date date;
    private double finalPrice;

    private long time;
    private int duration;

    public Integer getId() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
