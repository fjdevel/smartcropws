/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.smartcrop.restApi.services;

import com.smartcrop.restApi.model.entities.Role;
import com.smartcrop.restApi.model.entities.User;
import java.util.List;

/**
 *
 * @author Frederick
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
