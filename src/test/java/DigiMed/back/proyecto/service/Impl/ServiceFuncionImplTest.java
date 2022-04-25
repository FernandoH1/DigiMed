package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.service.ServiceFuncion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceFuncionImplTest {

    @Autowired
    ServiceFuncion serviceFuncion;

    @Test
    void save() {
        Funcion funcion = new Funcion();
        Mono<Funcion> funcion1 = serviceFuncion.save(funcion);
        StepVerifier.create(funcion1).expectNext(funcion).verifyComplete();
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