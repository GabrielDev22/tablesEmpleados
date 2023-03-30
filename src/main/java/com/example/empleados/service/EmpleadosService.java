package com.example.empleados.service;

import com.example.empleados.model.Empleado;
import java.util.List;
public interface EmpleadosService {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(Integer id);

    Empleado createEmpleado(Empleado empleado);
    Empleado updateEmpleado(Empleado empleado);

    void deleteEmpleadoById(Integer id);

}
