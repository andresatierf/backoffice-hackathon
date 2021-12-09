package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.Room;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class PlaceService {

    private List<Place> places = new LinkedList<>();

    public List<Place> list() {
        return places;
    }

    public Place get(int id) {
        return places.stream()
                .filter(place -> place.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    public void add(Place place) {
        places.add(place);
    }

    public void remove(int id) {
        places.remove(places.get(id));
    }

    public void addRoom(Integer id, Room room) {
        Place place = get(id);

        if (place == null) {
            throw new NoSuchElementException();
        }

        place.addRoom(room);
    }
}
