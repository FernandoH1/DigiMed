package DigiMed.back.proyecto.controller;

import DigiMed.back.proyecto.modelDTO.ProgramarCitaDTO;
import DigiMed.back.proyecto.service.Impl.ServiceEmailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ff")
public class FormularioFeedbackController {

    @Autowired
    private ServiceEmailImpl serviceEmail;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<String> enviarFormulario(@RequestBody ProgramarCitaDTO dto ) {
        String subject = "Formulario de control de calidad en la atención de los pacientes - DigiMed ";
        String text = "Te he invitado a que rellenes un formulario:\n " +
                "Link:  https://forms.gle/Q7YR81Gb1WzMEpgA8";
        return this.serviceEmail.sendEmailMessage(dto.getCorreo(),subject,text);
    }
}
