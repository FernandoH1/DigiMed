package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.repository.FuncionRepository;
import DigiMed.back.proyecto.service.ServiceFuncion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServiceFuncionImplTest {

    @Autowired
    ServiceFuncion serviceFuncion;

    @MockBean
    FuncionRepository funcionRepository;

    @Test
    void save() {
        Funcion funcion = new Funcion();
        when(funcionRepository.save(any())).thenReturn(Mono.just(funcion));
        Mono<Funcion> funcion1 = serviceFuncion.save(funcion);
        StepVerifier.create(funcion1).expectNext(funcion).verifyComplete();
    }

    @Test
    void findAll() {
        Funcion funcion = new Funcion();
        when(funcionRepository.findAll()).thenReturn(Flux.just(funcion));
        Flux<Funcion> funcion1 = serviceFuncion.findAll();
        StepVerifier.create(funcion1).expectNext(funcion).verifyComplete();
    }

    @Test
    void update() {
        Funcion funcion = new Funcion();
        when(funcionRepository.save(any())).thenReturn(Mono.just(funcion));
        Mono<Funcion> funcion1 = serviceFuncion.save(funcion);
        StepVerifier.create(funcion1).expectNext(funcion).verifyComplete();
    }

    @Test
    void findById() {
        Funcion funcion = new Funcion();
        when(funcionRepository.findById(funcion.getId())).thenReturn(Mono.just(funcion));
        Mono<Funcion> funcion1 = serviceFuncion.findById(funcion.getId());
        StepVerifier.create(funcion1).expectNext(funcion).verifyComplete();
    }
}