package mx.edu.utez.proyecto1C.service;

import mx.edu.utez.proyecto1C.controller.dto.CotizadorHospedajeDTO;
import mx.edu.utez.proyecto1C.exception.customExceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class HospedajeService {
    public Double hospedaje(CotizadorHospedajeDTO payload) {

        String tipoHabitacion = payload.getTipoHabitacion().toUpperCase();
        String temporada = payload.getTemporada().toUpperCase();

        if (payload.getNumeroNoches() > 30) {
            throw new BadRequestException("No se acepta la reservacion si el número de noches supera las 30");
        }

        double costoNoche;
        int capacidadMaxima;

        switch (tipoHabitacion) {
            case "INDIVIDUAL":
                costoNoche = 700.0;
                capacidadMaxima = 1;
                break;
            case "DOBLE":
                costoNoche = 1100.0;
                capacidadMaxima = 2;
                break;
            case "SUITE":
                costoNoche = 1800.0;
                capacidadMaxima = 4;
                break;
            default:
                throw new BadRequestException("Tipo de habitación no válida");
        }



        if (payload.getNumeroHuespedes() > capacidadMaxima) {
            throw new BadRequestException("No se acepta la reservacion si el número de huéspedes supera la capacidad de la habitacion");
        }

        if (!temporada.equals("BAJA") && !temporada.equals("REGULAR") && !temporada.equals("ALTA")) {
            throw new BadRequestException("Temporada no válida");
        }

        double costoHospedaje =costoNoche*payload.getNumeroNoches();
        double costoAjustado=costoHospedaje;

        if (temporada.equals("BAJA")) {
            costoAjustado -=costoHospedaje * 0.10; // -10%
        } else if (temporada.equals("ALTA")) {
            costoAjustado +=costoHospedaje * 0.25; // +25%
        }

        double costoDesayuno = 0.0;
        if (Boolean.TRUE.equals(payload.getIncluyeDesayuno())) {
            costoDesayuno = payload.getNumeroHuespedes()*payload.getNumeroNoches() * 150.0;
        }

        double costoEstacionamiento = 0.0;
        if (Boolean.TRUE.equals(payload.getIncluyeEstacionamiento())) {
            costoEstacionamiento =payload.getNumeroNoches() * 100.0;
        }

        if (payload.getNumeroNoches() >= 7) {
            costoAjustado -=costoHospedaje * 0.08;
        }

        double subtotal=costoAjustado+costoDesayuno+costoEstacionamiento;
        double impuestoHospedaje =subtotal*0.04;

        double total=subtotal+impuestoHospedaje;

        return total;
    }
}
