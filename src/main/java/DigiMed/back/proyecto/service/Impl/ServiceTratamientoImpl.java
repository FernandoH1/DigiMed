package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.repository.TratamientoRepository;
import DigiMed.back.proyecto.service.ServiceTratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceTratamientoImpl implements ServiceTratamiento {
    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public Mono<Tratamiento> save(Tratamiento tratamiento) {
        return this.tratamientoRepository.save(tratamiento);
    }

    @Override
    public Flux<Tratamiento> findAll() {
        return this.tratamientoRepository.findAll();
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.tratamientoRepository.deleteById(id);
    }

    @Override
    public Mono<Tratamiento> update(String id, Tratamiento tratamiento) {
        return this.tratamientoRepository.findById(id)
                .flatMap(tratamiento1 -> {
                    tratamiento.setId(id);
                    return save(tratamiento);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Tratamiento> findById(String id) {
        return this.tratamientoRepository.findById(id);
    }
}
