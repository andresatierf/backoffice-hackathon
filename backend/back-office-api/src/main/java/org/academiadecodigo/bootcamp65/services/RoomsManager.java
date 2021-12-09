package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.Room;
import org.academiadecodigo.bootcamp65.model.RoomType;

import java.util.LinkedList;
import java.util.List;

public class RoomsManager {

    private List<Room> roomsList;
    private LinkedList<Place> placeList;

    private PlaceService placeService;

    private Place place;

    public void setPlaceService(PlaceService placeService){
        this.placeService = placeService;
    }

    public void createRoom(int placeId, RoomType roomType){

        place = placeService.get(placeId);

        roomsList = place.getRoomList();

        int roomNr = roomsList.size();

        Room room = new Room();
        room.setId(roomNr++);
        room.setRoomType(roomType);
        room.setPlaceId(placeId);

        placeService.addRoom(placeId, room);

    }

    public void deleteRoom(int placeId, int roomId){

        place = placeService.get(placeId);

        place.removeRoom(roomId);

    }

    public Room getRoom(int placeId, int roomId){

        place = placeService.get(placeId);

        return place.getRoom(roomId);

    }

    public int getRoomPlace(Room room){
        return room.getPlaceId();
    }
}

