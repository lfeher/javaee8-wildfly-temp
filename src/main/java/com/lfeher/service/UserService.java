package com.lfeher.service;

import com.lfeher.jpa.model.User;
import com.lfeher.model.UserDto;
import com.lfeher.model.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Slf4j
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private UserMapper userMapper;

    public List<UserDto> getUsers() {
        log.debug("getUsers");
        return entityManager.createNamedQuery(User.FIND_ALL, User.class).getResultList().stream().map(userMapper::entityToDto).collect(Collectors.toList());
    }
}
