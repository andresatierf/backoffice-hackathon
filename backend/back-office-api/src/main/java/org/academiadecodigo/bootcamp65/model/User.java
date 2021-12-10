package org.academiadecodigo.bootcamp65.model;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String img;
    private String name;
    private Integer age;
    private GenderType gender;

    private int minAge;
    private int maxAge;

    private double lat;
    private double lon;

    private Integer rating;
    private Long time;
    private Integer duration;
    private RoomType roomType;

    private String description;
    private String location;
    private String password;

    public User() {
    }

    public User(Integer id, String img, String name, Integer age, GenderType gender, int minAge, int maxAge, Long time, Integer duration, RoomType roomType, String message, String location, String password) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.time = time;
        this.duration = duration;
        this.roomType = roomType;
        this.description = message;
        this.location = location;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
