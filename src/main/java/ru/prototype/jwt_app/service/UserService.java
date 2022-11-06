package ru.prototype.jwt_app.service;

import ru.prototype.jwt_app.model.Role;
import ru.prototype.jwt_app.model.User;

import java.util.List;
public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    List<User> getUsersByRoles(List<Role> role);
}
