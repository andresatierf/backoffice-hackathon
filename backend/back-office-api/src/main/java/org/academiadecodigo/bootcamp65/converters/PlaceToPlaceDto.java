package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.PlaceDto;
import org.academiadecodigo.bootcamp65.model.Place;

public class PlaceToPlaceDto extends AbstractConverter<Place, PlaceDto>{

    @Override
    public PlaceDto convert(Place place) {
        PlaceDto placeDto = new PlaceDto();

        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setLat(place.getLat());
        placeDto.setLon(place.getLon());

        return placeDto;
    }
}
