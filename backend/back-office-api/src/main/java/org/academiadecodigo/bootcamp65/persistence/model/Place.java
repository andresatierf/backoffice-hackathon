package org.academiadecodigo.bootcamp65.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "place")
public class Place {

    private Integer id;
    private String name;

    private double lat;
    private double lon;

    @OneToMany(
        cascade = {CascadeType.ALL},

        orphanRemoval = true,

        mappedBy = "place",

        fetch = FetchType.EAGER
    )
    private List<Room> roomList = new ArrayList<>();

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public Room getRoom(int id) {
        return roomList.stream()
                .filter(room -> room.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    public void removeRoom(int id) {
        roomList = roomList.stream()
                .filter(room -> room.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

}
