package com.example.demo.iservices;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User> getUsers();
}
