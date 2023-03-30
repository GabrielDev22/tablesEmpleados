package com.example.empleados.controller;

import com.example.empleados.model.Jefe;
import com.example.empleados.service.JefeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jefe")
public class JefeController {

    private final JefeService jefeService;

    public JefeController(JefeService jefeService) {this.jefeService = jefeService;}

    @GetMapping("/getAll")
    public List<Jefe> getAllJefes() {return jefeService.getAllJefes();}

    @GetMapping("/get/{id}")
    public Jefe getJefeById(@PathVariable Integer id) {return jefeService.getJefeById(id);}

    @PostMapping("/create")
    public Jefe creatJefeEmpleado(@RequestBody Jefe jefe) {return jefeService.createJefe(jefe);}

    @PutMapping("/update")
    public Jefe updateJefe(@RequestBody Jefe jefe){
        return jefeService.updateJefe(jefe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJefeById(@PathVariable Integer id) {jefeService.deleteJefeById(id);}

}
