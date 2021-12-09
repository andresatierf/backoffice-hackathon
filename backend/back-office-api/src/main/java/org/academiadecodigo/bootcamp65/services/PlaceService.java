package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Place;

import java.util.LinkedList;
import java.util.List;

public class PlaceService {

    private List<Place> places = new LinkedList<>();

    public List<Place> list() {
        return places;
    }

    public Place get(int id) {
        return places.get(id);
    }

    public void add(Place place) {
        places.add(place);
    }

    public void remove(int id) {
        places.remove(places.get(id));
    }
}
