package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Diagnostico;
import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.service.ServiceAtencionMedica;
import jdk.jshell.Diag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceAtencionMedicaImplTest {

    @Autowired
    ServiceAtencionMedica serviceAtencionMedica;

    @Test
    void save() {
        AtencionMedica atencionMedica = new AtencionMedica();
        Mono<AtencionMedica> atencionMedica1 = serviceAtencionMedica.save(atencionMedica);
        StepVerifier.create(atencionMedica1).expectNext(atencionMedica).verifyComplete();
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
    void agregarTratamiento() {
    }
}