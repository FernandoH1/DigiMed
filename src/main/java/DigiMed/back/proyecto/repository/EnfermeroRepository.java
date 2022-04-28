package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Enfermero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface EnfermeroRepository extends ReactiveMongoRepository<Enfermero,String> {
    Mono<Enfermero> findByEmail(String email);
}
