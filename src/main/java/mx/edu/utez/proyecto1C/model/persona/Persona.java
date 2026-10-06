package mx.edu.utez.proyecto1C.model.persona;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;

@Entity
@Table(name = "personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombres;
    private String primerApellido;
    private String segundoApellido;

    private Data fechaNacimiento;
    private String correo;
    private String apodos;


}
