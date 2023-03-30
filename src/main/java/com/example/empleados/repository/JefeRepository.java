package com.example.empleados.repository;

import com.example.empleados.model.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JefeRepository extends JpaRepository <Jefe, Integer> {
}
