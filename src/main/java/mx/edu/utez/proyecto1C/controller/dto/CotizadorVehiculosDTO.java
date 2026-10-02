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
public class CotizadorVehiculosDTO {

    @NotBlank (message = "Nombre del cliente es obligatorio")
    private String nombreCliente;

    @NotNull(message = "Edad del conductor es obligatorio")
    private Integer edadConductor;

    @NotBlank (message = "Tipo de vehiculo es obligatorio")
    private String tipoVehiculo;

    @NotNull(message ="Los dias de renta son obligatorios")
    private Integer diasRenta;

    @NotNull(message = "Los kilometros son obligatorios")
    private Double kilometrosEstimados;

    @NotNull(message = "Indicar seguro completo es obligatorio")
    private Boolean seguroCompleto;
}
