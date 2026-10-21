package mx.edu.utez.proyecto1C.service.usuario;


import mx.edu.utez.proyecto1C.controller.usuario.dto.RequestActualizarUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.usuario.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.usuario.dto.ResponseUsuarioDTO;
import mx.edu.utez.proyecto1C.exception.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.model.usuario.Roles;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.repository.persona.PersonaRepository;
import mx.edu.utez.proyecto1C.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    //inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository){

        this.usuarioRepository =usuarioRepository;
        this.personaRepository=personaRepository;
    }

    //servicios
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario createUser(RequestCrearUsuarioDTO payload){
        if (usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new BadRequestException("Usuario ya esta en uso");
        }

        Persona newpersona = new Persona();
        newpersona.setNombres(payload.getNombres());
        newpersona.setPrimerApellido(payload.getPrimerApellido());
        newpersona.setSegundoApellido(payload.getSegundoApellido());
        newpersona.setFechaNacimiento(payload.getFechaNacimiento());
        newpersona.setCorreo(payload.getCorreo());
        newpersona.setCurp(payload.getCurp());


        newpersona = personaRepository.save(newpersona);


        //crear instancia de usuario y llenarla en base a la info del payload
        Usuario newUser = new Usuario();
        newUser.setUsername(payload.getUsername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripcion(payload.getDescripcion());
        newUser.setIsEnable(true);
        newUser.setRol(Roles.valueOf(payload.getRol()));

        newUser.setPersona(newpersona);


        return usuarioRepository.save(newUser);
    }


    public ResponseUsuarioDTO activarUsuario(long id) {
        Usuario usuario = buscarUsuario(id);
        usuario.setIsEnable(true);

        return ResponseUsuarioDTO.from(usuarioRepository.save(usuario));
    }

    public ResponseUsuarioDTO desactivarUsuario(long id) {
        Usuario usuario = buscarUsuario(id);
        usuario.setIsEnable(false);

        return ResponseUsuarioDTO.from(usuarioRepository.save(usuario));
    }

    public ResponseUsuarioDTO getUserById(long id) {
        return ResponseUsuarioDTO.from(buscarUsuario(id));
    }

    public ResponseUsuarioDTO updateUser(long id, RequestActualizarUsuarioDTO payload) {
        Usuario usuario = buscarUsuario(id);

        Optional<Usuario> existente = usuarioRepository.findByUsername(payload.getUsername());
        if (existente.isPresent() && existente.get().getId() != usuario.getId()) {
            throw new BadRequestException("Usuario ya esta en uso");
        }

        usuario.setUsername(payload.getUsername());
        usuario.setDescripcion(payload.getDescripcion());

        return ResponseUsuarioDTO.from(usuarioRepository.save(usuario));
    }

    //si el usuario existe
    private Usuario buscarUsuario(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con id " + id + " no existe"));
    }
}
