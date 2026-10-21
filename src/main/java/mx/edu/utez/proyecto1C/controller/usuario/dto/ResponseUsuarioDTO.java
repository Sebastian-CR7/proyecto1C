package mx.edu.utez.proyecto1C.controller.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.model.usuario.Roles;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUsuarioDTO {

    private long id;
    private String username;
    private Boolean isEnable;
    private Roles rol;
    private String descripcion;
    private Persona persona;

    public static ResponseUsuarioDTO from(Usuario usuario) {
        return new ResponseUsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getIsEnable(),
                usuario.getRol(), usuario.getDescripcion(), usuario.getPersona());
    }
}