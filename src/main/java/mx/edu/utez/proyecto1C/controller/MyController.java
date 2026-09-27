package mx.edu.utez.proyecto1C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.dto.RequestBodyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin ({"*"})//  TODOS LOS ORIGENES
@RequestMapping("/my-services")
public class MyController {

    @GetMapping
    public String miPrimerServicio(){
        return "Hello world";
    }

    @GetMapping("/servicio2")
    public String servicio2(){
        return "segundo servicio";
    }

    @PostMapping
    public String servicio3(){
        return "Este es el servicio 3";
    }

    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id ){
        return "el path variable es "+id;
    }

    @PostMapping("/body")
    /*public String body(@RequestBody RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());
        return "cadena";
    }
    */
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }

    public ResponseEntity<RequestBodyDTO> fibonacci(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }
}
