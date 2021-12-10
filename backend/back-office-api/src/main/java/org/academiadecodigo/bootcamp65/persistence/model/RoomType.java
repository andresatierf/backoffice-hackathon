package org.academiadecodigo.bootcamp65.persistence.model;

public enum RoomType {
    CEO_OFFICE(100, "https://cozyhouze.com/wp-content/uploads/2015/11/executive-office-desk-decor.jpg"),
    REGULAR_OFFICE(50, "https://www.officelovin.com/wp-content/uploads/2016/04/freshmail-office-6.jpg"),
    CAFETERIA(25, "http://img4.wikia.nocookie.net/__cb20100126234526/theoffice/images/1/1d/BreakRoom.jpg"),
    BAR(25, "https://www.feedinspiration.com/wp-content/uploads/2015/07/Small-Home-Bar-Designs-Impressive-With-Picture-Of-Small-Home-Remodelling-Fresh-On-Ideas.jpg"),
    BATHROOM(15, "https://www.nostraightnews.com/wp-content/uploads/2020/06/Bathroom.jpg"),
    GARAGE(10, ""),
    CLEANING_ROOM(10, "https://i.pinimg.com/736x/74/9c/ee/749cee702e7ba3c7457f41e4c3404e22.jpg"),
    HALL(10, "https://www.officelovin.com/wp-content/uploads/2019/09/charter-hall-brisbane-office-4.jpg"),
    ELEVATOR(10, "https://media.tehrantimes.com/d/t/2020/06/12/4/3474644.jpg"),
    COMMON_ROOM(35, "https://www.imperial.ac.uk/ImageCropToolT4/imageTool/uploaded-images/icimaoges--tojpeg_1448380557885_x2.jpg"),
    ARCHIVE(10, "https://www.kangarooselfstorage.co.uk/wp-content/uploads/2018/12/Business-Storage-Archive-Storage-1.jpg"),
    SERVER_ROOM(10, "https://i.pinimg.com/originals/f4/d1/8a/f4d18a2f6a460c3ab58b521144d1730d.jpg");

    private double price;
    private String img;

    RoomType(double price, String img){
        this.price = price;
        this.img = img;
    }

    public double getPrice(){
        return this.price;
    }

    public String getImg() {
        return img;
    }
}
