package mx.edu.utez.proyecto1C.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CotizadorEnviosDTO {

    @NotBlank(message = "Codigo postal obligatorio")
    private String codigoPostal;

    @NotNull(message = "El peso en Kg es obligatorio")
    private Double pesoKg;

    @NotNull(message = "El largo en cm obligatorio")
    private Double largoCm;

    @NotNull(message = "El ancho en cm obligatorio")
    private Double anchoCm;

    @NotNull(message = "El alto en cm obligatorio")
    private Double altoCm;

    @NotBlank(message = "Tipo de envio obligatorio")
    private String tipoEnvio;

    @NotNull(message = "El valor declarado es obligatorio")
    private Double valorDeclarado;
}
