package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.service.ServiceTratamiento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceTratamientoImplTest {

    @Autowired
    ServiceTratamiento serviceTratamiento;

    @Test
    void save() {
        Tratamiento tratamiento = new Tratamiento();
        Mono<Tratamiento> tratamiento1 = serviceTratamiento.save(tratamiento);
        StepVerifier.create(tratamiento1).expectNext(tratamiento).verifyComplete();
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
}