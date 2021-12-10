package org.academiadecodigo.bootcamp65.persistence.dao;

import org.academiadecodigo.bootcamp65.persistence.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends GenericDao<Room> {

    public RoomDao() {
        super(Room.class);
    }

}
