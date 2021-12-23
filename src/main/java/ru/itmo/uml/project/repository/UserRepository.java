package ru.itmo.uml.project.repository;

import ru.itmo.uml.project.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(@Param("email") String email);

    Optional<UserEntity> findByUsername(@Param("username") String username);
}
