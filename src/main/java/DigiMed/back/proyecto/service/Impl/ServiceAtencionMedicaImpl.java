package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.modelDTO.TratamientoCitaDTO;
import DigiMed.back.proyecto.repository.AtencionMedicaRepository;
import DigiMed.back.proyecto.service.ServiceAtencionMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceAtencionMedicaImpl implements ServiceAtencionMedica {
    @Autowired
    AtencionMedicaRepository atencionMedicaRepository;

    @Autowired
    ServiceEmailImpl serviceEmail;

    @Autowired
    ServicePacienteImpl servicePaciente;

    @Override
    public Mono<AtencionMedica> save(AtencionMedica atencionMedica) {
        return this.atencionMedicaRepository.save(atencionMedica);
    }

    @Override
    public Flux<AtencionMedica> findAll() {
        return this.atencionMedicaRepository.findAll();
    }

    @Override
    public Mono<AtencionMedica> delete(String id) {
        return this.atencionMedicaRepository
                .findById(id)
                .flatMap(atencionMedica -> this.atencionMedicaRepository.deleteById(atencionMedica.getId()).thenReturn(atencionMedica));
    }
    @Override
    public Mono<AtencionMedica> update(String id, AtencionMedica atencionMedica) {
        return this.atencionMedicaRepository.findById(id)
                .flatMap(atencionMedica1 -> {
                    atencionMedica.setId(id);
                    return save(atencionMedica);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<AtencionMedica> findById(String id) {
        return this.atencionMedicaRepository.findById(id);
    }

    @Override
    public Mono<AtencionMedica> agregarTratamiento(String id, TratamientoCitaDTO tratamientoCitaDTO){
        return this.atencionMedicaRepository.findById(id)
                .flatMap(atencionMedica -> {
                    atencionMedica.setTratamiento(tratamientoCitaDTO.getTratamiento());
                    return  atencionMedicaRepository.save(atencionMedica);
                });
    }

    public Mono<AtencionMedica> agregarTratamientoCita(String id, TratamientoCitaDTO tratamientoCitaDTO){
        System.out.println(tratamientoCitaDTO);
        return this.atencionMedicaRepository.findById(id)
                .flatMap(atencionMedica -> {
                    return this.servicePaciente.findById(atencionMedica.getPacienteID())
                                    .flatMap(paciente -> {
                                        this.serviceEmail.sendEmailMessage(
                                                paciente.getEmail(),
                                                String.format("DigiMed - Cita programada "),
                                                String.format("Apreciado %s \n\nTu cita ha quedado programada para la siguente fecha:\n%s ",
                                                        paciente.getNombre(),
                                                        tratamientoCitaDTO.getFecha().toString())
                                                );
                                        atencionMedica.setTratamiento(tratamientoCitaDTO.getTratamiento());
                                        paciente.getCitas().add(new Cita(tratamientoCitaDTO.getFecha().toLocalDate()));
                                        this.servicePaciente.update(paciente.getId(), paciente).subscribe(System.out::println);
                                        return  atencionMedicaRepository.save(atencionMedica);
                                    });
                });
    }
}
