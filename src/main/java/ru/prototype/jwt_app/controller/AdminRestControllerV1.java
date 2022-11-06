package ru.prototype.jwt_app.controller;

import org.springframework.web.bind.annotation.*;
import ru.prototype.jwt_app.dto.AdminUserDto;
import ru.prototype.jwt_app.model.Role;
import ru.prototype.jwt_app.model.User;
import ru.prototype.jwt_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;

    @Autowired
    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping( "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("users/all")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("users/all/roles")
    public ResponseEntity<List<User>> getAllAdmins(@RequestBody List<Role> roles){
        return ResponseEntity.ok(userService.getUsersByRoles(roles));
    }
}
