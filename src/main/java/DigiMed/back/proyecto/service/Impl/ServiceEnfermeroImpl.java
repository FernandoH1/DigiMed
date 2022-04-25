package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Enfermero;
import DigiMed.back.proyecto.modelDTO.EmailEnfermeroDTO;
import DigiMed.back.proyecto.repository.EnfermeroRepository;
import DigiMed.back.proyecto.service.ServiceEnfermero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceEnfermeroImpl implements ServiceEnfermero {
    @Autowired
    EnfermeroRepository enfermeroRepository;

    @Autowired
    ServiceEmailImpl serviceEmail;

    @Override
    public Mono<Enfermero> save(Enfermero enfermero) {
        return this.enfermeroRepository.save(enfermero);
    }

    @Override
    public Flux<Enfermero> findAll() {
        return this.enfermeroRepository.findAll();
    }

    @Override
    public Mono<Enfermero> delete(String id) {
        return this.enfermeroRepository
                .findById(id)
                .flatMap(enfermero -> this.enfermeroRepository.deleteById(enfermero.getId()).thenReturn(enfermero));
    }

    @Override
    public Mono<Enfermero> update(String id, Enfermero enfermero) {
        return this.enfermeroRepository.findById(id)
                .flatMap(enfermero1 -> {
                    enfermero.setId(id);
                    return save(enfermero);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Enfermero> findById(String id) {
        return this.enfermeroRepository.findById(id);
    }

    public Mono<Enfermero> cambiarDisponibilidad (String id){
        return this.enfermeroRepository.findById(id).flatMap(enfermero1 -> {
            enfermero1.cambiarDisponibilidad();
            return enfermeroRepository.save(enfermero1);
        });
    }

    @Override
    public Flux<Enfermero> findActive(){
        return findAll().filter(enfermero -> enfermero.getActive());
    }

    public Mono<String> sendNotificationEmail(EmailEnfermeroDTO emailEnfermeroDTO) {
        System.out.println(emailEnfermeroDTO);
        return findById(emailEnfermeroDTO.getEnfermeroId())
                .flatMap(enfermero -> serviceEmail.sendEmailMessage(
                            enfermero.getEmail(),
                            String.format("DigiMed - notificacion de funcion para paciente %s", emailEnfermeroDTO.getPacienteDNI()),
                            String.format("Querid@ %s. \nPor favor ejecutar la funcion:\"%s\"\nDescripcion de funcion: \"%s\"\n al paciente con documento de identidad %s",
                                    enfermero.getNombre(),
                                    emailEnfermeroDTO.getFuncion().getNombre(),
                                    emailEnfermeroDTO.getFuncion().getDescripcion(),
                                    emailEnfermeroDTO.getPacienteDNI()
                                )
                            )
                );
    }
}
