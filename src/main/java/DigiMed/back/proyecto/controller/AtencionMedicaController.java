package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.modelDTO.TratamientoCitaDTO;
import DigiMed.back.proyecto.service.Impl.ServiceAtencionMedicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/am")
public class AtencionMedicaController {
    @Autowired
    private ServiceAtencionMedicaImpl serviceAtencionMedica;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<AtencionMedica> saveAM(@RequestBody AtencionMedica atencionMedica) {
        return this.serviceAtencionMedica.save(atencionMedica);
    }

    @GetMapping()
    private Flux<AtencionMedica> AllAM() {
        return this.serviceAtencionMedica.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<AtencionMedica>> deleteAM(@PathVariable("id") String id) {
        return this.serviceAtencionMedica.delete(id)
                .flatMap(atencionMedica -> Mono.just(ResponseEntity.ok(atencionMedica)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<AtencionMedica>> updateAM(@PathVariable("id") String id, @RequestBody AtencionMedica atencionMedica) {
        return this.serviceAtencionMedica.update(id, atencionMedica)
                .flatMap(atencionMedica1 -> Mono.just(ResponseEntity.ok(atencionMedica1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/{id}")
    private Mono<AtencionMedica> searchAMByID(@PathVariable("id") String id) {
        return this.serviceAtencionMedica.findById(id);
    }

    @PostMapping(value = "/agregarTratamiento/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<AtencionMedica> agregarTratamiento(@PathVariable("id") String id, @RequestBody TratamientoCitaDTO tratamientoCitaDTO) {
        return this.serviceAtencionMedica.agregarTratamiento(id,tratamientoCitaDTO);
    }

    @PostMapping(value = "/agregarTratamientoCita/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<AtencionMedica> agregarTratamientoCita(@PathVariable("id") String id, @RequestBody TratamientoCitaDTO tratamientoCitaDTO) {
        return this.serviceAtencionMedica.agregarTratamientoCita(id,tratamientoCitaDTO);
    }
}
