package org.academiadecodigo.bootcamp65;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.services.PlaceService;

public class Main {
    public static void main(String[] args) {

        PlaceService placeService = new PlaceService();

        Place place = new Place();

        place.setId(2);

        placeService.add(place);

        System.out.println(place);
        System.out.println(placeService.list());

        placeService.remove(place.getId());

        System.out.println("empty-");
        System.out.println(placeService.list());
    }
}
