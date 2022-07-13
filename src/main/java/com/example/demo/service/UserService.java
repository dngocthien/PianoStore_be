package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.Userr;
import com.example.demo.iservices.IUserService;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
//@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Override
    public Userr saveUser(Userr userr) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userr.setPassword(new BCryptPasswordEncoder().encode(userr.getPassword()));
        return userRepo.save(userr);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String name) {
        Userr userr = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(name);
        userr.getRoles().add(role);
    }

    @Override
    public Userr getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Userr> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Userr getUserByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userr userr = userRepo.findByUsername(username);
        if (userr == null) {
            System.out.println("no user found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println(userr.toString());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userr.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(userr.getUsername(), userr.getPassword(), authorities);
    }
}
