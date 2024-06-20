package com.example.prueba1.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.example.prueba1.Entities.Persona;
import com.example.prueba1.Repository.PersonaRepository;
import com.example.prueba1.Service.Directorio;

@Service
public class DirectorioImpl implements Directorio {

    private static final Logger logger = LoggerFactory.getLogger(DirectorioImpl.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona findPersonaByIdentificacion(String identificacion) {
        logger.info("Buscando personas por identificacion: {}", identificacion);
        return personaRepository.findByIdentificacion(identificacion);
    }

    @Override
    public List<Persona> findPersonas() {
        logger.info("Buscando todas las personas");
        return personaRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePersonasByIdentificacion(String identificacion) {
        logger.info("Eliminando personas por identificacion: {}", identificacion);
        personaRepository.deleteByIdentificacion(identificacion);
    }

    @Override
    @Transactional
    public Persona storePersona(Persona persona) {
        logger.info("Intentando guardar persona: {}", persona);
        Persona personaAgregada = new Persona();
        if ((persona.getNombre()!=null && !persona.getNombre().isEmpty()) && (persona.getApellidoPaterno()!=null && !persona.getApellidoPaterno().isEmpty()) 
        && (persona.getIdentificacion()!=null && !persona.getIdentificacion().isEmpty())) {
            personaAgregada = personaRepository.save(persona);
        }
        else{
            logger.error("Error al guardar persona: campos obligatorios faltantes");
            throw new IllegalArgumentException("Nombre, Apellido Paterno e Identificación son campos obligatorios");
            
        }

        return personaAgregada;
    }
}
