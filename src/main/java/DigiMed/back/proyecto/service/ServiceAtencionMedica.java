package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Tratamiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceAtencionMedica {
    Mono<AtencionMedica> save(AtencionMedica atencionMedica);

    Flux<AtencionMedica> findAll();

    Mono<Void> delete(String id);

    Mono<AtencionMedica> update(String id, AtencionMedica atencionMedica);

    Mono<AtencionMedica> findById(String id);

    Mono<AtencionMedica> agregarTratamiento(String id, Tratamiento tratamiento);
}
