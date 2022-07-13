package com.example.demo.repository;

import com.example.demo.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Userr, Integer> {
    Userr findByUsername(String uname);
}
