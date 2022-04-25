package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.service.Impl.ServicePacienteImpl;
import DigiMed.back.proyecto.service.Impl.ServiceProgramarCitaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pc")
public class ProgramarCitaController {

    @Autowired
    private ServiceProgramarCitaImpl serviceProgramarCita;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<> savePaciente(@RequestBody Paciente paciente) {
        return this.serviceProgramarCita.save(paciente);
    }

}
