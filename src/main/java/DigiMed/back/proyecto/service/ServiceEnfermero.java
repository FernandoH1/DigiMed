package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.modelDTO.EmailEnfermeroDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceEnfermero {
    Mono<Enfermero> save(Enfermero enfermero);

    Flux<Enfermero> findAll();

    Mono<Enfermero> delete(String id);

    Mono<Enfermero> update(String id, Enfermero enfermero);

    Mono<Enfermero> findById(String id);

    Flux<Enfermero> findActive();

    Mono<String> sendNotificationEmail(EmailEnfermeroDTO emailEnfermeroDTO);
}
