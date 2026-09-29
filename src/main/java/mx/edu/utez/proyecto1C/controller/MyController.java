package mx.edu.utez.proyecto1C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.dto.RequestBodyDTO;
import mx.edu.utez.proyecto1C.controller.dto.RequestCalculadoraDTO;
import mx.edu.utez.proyecto1C.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin ({"*"})//  TODOS LOS ORIGENES
@RequestMapping("/my-services")
public class MyController {

    private  final MyService service;

    public MyController (MyService service) {
        this.service=service;
    }

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


    //EJERCICIO DE FIZZBUZZ
    @GetMapping("/fizzbuzz/{n}")
    public String FizzBuzz(@PathVariable int n ){

        for (int i=1;i<=n;i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            }else if (i%3==0){
                System.out.println("Fizz");
            }else if (i%5==0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }

        return "Martinez Peralta Edwin Sebastian";
    }


    //EJERCICIO DE FIBONACCI
    @GetMapping("/fibonacci/{n}")
    public String Fibonacci(@PathVariable int n){
        int a=0,b=1;
        for (int i=0;i<n;i++){
            System.out.println(a);
            int suma = a+b;
            a=b;
            b=suma;

        }
        return "Martinez Peralta Edwin Sebastian";

    }

    @PostMapping("/calculadora")
    public double calculadora(@RequestBody @Valid RequestCalculadoraDTO payload ){
        return service.calculadora(payload);
    }

}
