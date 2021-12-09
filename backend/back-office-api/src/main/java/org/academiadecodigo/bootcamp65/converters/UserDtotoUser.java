package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.UserService;

public class UserDtotoUser extends AbstractConverter<UserDto, User>{

    private UserService userService;

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

        return user;
    }
}
