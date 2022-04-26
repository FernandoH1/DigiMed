package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.model.Funcion;
import DigiMed.back.proyecto.modelDTO.EmailEnfermeroDTO;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ServiceEnfermeroImplTest {

    @Autowired
    ServiceEnfermero servicio;

    @MockBean
    EnfermeroRepository repository;

    @Test
    void save() {
        Enfermero enfermero = new Enfermero("enfermero", "enfermero@gmail.com" , false);
        when(repository.save(any())).thenReturn(Mono.just(enfermero));
        Mono<Enfermero> enfermero1 = servicio.save(enfermero);
        StepVerifier.create(enfermero1).expectNext(enfermero).verifyComplete();
    }

    @Test
    void findAll() {
        Enfermero enfermero = new Enfermero("enfermero", "enfermero@gmail.com" , false);
        when(repository.findAll()).thenReturn(Flux.just(enfermero));
        Flux<Enfermero> enfermero1 = servicio.findAll();
        StepVerifier.create(enfermero1).expectNext(enfermero).verifyComplete();
    }

//    @Test
//    @DisplayName("Test envio de notificacion al enfermero")
//    void testEnviarEmailNotificacion() throws Exception {
////        arrange
//        Enfermero enfermero = new Enfermero("enfermero01", "whenao86@gmial.com", true);
//        EmailEnfermeroDTO enfermeroDTO = new EmailEnfermeroDTO(
//                "enfermeroId0001",
//                new Funcion("inmovilizar miembro", "ferula doble en pulgar"),
//                "10171298"
//        );
//
////        repository2 = mock(EnfermeroRepository.class);
//
//        when(repository.findById("enfermero01")).thenReturn(Mono.just(enfermero));
////        act-assert
//        StepVerifier.create(servicio.sendNotificationEmail(enfermeroDTO))
//                .expectComplete()// ("Message succesfully sent")
//                .verify();
//
//    }

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