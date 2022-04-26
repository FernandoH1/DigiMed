package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.service.Impl.ServiceEmailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pc")
public class ProgramarCitaController {

    @Autowired
    private ServiceEmailImpl serviceEmail;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<String> saveCita(@RequestBody Cita cita) {
        String subject = "CitaMedica";
        String text = "Tu cita ha quedado programada para la siguente fecha: "
                +cita.getFecha();
        return this.serviceEmail.sendEmailMessage(cita.getCorreo(),subject,text);
    }

}
