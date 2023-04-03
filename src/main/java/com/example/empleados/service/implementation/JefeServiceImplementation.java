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
        List<Jefe> allJefes = null;
        try{
            logger.info("Iniciando getAllJefes");
             allJefes = jefeRepository.findAll();
            if(allJefes.isEmpty()){
                logger.error("No se encontro ningun jugador");
                return null;
            }
            logger.info("Finalizando getAllJefes");
            return allJefes;

        }catch (Exception exception){
            logger.error(exception.getMessage());
        }
        return allJefes;
    }

    @Override
    public Jefe getJefeById(Integer id) {
        Jefe particularJefe = null;
        try{
            logger.info("Empezando getJugadoresById");
            particularJefe = jefeRepository.getReferenceById(id);
            if(particularJefe.getId() == null) {
                logger.error("No se encontro el Id de Jefe");
                return null;
            }
            logger.info("Terminando getJefeById");
            return particularJefe;

        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return particularJefe;
    }

    @Override
    public Jefe createJefe(Jefe jefe) {
        Jefe createJefe = null;
        try{
            logger.info("Empezando el createJugadores");
            if(!StringUtils.hasText(jefe.getName())) {
                logger.error("No se hizo la actualizacion de este usuario");
                return null;
            }
            createJefe = jefeRepository.save(jefe);
            logger.info("Terminando createJugadores");
            return createJefe;

        }catch (Exception exception){
            logger.error(exception.getMessage());
        }
       return createJefe;
    }
    @Override
    public Jefe updateJefe(Jefe jefe) {
        Jefe updateJefe = null;
        try{
            logger.info("Empezando el updateJugadores");
            if(!StringUtils.hasText(jefe.getName())){
                logger.error("Falto algun dato");
                return null;
            }
             updateJefe = jefeRepository.save(jefe);
            logger.info("Terminando el updateJugadores");

        }catch (Exception exception){
            logger.error(exception.getMessage());
        }
        return updateJefe;
    }
    @Override
    public void deleteJefeById(Integer id) {
        try{
            logger.info("Empezando la eliminacion del jugador");
            jefeRepository.deleteById(id);
            logger.info("Finalizando la eliminacion del jugador");
        }catch (Exception exception){
            logger.error(exception.getMessage());
        }
    }
}
