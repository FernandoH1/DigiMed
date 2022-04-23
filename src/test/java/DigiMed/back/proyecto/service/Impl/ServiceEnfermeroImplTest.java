package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
class ServiceEnfermeroImplTest {
    @Autowired
    ServiceEnfermero servicio;

    @Test
    void save() {
        Enfermero enfermero = new Enfermero("enfermero", "enfermero@gmail.com" , false);
        Mono<Enfermero> enfermero1 = servicio.save(enfermero);
        StepVerifier.create(enfermero1).expectNext(enfermero).verifyComplete();
    }

}