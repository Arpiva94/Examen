package com.example.prueba1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prueba1.Entities.Factura;
import com.example.prueba1.Entities.Persona;
import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByPersona(Persona persona);

    @SuppressWarnings("unchecked")
    Factura save(Factura factura);
}