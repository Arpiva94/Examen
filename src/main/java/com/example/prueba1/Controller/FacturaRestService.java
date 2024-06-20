package com.example.prueba1.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.prueba1.Entities.Factura;
import com.example.prueba1.Entities.Persona;
import com.example.prueba1.Service.Ventas;

@RestController
@RequestMapping("/api/facturas")
public class FacturaRestService {

    @Autowired
    private Ventas ventasService;

    @PostMapping
    public ResponseEntity<List<Factura>> findFacturasByPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(ventasService.findFacturasByPersona(persona));
    }

    @PostMapping("/storeFactura")
    public ResponseEntity<Factura> storeFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(ventasService.storeFactura(factura));
    }
}
