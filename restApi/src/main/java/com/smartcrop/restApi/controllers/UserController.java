/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcrop.restApi.controllers;

import com.smartcrop.restApi.model.dto.RoleToUserDTO;
import com.smartcrop.restApi.model.entities.Role;
import com.smartcrop.restApi.model.entities.User;
import com.smartcrop.restApi.services.UserService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Frederick
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private  UserService userService;
    
    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
      URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    
    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRolToUser(@RequestBody RoleToUserDTO form){
     userService.addRoleToUser(form.getUsername(), form.getRolename());

        return ResponseEntity.ok().build();
    }
}
