package ru.prototype.jwt_app.repository;

import ru.prototype.jwt_app.model.Role;
import ru.prototype.jwt_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    List<User> findUsersByRoles(List<Role> roles);
}
