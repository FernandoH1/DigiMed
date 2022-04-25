package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.service.Impl.ServiceTratamientoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tratamiento")
public class TratamientoController {
    @Autowired
    private ServiceTratamientoImpl serviceTratamiento;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Tratamiento> saveTratamientos(@RequestBody Tratamiento tratamiento) {
        return this.serviceTratamiento.save(tratamiento);
    }

    @GetMapping()
    private Flux<Tratamiento> AllTratamientos() {
        return this.serviceTratamiento.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Tratamiento>> deleteTratamiento(@PathVariable("id") String id) {
        return this.serviceTratamiento.delete(id)
                .flatMap(tratamiento -> Mono.just(ResponseEntity.ok(tratamiento)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Tratamiento>> updateTratamiento(@PathVariable("id") String id, @RequestBody Tratamiento tratamiento) {
        return this.serviceTratamiento.update(id, tratamiento)
                .flatMap(tratamiento1 -> Mono.just(ResponseEntity.ok(tratamiento1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/{id}")
    private Mono<Tratamiento> searchTratamientoByID(@PathVariable("id") String id) {
        return this.serviceTratamiento.findById(id);
    }


}
