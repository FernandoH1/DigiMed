package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.modelDTO.EmailEnfermeroDTO;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@SpringBootTest
class ServiceEnfermeroImplTest {
    @Autowired
    ServiceEnfermero servicio;

    EnfermeroRepository repository;

    @Test
    void save() {
        Enfermero enfermero = new Enfermero("enfermero", "enfermero@gmail.com" , false);
        Mono<Enfermero> enfermero1 = servicio.save(enfermero);
        StepVerifier.create(enfermero1).expectNext(enfermero).verifyComplete();
    }

    @Test
    @DisplayName("Test envio de notificacion al enfermero")
    void testEnviarEmailNotificacion() throws Exception {
//        arrange
        Enfermero enfermero = new Enfermero("enfermero01", "whenao86@gmial.com", true);
        EmailEnfermeroDTO enfermeroDTO = new EmailEnfermeroDTO(
                "enfermeroId0001",
                new Funcion("inmovilizar miembro", "ferula doble en pulgar"),
                "10171298"
        );

        repository = mock(EnfermeroRepository.class);

        when(repository.findById("enfermeroId0001")).thenReturn(Mono.just(enfermero));
//        act-assert
        StepVerifier.create(servicio.sendNotificationEmail(enfermeroDTO))
                .expectComplete()// ("Message succesfully sent")
                .verify();

    }
}