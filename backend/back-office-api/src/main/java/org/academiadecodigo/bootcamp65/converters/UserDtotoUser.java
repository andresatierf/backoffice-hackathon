package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class UserDtotoUser extends AbstractConverter<UserDto, User>{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = userService.get(userDto.getId()) != null ? userService.get(userDto.getId()) : new User();

        user.setAge(userDto.getAge());
        user.setDuration(userDto.getDuration());
        user.setGender(userDto.getGender());
        user.setId(userDto.getId());
        user.setLat(userDto.getLat());
        user.setLon(userDto.getLon());
        user.setName(userDto.getName());
        user.setImg(userDto.getImg());
        user.setMinAge(userDto.getMinAge());
        user.setMaxAge(userDto.getMaxAge());
        user.setRating(userDto.getRating());
        user.setTime(userDto.getTime());
        user.setDuration(userDto.getDuration());
        user.setRoomType(userDto.getRoomType());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
