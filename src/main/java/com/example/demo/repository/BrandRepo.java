package com.example.demo.repository;

import com.example.demo.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
    Brand findByName(String name);
}
