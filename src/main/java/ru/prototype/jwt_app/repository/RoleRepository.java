package ru.prototype.jwt_app.repository;

import ru.prototype.jwt_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.prototype.jwt_app.model.User;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
