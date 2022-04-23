package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Paciente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PacienteRepository extends ReactiveMongoRepository<Paciente,String> {
}
