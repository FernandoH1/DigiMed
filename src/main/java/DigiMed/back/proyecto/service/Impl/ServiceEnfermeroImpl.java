package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceEnfermeroImpl implements ServiceEnfermero {
    @Autowired
    EnfermeroRepository enfermeroRepository;

    @Override
    public Mono<Enfermero> save(Enfermero enfermero) {
        return this.enfermeroRepository.save(enfermero);
    }

    @Override
    public Flux<Enfermero> findAll() {
        return this.enfermeroRepository.findAll();
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.enfermeroRepository.deleteById(id);
    }

    @Override
    public Mono<Enfermero> update(String id, Enfermero enfermero) {
        return this.enfermeroRepository.findById(id)
                .flatMap(enfermero1 -> {
                    enfermero.setId(id);
                    return save(enfermero);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Enfermero> findById(String id) {
        return this.enfermeroRepository.findById(id);
    }

    public Mono<Enfermero> cambiarDisponibilidad (String id){
        return this.enfermeroRepository.findById(id).flatMap(enfermero1 -> {
            enfermero1.cambiarDisponibilidad();
            return enfermeroRepository.save(enfermero1);
        });
    }
}
