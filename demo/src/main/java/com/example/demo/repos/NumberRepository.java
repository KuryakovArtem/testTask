package com.example.demo.repos;

import com.example.demo.entities.Number;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NumberRepository extends JpaRepository<Number, Long> {
}
