package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.model.User;

public class UserDtotoUser extends AbstractConverter<UserDto, User>{

    @Override
    public User convert(UserDto source) {
        User user = new User();

        user.setAge(source.getAge());
        user.setDuration(source.getDuration());
        user.setGender(source.getGender());
        user.setId(source.getId());
        user.setLat(source.getLat());
        user.setLon(source.getLon());

        return user;
    }
}
