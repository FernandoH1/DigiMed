package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Cita;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CitaRepository extends ReactiveMongoRepository<Cita,String> {

}
