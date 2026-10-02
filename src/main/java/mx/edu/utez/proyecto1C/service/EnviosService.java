package mx.edu.utez.proyecto1C.service;

import mx.edu.utez.proyecto1C.controller.dto.CotizadorEnviosDTO;
import mx.edu.utez.proyecto1C.exception.customExceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class EnviosService {
    public Double envios(CotizadorEnviosDTO payload){

        Double volumen =(payload.getLargoCm()*payload.getAltoCm()*payload.getAnchoCm());
        String tipoEnvio= payload.getTipoEnvio().toUpperCase();


        if (payload.getPesoKg()>50){
            throw new BadRequestException("No se aceptan paquetes de mas de 50Kg");
        }

        if (payload.getLargoCm()>150 ||payload.getAltoCm()>150 || payload.getAnchoCm()>150){
            throw new BadRequestException("No se aceptan paquetes superiores a 150cm");
        }

        if (volumen>1000000){
            throw new BadRequestException("No se aceptan paquetes con volumen superior a 1,000,000cm3");
        }

        if (!tipoEnvio.equals("ESTANDAR")&&!tipoEnvio.equals("EXPRESS")&&!tipoEnvio.equals("MISMO_DIA")){
            throw new BadRequestException("Tipo de envio no valido");
        }

        Double costoBase= 80.0;

        costoBase+=payload.getPesoKg()*12;

        if (volumen>50000){
            costoBase+=100;
        }

        if (tipoEnvio.equals("EXPRESS")){
            costoBase*=1.4;
        }else if (tipoEnvio.equals("MISMO_DIA")){
            costoBase*=1.7;
        }

        if (payload.getValorDeclarado()>10000){
            costoBase+=payload.getValorDeclarado()*0.02;
        }

        return costoBase;

    }
}
