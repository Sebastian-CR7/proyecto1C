package mx.edu.utez.proyecto1C.service;


import mx.edu.utez.proyecto1C.controller.dto.CotizadorVehiculosDTO;
import mx.edu.utez.proyecto1C.exception.customExceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class VehiculosService {
    public Double vehiculos(CotizadorVehiculosDTO payload){
        String tipoV=payload.getTipoVehiculo().toUpperCase();

        if (payload.getEdadConductor()<18){
            throw new BadRequestException("No se acepta la renta si es menor de 18 años");
        }
        if (payload.getDiasRenta()>30){
            throw new BadRequestException("No se acepta la renta si supera los 30 dias");
        }
        if (payload.getKilometrosEstimados()>5000) {
            throw new BadRequestException("No se acepta la renta si los kilometros estimados superan los 5,000km");
        }

        if (tipoV.equals("CAMIONETA") && payload.getEdadConductor() < 25) {
            throw new BadRequestException("No se acepta la renta si el conductor es menor de 25 años y solicita una camioneta");
        }

        Double costoDia;
        switch (tipoV){
            case "COMPACTO":
                costoDia=550.0;
                break;
            case "SEDAN":
                costoDia=700.0;
                break;
            case "SUV":
                costoDia=950.0;
                break;
            case "CAMIONETA":
                costoDia=1200.0;
                break;
            default:
                throw new BadRequestException("Tipo de vehiculo no valido");
        }

        Double costoRenta=costoDia*payload.getDiasRenta();

        Double kmIncluidos= payload.getDiasRenta()*100.0;
        Double kmAdicional=0.0;

        if (payload.getKilometrosEstimados()>kmIncluidos){
            kmAdicional =(payload.getKilometrosEstimados()-kmIncluidos)*4.0;
        }

        Double cargoEdad=0.0;
        if (payload.getEdadConductor()>=18&payload.getEdadConductor()<=24){
            cargoEdad=(costoRenta+kmAdicional)*0.15;
        }

        Double cargoSeguro=0.0;
        if (Boolean.TRUE.equals(payload.getSeguroCompleto())){
            cargoSeguro=payload.getDiasRenta()*180.0;
        }

        if (payload.getDiasRenta()>=7){
            costoRenta*=0.90;
        }
        Double total;
        total=costoRenta+kmAdicional+cargoEdad+cargoSeguro;
        return total;
    }
}
