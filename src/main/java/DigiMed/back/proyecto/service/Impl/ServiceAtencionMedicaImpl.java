package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.AtencionMedica;
import DigiMed.back.proyecto.model.Tratamiento;
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
    public Mono<AtencionMedica> agregarTratamiento(String id, Tratamiento tratamiento){
        return this.atencionMedicaRepository.findById(id)
                .flatMap(atencionMedica -> {
                    atencionMedica.setTratamiento(tratamiento);
                    return  atencionMedicaRepository.save(atencionMedica);
                });
    }
}
