package mx.edu.utez.proyecto1C.controller.usuario;


import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.usuario.dto.RequestActualizarUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.usuario.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.usuario.dto.ResponseUsuarioDTO;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService=usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity.status(200).body(this.usuarioService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid RequestCrearUsuarioDTO payload){
        return ResponseEntity.status(201).body(this.usuarioService.createUser(payload));
    }


    @PatchMapping("/{id}/activar")
    public ResponseEntity<ResponseUsuarioDTO> activar(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.activarUsuario(id));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<ResponseUsuarioDTO> desactivar(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.desactivarUsuario(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> obtenerPorId(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> actualizar(@PathVariable long id,
                                                         @Valid @RequestBody RequestActualizarUsuarioDTO payload) {
        return ResponseEntity.ok(usuarioService.updateUser(id, payload));
    }

}
