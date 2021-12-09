package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.Room;
import org.academiadecodigo.bootcamp65.model.RoomType;

import java.util.LinkedList;
import java.util.List;

public class RoomsManager {

    private LinkedList<Room> roomsList;
    private LinkedList<Place> placeList;

    private PlaceService placeService;

    private Place place;

    public void set(PlaceService placeService){
        this.placeService = placeService;
    }

    public void createRoom(int placeId, RoomType roomType){

        place = placeService.get(placeId);

        roomsList = place.getRooms();

        int roomNr = roomsList.size();

        Room room = new Room();
        room.setId(roomNr++);
        room.setRoomType(roomType);

        place.addRoom(room);

    }

    public void deleteRoom(int placeId, int roomId){

        place = placeService.get(placeId);

        roomsList = place.getRooms();

        roomsList.remove(roomId);

        place.setList(roomsList);

    }
}

