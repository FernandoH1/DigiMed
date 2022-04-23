package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.AtencionMedica;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AtencionMedicaRepository extends ReactiveMongoRepository<AtencionMedica,String> {
}
