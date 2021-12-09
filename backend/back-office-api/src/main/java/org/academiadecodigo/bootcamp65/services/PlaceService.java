package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.Room;

import java.util.*;
import java.util.stream.Collectors;

public class PlaceService {

    private Map<Integer, Place> places = new HashMap<>();

    public List<Place> list() {
        return new ArrayList<>(places.values());
    }

    public Place get(int id) {
        return places.get(id);
    }

    public void add(Place place) {
        places.put(place.getId(), place);
    }

    public void remove(int id) {
        places.remove(id);
    }

    public void addRoom(Integer id, Room room) {
        Place place = get(id);

        if (place == null) {
            throw new NoSuchElementException();
        }

        place.addRoom(room);
    }
}
