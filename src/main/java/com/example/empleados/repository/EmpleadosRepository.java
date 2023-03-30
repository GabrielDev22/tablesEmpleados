package com.example.empleados.repository;

import com.example.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleadosRepository extends JpaRepository <Empleado, Integer> {
}
