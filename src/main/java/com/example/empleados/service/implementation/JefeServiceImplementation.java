package com.example.empleados.service.implementation;

import com.example.empleados.model.Jefe;
import com.example.empleados.repository.JefeRepository;
import com.example.empleados.service.JefeService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;

@Service
public class JefeServiceImplementation implements JefeService {

    Logger logger = LoggerFactory.getLogger(JefeServiceImplementation.class);

    private final JefeRepository jefeRepository;

    public JefeServiceImplementation(JefeRepository jefeRepository){
        this.jefeRepository = jefeRepository;
    }

    @Override
    public List<Jefe> getAllJefes(){
        logger.info("Iniciando getAllJefes");
        List<Jefe> allJefes = jefeRepository.findAll();
        if(allJefes.isEmpty()){
            logger.error("No se encontro ningun jugador");
            return null;
        }
        logger.info("Finalizando getAllJefes");
        return allJefes;
    }

    @Override
    public Jefe getJefeById(Integer id) {
        logger.info("Empezando getJugadoresById");
        Jefe particularJefe = jefeRepository.getReferenceById(id);
        logger.info("Terminando getJefeById");
        return particularJefe;
    }

    @Override
    public Jefe createJefe(Jefe jefe) {
        logger.info("Empezando el createJugadores");
        if(!StringUtils.hasText(jefe.getName()))
            return null;
        Jefe createJefe = jefeRepository.save(jefe);
        logger.info("Terminando createJugadores");
        return createJefe;
    }
    @Override
    public Jefe updateJefe(Jefe jefe) {
        logger.info("Empezando el updateJugadores");
        if(!StringUtils.hasText(jefe.getName())){
            logger.error("Falto algun dato");
            return null;
        }
        Jefe updateJefe = jefeRepository.save(jefe);
        logger.info("Terminando el updateJugadores");
        return updateJefe;
    }
    @Override
    public void deleteJefeById(Integer id) {
        logger.info("Empezando la eliminacion del jugador");
        jefeRepository.deleteById(id);
        logger.info("Finalizando la eliminacion del jugador");
    }
}
