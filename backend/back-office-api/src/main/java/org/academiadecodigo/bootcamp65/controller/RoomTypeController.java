package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.RoomType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/roomtype")
public class RoomTypeController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List> listRooms() {
        return new ResponseEntity<>(RoomType.roomList(), HttpStatus.OK);
    }

}
