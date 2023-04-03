package com.example.empleados.service.implementation;

import com.example.empleados.model.Empleado;
import com.example.empleados.repository.EmpleadosRepository;
import com.example.empleados.service.EmpleadosService;
import jakarta.persistence.Id;
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
        List<Empleado> allEmpleado = null;
        try{
            log.info("Empezando getAllEmpleados");
            allEmpleado = empleadosRepository.findAll();
            if(allEmpleado.isEmpty()){
                log.error("No se encontro ningun jugador");
                return null;
            }
            log.info("Terminando getAllEmpleados");
            return allEmpleado;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return allEmpleado;
    }
    @Override
    public Empleado getEmpleadoById(Integer id) {
        Empleado particularEmpleado = null;
        try{
            log.info("Empezando getEmpleadoById");
            particularEmpleado = empleadosRepository.getReferenceById(id);
            if(particularEmpleado.getId() == null){
                log.error("No se encontron ningun Empelado por Id");
                return null;
            }
            log.info("Terminando getEmpleadoById");
            return particularEmpleado;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return particularEmpleado;
    }
    @Override
    public Empleado createEmpleado(Empleado empleado){
        Empleado createEmpleado = null;
        try{
            log.info("Empezando el createEmpleado");
            if(!StringUtils.hasText(empleado.getName())){
                log.error("No se encontro el empleado para actualizacion");
                return null;
            }
            createEmpleado = empleadosRepository.save(empleado);
            log.info("Terminando createJugadores");
            return createEmpleado;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return createEmpleado;
    }
    @Override
    public Empleado updateEmpleado(Empleado empleado){
        Empleado updateEmpleado = null;
        try{
            log.info("Empezando el updateJugadores");
            if(!StringUtils.hasText(empleado.getName()) || empleado.getId() == null || empleado.getMoney() == null){
                log.error("Falto algun dato");
                return null;
            }
            updateEmpleado = empleadosRepository.save(empleado);
            log.info("Terminando el updateJugadores");
            return updateEmpleado;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateEmpleado;
    }
    @Override
    public void deleteEmpleadoById(Integer id) {
        log.info("Empezando la eliminacion del Empleado");
        empleadosRepository.deleteById((id));
        log.info("Finalizando la eliminacion del jugador");
    }
}
