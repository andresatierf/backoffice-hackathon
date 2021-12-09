package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.User;

public class UserToUserDto extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setAge(user.getAge());
        userDto.setDuration(user.getDuration());
        userDto.setGender(user.getGender());
        userDto.setId(user.getId());
        userDto.setLat(user.getLat());
        userDto.setLon(user.getLon());

        return userDto;
    }
}
