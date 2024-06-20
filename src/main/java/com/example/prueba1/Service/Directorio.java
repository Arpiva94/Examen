package com.example.prueba1.Service;

import java.util.List;
import com.example.prueba1.Entities.Persona;

public interface Directorio {

    Persona findPersonaByIdentificacion(String identificacion);
    List<Persona> findPersonas();
    void deletePersonasByIdentificacion(String identificacion);
    Persona storePersona(Persona persona);

}
