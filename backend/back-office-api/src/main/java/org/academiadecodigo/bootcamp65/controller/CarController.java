package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.model.CarType;
import org.academiadecodigo.bootcamp65.model.RoomType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cartype")
public class CarController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List> listRooms() {
        return new ResponseEntity<>(CarType.carList(), HttpStatus.OK);
    }

}
