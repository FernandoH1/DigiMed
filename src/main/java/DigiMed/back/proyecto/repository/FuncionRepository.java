package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Funcion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FuncionRepository extends ReactiveMongoRepository<Funcion,String> {
}
