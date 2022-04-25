package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceEnfermeroImplTest {

    @Autowired
    ServiceEnfermero serviceEnfermero;


    @Test
    void save() {
        Enfermero enfermero = new Enfermero("enfermero", "enfermero@gmail.com" , false);
        Mono<Enfermero> enfermero1 = serviceEnfermero.save(enfermero);
        StepVerifier.create(enfermero1).expectNext(enfermero).verifyComplete();
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void cambiarDisponibilidad() {
    }
}