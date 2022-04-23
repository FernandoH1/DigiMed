package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Enfermero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EnfermeroRepository extends ReactiveMongoRepository<Enfermero,String> {
}
