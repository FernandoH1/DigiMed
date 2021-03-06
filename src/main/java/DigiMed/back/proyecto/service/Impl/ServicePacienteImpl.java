package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.repository.PacienteRepository;
import DigiMed.back.proyecto.service.ServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicePacienteImpl implements ServicePaciente {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Mono<Paciente> save(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }

    @Override
    public Flux<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Override
    public Mono<Paciente> delete(String id) {
        return this.pacienteRepository
                .findById(id)
                .flatMap(paciente -> this.pacienteRepository.deleteById(paciente.getId()).thenReturn(paciente));
    }

    @Override
    public Mono<Paciente> update(String id, Paciente paciente) {
        return this.pacienteRepository.findById(id)
                .flatMap(paciente1 -> {
                    paciente.setId(id);
                    return save(paciente);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Paciente> findById(String id) {
        return this.pacienteRepository.findById(id);
    }


    @Override
    public Mono<Paciente> agendarCitaPaciente(String id, Cita cita){
        return this.pacienteRepository.findById(id)
                .flatMap(paciente1 -> {
                    paciente1.getCitas().add(cita);
                    return pacienteRepository.save(paciente1);
        });
    }

    @Override
    public Mono<Paciente> findByDNI(String DNI) {
        return this.pacienteRepository.findByDNI(DNI).switchIfEmpty(Mono.just(new Paciente()));
    }
}
