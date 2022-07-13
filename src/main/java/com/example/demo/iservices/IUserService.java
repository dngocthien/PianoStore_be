package com.example.demo.iservices;

import com.example.demo.entity.Role;
import com.example.demo.entity.Userr;

import java.util.List;

public interface IUserService {

    Userr saveUser(Userr userr);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    Userr getUser(String username);
    List<Userr> getUsers();
    Userr getUserByName(String name);
}
