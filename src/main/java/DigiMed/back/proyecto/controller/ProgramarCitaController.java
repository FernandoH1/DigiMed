package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.modelDTO.ProgramarCitaDTO;
import DigiMed.back.proyecto.service.Impl.ServiceEmailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProgramarCitaController {

    @Autowired
    private ServiceEmailImpl serviceEmail;

    @PostMapping("/pc")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<String> programarCita(@RequestBody ProgramarCitaDTO cita) {
        String subject = "CitaMedica";
        String text = "Tu cita ha quedado programada para la siguente fecha: "
                +cita.getFecha();
        return this.serviceEmail.sendEmailMessage(cita.getCorreo(),subject,text);
    }
}
