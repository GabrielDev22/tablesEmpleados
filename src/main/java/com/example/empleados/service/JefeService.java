package com.example.empleados.service;

import com.example.empleados.model.Jefe;

import java.util.List;

public interface JefeService {
    List<Jefe> getAllJefes();

    Jefe getJefeById(Integer id);

    Jefe createJefe(Jefe jefe);

    Jefe updateJefe(Jefe jefe);

    void deleteJefeById(Integer id);
}
