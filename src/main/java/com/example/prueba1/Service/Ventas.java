package com.example.prueba1.Service;

import java.util.List;
import com.example.prueba1.Entities.Factura;
import com.example.prueba1.Entities.Persona;

public interface Ventas {
      List<Factura> findFacturasByPersona(Persona persona);
    Factura storeFactura(Factura factura);

}
