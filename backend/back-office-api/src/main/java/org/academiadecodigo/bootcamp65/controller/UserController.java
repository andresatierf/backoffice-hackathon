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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private UserDtotoUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtotoUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUsers() {
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/filter"})
    public ResponseEntity<List<UserDto>> listFilteredUsers(@DateTimeFormat(pattern = "time") Long time, @RequestParam("duration") Integer duration, @RequestParam("room") RoomType roomType) {
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        List<UserDto> filteredDtos = new LinkedList<>();

        for(UserDto userDto: userDtos) {
            if (userDto.getTime() <= time && userDto.getDuration().equals(duration) && userDto.getRoomType() == roomType) {
                filteredDtos.add(userDto);
            }
        }

        filteredDtos.sort((t1, t2) -> (int) (t1.getTime() - t2.getTime()));

        System.out.println(time);
        return new ResponseEntity<>(filteredDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/filterage"})
    public ResponseEntity<List<UserDto>> listFilteredByAge(@RequestParam("minage") Integer minage, @RequestParam("maxage") Integer maxage) {
        System.out.println("list sout");
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        List<UserDto> filteredDtos = new LinkedList<>();

        for(UserDto userDto: userDtos) {
            if (userDto.getAge() >= minage && userDto.getMaxAge() <= maxage) {
                filteredDtos.add(userDto);
            }
        }

        return new ResponseEntity<>(filteredDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/bonkersfilter"})
    public ResponseEntity<List<UserDto>> bonkersFilter(@DateTimeFormat(pattern = "time") Long time, @RequestParam("duration") Integer duration, @RequestParam("room") RoomType roomType, @RequestParam("minage") Integer minage, @RequestParam("maxage") Integer maxage) {
        System.out.println("list sout");
        List<UserDto> userDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        List<UserDto> filteredDtos = new LinkedList<>();

        for(UserDto userDto: userDtos) {
            if (userDto.getTime() <= time && userDto.getDuration().equals(duration) && userDto.getRoomType() == roomType && userDto.getAge() >= minage && userDto.getAge() <= maxage) {
                filteredDtos.add(userDto);
            }
        }

        System.out.println(time);
        return new ResponseEntity<>(filteredDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/updatematch")
    public ResponseEntity<UserDto> editUserWithParams(@RequestBody UserDto userDto, @PathVariable Integer id) {

        userDto.setId(id);

        userService.save(userDtoToUser.convert(userDto));
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

        User savedUser = userService.save(userDtoToUser.convert(userDto));

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

        userService.save(userDtoToUser.convert(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
