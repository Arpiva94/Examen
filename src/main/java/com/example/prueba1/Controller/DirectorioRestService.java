package com.example.prueba1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.prueba1.Entities.Persona;
import com.example.prueba1.Service.Directorio;

@RestController
@RequestMapping("/api/directorio")
public class DirectorioRestService {

    @Autowired
    private Directorio directorioService;

    @PostMapping
    public ResponseEntity<Persona> findPersonaByIdentificacion(@RequestParam("identificacion") String identificacion) {
        return ResponseEntity.ok(directorioService.findPersonaByIdentificacion(identificacion));
    }

    @GetMapping("/")
    public ResponseEntity<List<Persona>> findPersonas() {
        return ResponseEntity.ok(directorioService.findPersonas());
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Void> deletePersonasByIdentificacion(@PathVariable String identificacion) {
        directorioService.deletePersonasByIdentificacion(identificacion);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/storePersona")
    public ResponseEntity<Persona> storePersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(directorioService.storePersona(persona));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
