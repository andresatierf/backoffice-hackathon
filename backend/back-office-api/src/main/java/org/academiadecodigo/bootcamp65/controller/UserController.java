package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.converters.UserDtotoUser;
import org.academiadecodigo.bootcamp65.converters.UserToUserDto;
import org.academiadecodigo.bootcamp65.model.RoomType;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private UserDtotoUser userDtotoUser;
    private UserToUserDto userToUserDto;



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtotoUser(UserDtotoUser userDtotoUser) {
        this.userDtotoUser = userDtotoUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUsers() {
        System.out.println("list sout");
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/filter"})
    public ResponseEntity<List<UserDto>> listFilteredUsers(@DateTimeFormat(pattern = "time") Long time, @RequestParam("duration") Integer duration, @RequestParam("room") RoomType roomType) {
        System.out.println("list sout");
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        List<UserDto> filteredDtos = new LinkedList<>();

        for(UserDto userDto: userDtos) {
            if (userDto.getTime() <= time && userDto.getDuration().equals(duration) && userDto.getRoomType() == roomType) {
                filteredDtos.add(userDto);
            }
        }

        System.out.println(time);
        return new ResponseEntity<>(filteredDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/updatematch")
    public ResponseEntity<UserDto> editUserWithParams(@RequestBody UserDto userDto, @PathVariable Integer id) {

        userDto.setId(id);

        userService.save(userDtotoUser.convert(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDto> showUser(@PathVariable Integer id) {

        User user = userService.get(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userToUserDto.convert(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto, BindingResult bindingResult) {
        System.out.println("addinfg");

        /*if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/

        User savedUser = userService.save(userDtotoUser.convert(userDto));

        System.out.println("added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto, BindingResult bindingResult, @PathVariable Integer id) {

        /*if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userDto.getId() != null && !userDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/

        userDto.setId(id);

        userService.save(userDtotoUser.convert(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
