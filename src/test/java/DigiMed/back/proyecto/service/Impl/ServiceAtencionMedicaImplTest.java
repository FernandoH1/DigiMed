package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Diagnostico;
import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.repository.AtencionMedicaRepository;
import DigiMed.back.proyecto.service.ServiceAtencionMedica;
import jdk.jshell.Diag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ServiceAtencionMedicaImplTest {
    @Autowired
    ServiceAtencionMedica serviceAtencionMedica;
    @MockBean
    AtencionMedicaRepository repository;

    @Test
    void save() {
        AtencionMedica atencionMedica = new AtencionMedica();
        when(repository.save(any())).thenReturn(Mono.just(atencionMedica));
        Mono<AtencionMedica> atencionMedica1 = serviceAtencionMedica.save(atencionMedica);
        StepVerifier.create(atencionMedica1).expectNext(atencionMedica).verifyComplete();
    }

    @Test
    void findAll() {
        AtencionMedica atencionMedica = new AtencionMedica();
        when(repository.findAll()).thenReturn(Flux.just(atencionMedica));
        Flux<AtencionMedica> atencionMedica1 = serviceAtencionMedica.findAll();
        StepVerifier.create(atencionMedica1).expectNext(atencionMedica).verifyComplete();
    }

    @Test
    void delete() {
        /*AtencionMedica atencionMedica = new AtencionMedica();
        when(repository.delete(atencionMedica)).thenThrow();
        Mono<AtencionMedica> atencionMedica1 = serviceAtencionMedica.delete(atencionMedica.getId());
        StepVerifier.create(atencionMedica1).expectNext(atencionMedica).verifyComplete();*/
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void agregarTratamiento() {
    }
}