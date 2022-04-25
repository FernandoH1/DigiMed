package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.service.ServicePaciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicePacienteImplTest {

    @Autowired
    ServicePaciente servicePaciente;

    @Test
    void save() {
        Paciente paciente = new Paciente();
        Mono<Paciente> paciente1 = servicePaciente.save(paciente);
        StepVerifier.create(paciente1).expectNext(paciente).verifyComplete();
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
    void agendarCitaPaciente() {
    }
}