package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.RoomDto;
import org.academiadecodigo.bootcamp65.model.Room;

public class RoomToRoomDto extends AbstractConverter<Room, RoomDto>{

    @Override
    public RoomDto convert(Room room) {
        RoomDto roomDto = new RoomDto();

        roomDto.setId(room.getId());
        roomDto.setOccupied(room.isOccupied());
        roomDto.setPlaceId(room.getPlaceId());
        roomDto.setRoomType(room.getRoomType());

        return roomDto;
    }

}
