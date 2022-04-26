package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.model.Tratamiento;
import DigiMed.back.proyecto.service.Impl.ServicePacienteImpl;
import DigiMed.back.proyecto.service.Impl.ServiceProgramarCitaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pc")
public class ProgramarCitaController {

    @Autowired
    private ServiceProgramarCitaImpl serviceProgramarCita;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cita> saveCita(@RequestBody Cita cita) {
        return this.serviceProgramarCita.save(cita);
    }

    @GetMapping()
    private Flux<Cita> AllCitas() {
        return this.serviceProgramarCita.findAll();
    }

    @GetMapping(value = "/{id}")
    private Mono<Cita> searchPacienteByID(@PathVariable("id") String id) {
        return this.serviceProgramarCita.findById(id);
    }
}
