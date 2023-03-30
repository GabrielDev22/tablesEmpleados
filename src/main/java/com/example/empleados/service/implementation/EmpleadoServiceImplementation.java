package com.example.empleados.service.implementation;

import com.example.empleados.model.Empleado;
import com.example.empleados.repository.EmpleadosRepository;
import com.example.empleados.service.EmpleadosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j

public class EmpleadoServiceImplementation implements EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public EmpleadoServiceImplementation(EmpleadosRepository empleadosRepository){
        this.empleadosRepository = empleadosRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados(){
        log.info("Empezando getAllEmpleados");
        List<Empleado> allEmpleado = empleadosRepository.findAll();
        if(allEmpleado.isEmpty()){
            log.error("No se encontro ningun jugador");
            return null;
        }
        log.info("Terminando getAllEmpleados");
        return allEmpleado;
    }
    @Override
    public Empleado getEmpleadoById(Integer id) {
        log.info("Empezando getEmpleadoById");
        Empleado particularEmpleado = empleadosRepository.getReferenceById(id);
        log.info("Terminando getEmpleadoByID");
        return particularEmpleado;
    }
    @Override
    public Empleado createEmpleado(Empleado empleado){
        log.info("Empezando el createEmpleado");
        if(!StringUtils.hasText(empleado.getName()))
            return null;
        Empleado createEmpleado = empleadosRepository.save(empleado);
        log.info("Terminando createJugadores");
        return createEmpleado;
    }
    @Override
    public Empleado updateEmpleado(Empleado empleado){
        log.info("Empezando el updateJugadores");
        if(!StringUtils.hasText(empleado.getName()) || empleado.getId() == null || empleado.getMoney() == null){
            log.error("Falto algun dato");
            return null;
        }
        Empleado updateEmpleado = empleadosRepository.save(empleado);
        log.info("Terminando el updateJugadores");
        return updateEmpleado;
    }
    @Override
    public void deleteEmpleadoById(Integer id) {
        log.info("Empezando la eliminacion del Empleado");
        empleadosRepository.deleteById((id));
        log.info("Finalizando la eliminacion del jugador");
    }
}
