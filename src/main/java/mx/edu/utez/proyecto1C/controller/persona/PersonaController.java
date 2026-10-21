package mx.edu.utez.proyecto1C.controller.persona;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.persona.dto.RequestActualizarPersonaDTO;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.service.persona.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable long id,  @Valid @RequestBody RequestActualizarPersonaDTO payload) {
        return ResponseEntity.ok(personaService.updatePersona(id, payload));
    }
}