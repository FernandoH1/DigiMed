package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.repository.PacienteRepository;
import DigiMed.back.proyecto.service.ServicePaciente;
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
class ServicePacienteImplTest {

    @Autowired
    ServicePaciente servicePaciente;

    @MockBean
    PacienteRepository pacienteRepository;

    @Test
    void save() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.save(any())).thenReturn(Mono.just(paciente));
        Mono<Paciente> paciente1 = servicePaciente.save(paciente);
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
    }

    @Test
    void findAll() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.findAll()).thenReturn(Flux.just(paciente));
        Flux<Paciente> paciente1 = servicePaciente.findAll();
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
    }



    @Test
    void update() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.save(any())).thenReturn(Mono.just(paciente));
        Mono<Paciente> paciente1 = servicePaciente.save(paciente);
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
    }

    @Test
    void findById() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.findAll()).thenReturn(Flux.just(paciente));
        Flux<Paciente> paciente1 = servicePaciente.findAll();
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
    }


    @Test
    void findByDNI(){
        Paciente paciente = new Paciente();
        when(pacienteRepository.findByDNI(paciente.getDNI())).thenReturn(Mono.just(paciente));
        Mono<Paciente> paciente1 = servicePaciente.findByDNI(paciente.getDNI());
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
    }
}