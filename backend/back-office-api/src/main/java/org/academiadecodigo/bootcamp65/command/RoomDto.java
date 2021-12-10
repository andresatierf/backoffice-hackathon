package org.academiadecodigo.bootcamp65.command;

import org.academiadecodigo.bootcamp65.persistence.model.Place;
import org.academiadecodigo.bootcamp65.persistence.model.RoomType;

public class RoomDto {

    private int id;
    private RoomType roomType;
    private boolean occupied;
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
