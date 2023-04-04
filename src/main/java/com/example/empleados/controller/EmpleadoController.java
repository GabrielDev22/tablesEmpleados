package com.example.empleados.controller;

import com.example.empleados.model.Empleado;
import com.example.empleados.service.EmpleadosService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final EmpleadosService empleadosService;

    public EmpleadoController(EmpleadosService empleadosService) {this.empleadosService = empleadosService;}
    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados() {
        return empleadosService.getAllEmpleados();
    }

    @GetMapping("/get/{id}")
    public Empleado getEmpleadoById(@PathVariable Integer id) {
        if(getEmpleadoById(id) == null) {
            return null;
        }
        return empleadosService.getEmpleadoById(id);
    }

    @PostMapping("/create")
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        if(createEmpleado(empleado) ==  null){
            return null;
        }
        return empleadosService.createEmpleado(empleado);
    }

    @PutMapping("/update")
    public Empleado updateEmpleado(@RequestBody Empleado empleado){
        if(updateEmpleado(empleado) == null){
            return null;
        }
        return empleadosService.updateEmpleado(empleado);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmpleadoById(@PathVariable Integer id){
        empleadosService.deleteEmpleadoById(id);
    }
}

