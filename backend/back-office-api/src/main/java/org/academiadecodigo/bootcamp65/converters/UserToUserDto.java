package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
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
        userDto.setName(user.getName());
        userDto.setImg(user.getImg());
        userDto.setMinAge(user.getMinAge());
        userDto.setMaxAge(user.getMaxAge());
        userDto.setRating(user.getRating());
        userDto.setTime(user.getTime());
        userDto.setDuration(user.getDuration());
        userDto.setRoomType(user.getRoomType());

        return userDto;
    }
}
