package mx.edu.utez.proyecto1C.controller.usuario.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCrearUsuarioDTO {
    @NotBlank(message = "El username es obligatorio")
    @Size(min = 4, max = 20, message = "El username debe de estar entre 4 y 20 caracteres")
    private  String username;

    @NotBlank(message = "La password es obligatoria")
    @Size(min = 4,max = 10,message = "la contraseña de tener de 4 a 20 caracteres")
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;

    private String descripcion;



    //datos de persona
    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String fechaNacimiento;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo es invalido")
    private String correo;

    @NotBlank(message = "El curp es obligatorio")
    private String curp;



}
