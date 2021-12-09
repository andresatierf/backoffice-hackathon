package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.PlaceDto;
import org.academiadecodigo.bootcamp65.command.RoomDto;
import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.Room;
import org.academiadecodigo.bootcamp65.services.PlaceService;
import org.academiadecodigo.bootcamp65.services.RoomsManager;

public class RoomDtotoRoom extends AbstractConverter<RoomDto, Room>{

    PlaceService placeService;
    RoomsManager roomsManager;

    public void setRoomsManager(RoomsManager roomsManager){
        this.roomsManager = roomsManager;
    }

    public void setPlaceService(PlaceService placeService){
        this.placeService = placeService;
    }

    @Override
    public Room convert(RoomDto roomDto) {

        Room room = placeService.get(roomDto.getId()) != null ? roomsManager.getRoom(roomDto.getPlaceId(), roomDto.getId()) : new Room();

        room.setRoomType(roomDto.getRoomType());
        room.setOccupied(roomDto.isOccupied());
        room.setPlaceId(roomDto.getPlaceId());
        room.setRoomType(roomDto.getRoomType());

        return room;
    }
}
