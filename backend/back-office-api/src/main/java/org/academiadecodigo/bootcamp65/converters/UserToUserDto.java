package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.User;

public class UserToUserDto extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto userDto = new UserDto();

        userDto.setAge(source.getAge());
        userDto.setDuration(source.getDuration());
        userDto.setGender(source.getGender());
        userDto.setId(source.getId());
        userDto.setLat(source.getLat());
        userDto.setLon(source.getLon());

        return userDto;
    }
}
