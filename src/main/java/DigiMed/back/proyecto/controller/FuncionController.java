package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.service.Impl.ServiceFuncionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/funcion")
public class FuncionController {
    @Autowired
    private ServiceFuncionImpl serviceFuncion;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Funcion> saveFuncion(@RequestBody Funcion funcion) {
        return this.serviceFuncion.save(funcion);
    }

    @GetMapping()
    private Flux<Funcion> AllFunciones() {
        return this.serviceFuncion.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Funcion>> deleteFuncion(@PathVariable("id") String id) {
        return this.serviceFuncion.delete(id)
                .flatMap(funcion -> Mono.just(ResponseEntity.ok(funcion)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Funcion>> updateFuncion(@PathVariable("id") String id, @RequestBody Funcion funcion) {
        return this.serviceFuncion.update(id, funcion)
                .flatMap(funcion1 -> Mono.just(ResponseEntity.ok(funcion1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/{id}")
    private Mono<Funcion> searchFuncionByID(@PathVariable("id") String id) {
        return this.serviceFuncion.findById(id);
    }
}
