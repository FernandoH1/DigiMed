package DigiMed.back.proyecto.service;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Paciente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicePaciente {
    Mono<Paciente> save(Paciente paciente);

    Flux<Paciente> findAll();

    Mono<Paciente> delete(String id);

    Mono<Paciente> update(String id, Paciente paciente);

    Mono<Paciente> findById(String id);

    Mono<Paciente> agendarCitaPaciente(String id, Cita cita);

    Mono<Paciente> findByDNI(String DNI);
}
