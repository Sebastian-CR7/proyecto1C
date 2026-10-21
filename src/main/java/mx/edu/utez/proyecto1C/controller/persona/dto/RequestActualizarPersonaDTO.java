package mx.edu.utez.proyecto1C.controller.persona.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestActualizarPersonaDTO {

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe tener formato yyyy-MM-dd")
    private String fechaNacimiento;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato valido")
    private String correo;

    @NotBlank(message = "La CURP es obligatoria")
    @Pattern(regexp = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]\\d$", message = "La CURP no tiene un formato valido")
    private String curp;
}