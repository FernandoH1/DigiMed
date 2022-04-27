package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.repository.TratamientoRepository;
import DigiMed.back.proyecto.service.ServiceTratamiento;
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
class ServiceTratamientoImplTest {

    @Autowired
    ServiceTratamiento serviceTratamiento;

    @MockBean
    TratamientoRepository tratamientoRepository;

    @Test
    void save() {
        Tratamiento tratamiento = new Tratamiento();
        when(tratamientoRepository.save(any())).thenReturn(Mono.just(tratamiento));
        Mono<Tratamiento> tratamiento1 = serviceTratamiento.save(tratamiento);
        StepVerifier.create(tratamiento1).expectNext(tratamiento).verifyComplete();
    }

    @Test
    void findAll() {
        Tratamiento tratamiento = new Tratamiento();
        when(tratamientoRepository.findAll()).thenReturn(Flux.just(tratamiento));
        Flux<Tratamiento> tratamiento1 = tratamientoRepository.findAll();
        StepVerifier.create(tratamiento1).expectNext(tratamiento).verifyComplete();
    }

    @Test
    void update() {
        Tratamiento tratamiento = new Tratamiento();
        when(tratamientoRepository.save(any())).thenReturn(Mono.just(tratamiento));
        Mono<Tratamiento> tratamiento1 = serviceTratamiento.save(tratamiento);
        StepVerifier.create(tratamiento1).expectNext(tratamiento).verifyComplete();
    }

    @Test
    void findById() {
        Tratamiento tratamiento = new Tratamiento();
        when(tratamientoRepository.findAll()).thenReturn(Flux.just(tratamiento));
        Flux<Tratamiento> tratamiento1 = serviceTratamiento.findAll();
        StepVerifier.create(tratamiento1).expectNext(tratamiento).verifyComplete();
    }
}