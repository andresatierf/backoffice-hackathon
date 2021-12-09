package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.converters.UserDtotoUser;
import org.academiadecodigo.bootcamp65.converters.UserToUserDto;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    public UserDtotoUser getUserDtotoUser() {
        return userDtotoUser;
    }

    @Autowired
    public UserToUserDto getUserToUserDto() {
        return userToUserDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUsers() {

        List<UserDto> customerDtos = userService.list().stream()
                .map(customer -> userToUserDto.convert(customer))
                .collect(Collectors.toList());

        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
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
    public ResponseEntity<?> addCustomer(@RequestBody UserDto userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User savedUser = userService.save(userDtotoUser.convert(userDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedUser.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<UserDto> editCustomer(@RequestBody UserDto userDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userDto.getId() != null && !userDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDto.setId(id);

        userService.save(userDtotoUser.convert(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<UserDto> deleteCustomer(@PathVariable Integer id) {
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
