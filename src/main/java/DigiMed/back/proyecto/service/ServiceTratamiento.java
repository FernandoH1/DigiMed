package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.model.Tratamiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceTratamiento {
    Mono<Tratamiento> save(Tratamiento tratamiento);

    Flux<Tratamiento> findAll();

    Mono<Void> delete(String id);

    Mono<Tratamiento> update(String id, Tratamiento tratamiento);

    Mono<Tratamiento> findById(String id);
}
