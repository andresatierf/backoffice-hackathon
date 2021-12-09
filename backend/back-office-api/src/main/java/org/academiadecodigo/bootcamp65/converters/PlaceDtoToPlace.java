package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.PlaceDto;
import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.services.PlaceService;

public class PlaceDtoToPlace extends AbstractConverter<PlaceDto, Place>{

    private PlaceService placeService;

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public Place convert(PlaceDto placeDto) {

        Place place = placeService.get(placeDto.getId()) != null ? placeService.get(placeDto.getId()) : new Place();

        place.setName(placeDto.getName());
        place.setLat(placeDto.getLat());
        place.setLon(placeDto.getLon());

        return place;
    }
}
