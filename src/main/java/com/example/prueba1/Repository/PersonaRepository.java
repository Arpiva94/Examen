package com.example.prueba1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prueba1.Entities.Persona;
import java.util.List;
import javax.transaction.Transactional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByIdentificacion(String identificacion);
    List<Persona> findAll();
    
    @Transactional
    void deleteByIdentificacion(String identificacion);
}