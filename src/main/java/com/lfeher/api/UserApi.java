package com.lfeher.api;

import com.lfeher.service.UserService;
import com.lfeher.model.UserDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
public class UserApi {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers() {

        return userService.getUsers();
    }
}
