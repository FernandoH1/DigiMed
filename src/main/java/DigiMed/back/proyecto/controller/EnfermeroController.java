package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.modelDTO.EmailEnfermeroDTO;
import DigiMed.back.proyecto.service.Impl.ServiceEnfermeroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/enfermero")
public class EnfermeroController {

    @Autowired
    private ServiceEnfermeroImpl serviceEnfermero;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Enfermero> saveEnfermero(@RequestBody Enfermero enfermero) {
        return this.serviceEnfermero.save(enfermero);
    }

    @GetMapping()
    private Flux<Enfermero> AllEnfermeros() {
        return this.serviceEnfermero.findAll();
    }

    @DeleteMapping("/delete/{id}")
    private Mono<Void> delete_Enfermero(@PathVariable("id") String id) {
        return this.serviceEnfermero.delete(id);
    }

    @PutMapping("/edit/{id}")
    private Mono<ResponseEntity<Enfermero>> update_Enfermero(@PathVariable("id") String id, @RequestBody Enfermero enfermero) {
        return this.serviceEnfermero.update(id, enfermero)
                .flatMap(enfermero1 -> Mono.just(ResponseEntity.ok(enfermero1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/{id}")
    private Mono<Enfermero> searchEnfermeroByID(@PathVariable("id") String id) {
        return this.serviceEnfermero.findById(id);
    }

    @GetMapping(value = "/disponibilidad/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Enfermero> saveEnfermero(@PathVariable("id") String id) {
        return this.serviceEnfermero.cambiarDisponibilidad(id);
    }

    @PostMapping("/notificationemail")
    @ResponseStatus(HttpStatus.OK)
    private Mono<String> sendNotificationEmail(@RequestBody EmailEnfermeroDTO emailEnfermeroDTO) {
        return this.serviceEnfermero.sendNotificationEmail(emailEnfermeroDTO);
    }
}
