package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.model.Tratamiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceProgramarCita {

    Mono<Cita> save(Cita cita);

    Flux<Cita> findAll();

    Mono<Cita> findById(String id);
}
