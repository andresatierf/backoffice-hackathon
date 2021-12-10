package org.academiadecodigo.bootcamp65.persistence.dao;

import org.academiadecodigo.bootcamp65.persistence.model.Place;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceDao extends GenericDao<Place>{

    public PlaceDao() {
        super(Place.class);
    }

}
