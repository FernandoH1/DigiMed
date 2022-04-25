package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.repository.FuncionRepository;
import DigiMed.back.proyecto.service.ServiceFuncion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceFuncionImpl implements ServiceFuncion {
    @Autowired
    FuncionRepository funcionRepository;

    @Override
    public Mono<Funcion> save(Funcion funcion) {
        return this.funcionRepository.save(funcion);
    }

    @Override
    public Flux<Funcion> findAll() {
        return this.funcionRepository.findAll();
    }

    @Override
    public Mono<Funcion> delete(String id) {
        return this.funcionRepository
                .findById(id)
                .flatMap(funcion -> this.funcionRepository.deleteById(funcion.getId()).thenReturn(funcion));
    }

    @Override
    public Mono<Funcion> update(String id, Funcion funcion) {
        return this.funcionRepository.findById(id)
                .flatMap(funcion1 -> {
                    funcion.setId(id);
                    return save(funcion);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Funcion> findById(String id) {
        return this.funcionRepository.findById(id);
    }
}
