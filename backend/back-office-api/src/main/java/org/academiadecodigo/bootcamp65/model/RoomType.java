package org.academiadecodigo.bootcamp65.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.LinkedList;
import java.util.List;

public enum RoomType {
    CEO_OFFICE(100, "https://cozyhouze.com/wp-content/uploads/2015/11/executive-office-desk-decor.jpg", "Ceo Office"),
    REGULAR_OFFICE(50, "https://www.officelovin.com/wp-content/uploads/2016/04/freshmail-office-6.jpg", "Regular Office"),
    CAFETERIA(25, "http://img4.wikia.nocookie.net/__cb20100126234526/theoffice/images/1/1d/BreakRoom.jpg", "Cafeteria"),
    BAR(25, "https://www.feedinspiration.com/wp-content/uploads/2015/07/Small-Home-Bar-Designs-Impressive-With-Picture-Of-Small-Home-Remodelling-Fresh-On-Ideas.jpg", "Bar"),
    BATHROOM(15, "https://www.nostraightnews.com/wp-content/uploads/2020/06/Bathroom.jpg", "Bathroom"),
    GARAGE(10, "", "Garage"),
    CLEANING_ROOM(10, "https://i.pinimg.com/736x/74/9c/ee/749cee702e7ba3c7457f41e4c3404e22.jpg", "Cleaning Room"),
    HALL(10, "https://www.officelovin.com/wp-content/uploads/2019/09/charter-hall-brisbane-office-4.jpg", "Hall"),
    ELEVATOR(10, "https://media.tehrantimes.com/d/t/2020/06/12/4/3474644.jpg", "Elevator"),
    COMMON_ROOM(35, "https://www.imperial.ac.uk/ImageCropToolT4/imageTool/uploaded-images/icimaoges--tojpeg_1448380557885_x2.jpg","Common Room"),
    ARCHIVE(10, "https://www.kangarooselfstorage.co.uk/wp-content/uploads/2018/12/Business-Storage-Archive-Storage-1.jpg", "Archive"),
    SERVER_ROOM(10, "https://i.pinimg.com/originals/f4/d1/8a/f4d18a2f6a460c3ab58b521144d1730d.jpg", "Server Room");

    private double price;
    private String img;
    private String name;

    RoomType(double price, String img, String name){
        this.price = price;
        this.img = img;
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getImg() {
        return img;
    }

    public String getName() { return name;}

    public static List<Room> roomList() {
        List<Room> rooms = new LinkedList<>();
        for (RoomType roomType:RoomType.values()) {
            Room room = new Room();
            room.setRoomName(roomType);
            room.setPrice(roomType.price);
            room.setImg(roomType.img);
            room.setName(roomType.name);
            rooms.add(room);
        }
        return rooms;
    }

    public static class Room {
        private RoomType roomName;
        private double price;
        private String img;
        private String name;

        public RoomType getRoomName() {
            return roomName;
        }

        public void setRoomName(RoomType roomName) {
            this.roomName = roomName;
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
