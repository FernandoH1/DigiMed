package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Paciente;
import DigiMed.back.proyecto.model.Sintomas;
import DigiMed.back.proyecto.service.Impl.ServicePacienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private ServicePacienteImpl servicePaciente;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Paciente> savePaciente(@RequestBody Paciente paciente) {
        return this.servicePaciente.save(paciente);
    }

    @GetMapping()
    private Flux<Paciente> AllPacientes() {
        return this.servicePaciente.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Paciente>>deletePaciente(@PathVariable("id") String id) {
        return this.servicePaciente.delete(id)
                .flatMap(paciente -> Mono.just(ResponseEntity.ok(paciente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Paciente>> updatePaciente(@PathVariable("id") String id, @RequestBody Paciente paciente) {
        return this.servicePaciente.update(id, paciente)
                .flatMap(paciente1 -> Mono.just(ResponseEntity.ok(paciente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/{id}")
    private Mono<Paciente> searchPacienteByID(@PathVariable("id") String id) {
        return this.servicePaciente.findById(id);
    }


    @PostMapping(value = "/agendar-cita/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Paciente> agendarCita(@PathVariable("id") String id, @RequestBody Cita cita) {
        return this.servicePaciente.agendarCitaPaciente(id,cita);
    }

   @GetMapping(value = "/DNI/{DNI}")
    private Mono<Paciente> searchPacienteByDNI(@PathVariable("DNI") String dni) {
        return this.servicePaciente.findByDNI(dni);
    }


}
