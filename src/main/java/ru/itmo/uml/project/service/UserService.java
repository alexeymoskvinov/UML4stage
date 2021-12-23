package ru.itmo.uml.project.service;

import ru.itmo.uml.project.model.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    UserEntity saveUser(UserEntity userEntity);

}
