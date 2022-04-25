package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Paciente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface PacienteRepository extends ReactiveMongoRepository<Paciente,String> {
    Mono<Paciente> findByDNI(String DNI);
}
