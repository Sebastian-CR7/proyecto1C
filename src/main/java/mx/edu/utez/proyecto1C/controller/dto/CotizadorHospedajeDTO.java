package mx.edu.utez.proyecto1C.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CotizadorHospedajeDTO {

    @NotBlank(message = "El nombre del huesped es obligatorio")
    private String nombreHuesped;

    @NotBlank(message = "El tipo de habitacion es obligatorio")
    private String tipoHabitacion;

    @NotNull(message = "El numero de noches es obligatorio")
    private Integer numeroNoches;

    @NotNull(message = "El numero de huespedes es obligatorio")
    private Integer numeroHuespedes;

    @NotBlank(message = "La temporada es obligatoria")
    private String temporada;

    @NotNull(message = "La indicacion de desayuno es obligatoria")
    private Boolean incluyeDesayuno;

    @NotNull(message = "La indicacion de estacionamiento es obligatoria")
    private Boolean incluyeEstacionamiento;

}
