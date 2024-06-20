package com.example.prueba1.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.prueba1.Controller.DirectorioRestService;
import com.example.prueba1.Entities.Factura;
import com.example.prueba1.Entities.Persona;
import com.example.prueba1.Repository.FacturaRepository;
import com.example.prueba1.Repository.PersonaRepository;
import com.example.prueba1.Service.Ventas;
import java.util.List;

@Service
public class VentasImpl implements Ventas {

    private static final Logger logger = LoggerFactory.getLogger(DirectorioRestService.class);

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findFacturasByPersona(Persona persona) {
        logger.info("Buscando facturas por persona");
        return facturaRepository.findByPersona(persona);
    }

    @Override
    @Transactional
    public Factura storeFactura(Factura factura) {
        logger.info("Guardando facturas");
        Persona persona = factura.getPersona();
        if (persona.getId() == null) {
            logger.info("Guardando persona previo a guardar factura");
            persona = personaRepository.save(persona);
        }
        factura.setPersona(persona);
        return facturaRepository.save(factura);
    }
}
