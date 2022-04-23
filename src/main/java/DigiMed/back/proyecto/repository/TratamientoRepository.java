package DigiMed.back.proyecto.repository;

import DigiMed.back.proyecto.model.Tratamiento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TratamientoRepository extends ReactiveMongoRepository<Tratamiento,String> {
}
