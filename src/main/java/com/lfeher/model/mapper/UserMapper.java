package com.lfeher.model.mapper;

import com.lfeher.jpa.model.User;
import com.lfeher.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "felhasznalonev", target = "username")
    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);
}
