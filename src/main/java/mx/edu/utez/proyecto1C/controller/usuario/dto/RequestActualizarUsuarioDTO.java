package mx.edu.utez.proyecto1C.controller.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestActualizarUsuarioDTO {

    @NotBlank(message = "El username es obligatorio")
    @Size(min = 3, max = 30, message = "El username debe tener entre 3 y 30 caracteres")
    private String username;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(max = 500, message = "La descripcion no puede pasar de 500 caracteres")
    private String descripcion;
}