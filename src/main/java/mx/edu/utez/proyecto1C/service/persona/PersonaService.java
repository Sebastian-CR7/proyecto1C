package mx.edu.utez.proyecto1C.service.persona;

import mx.edu.utez.proyecto1C.controller.persona.dto.RequestActualizarPersonaDTO;
import mx.edu.utez.proyecto1C.exception.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.repository.persona.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    //inyeccion de dependencias
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //servicios
    public Persona updatePersona(long id, RequestActualizarPersonaDTO payload) {
        //validacion por consulta: si la persona existe
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("La persona con id " + id + " no existe"));

        persona.setNombres(payload.getNombres());
        persona.setPrimerApellido(payload.getPrimerApellido());
        persona.setSegundoApellido(payload.getSegundoApellido());
        persona.setFechaNacimiento(payload.getFechaNacimiento());
        persona.setCorreo(payload.getCorreo());
        persona.setCurp(payload.getCurp());

        return personaRepository.save(persona);
    }
}