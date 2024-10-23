package ru.clevertec.homeworkservlet.mapper;

import javax.annotation.processing.Generated;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-24T01:25:35+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.name( user.getName() );
        userDto.login( user.getLogin() );
        userDto.password( user.getPassword() );
        userDto.role( user.getRole() );

        return userDto.build();
    }
}
