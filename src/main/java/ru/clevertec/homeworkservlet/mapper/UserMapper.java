package ru.clevertec.homeworkservlet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.entities.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
//    User userDtoToUser(UserDto userDto);
}
