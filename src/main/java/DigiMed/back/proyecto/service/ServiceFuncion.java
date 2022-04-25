package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.Funcion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceFuncion {
    Mono<Funcion> save(Funcion funcion);

    Flux<Funcion> findAll();

    Mono<Funcion> delete(String id);

    Mono<Funcion> update(String id, Funcion funcion);

    Mono<Funcion> findById(String id);
}
