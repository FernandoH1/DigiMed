package DigiMed.back.proyecto.service.Impl;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.repository.CitaRepository;
import DigiMed.back.proyecto.service.ServiceProgramarCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceProgramarCitaImpl implements ServiceProgramarCita {

    @Autowired
    CitaRepository citaRepository;

    ServiceEmailImpl serviceEmailImpl;

    @Override
    public Mono<Cita> save(Cita cita) {
        try {
            String subject = "CitaMedica";
            String text = "Tu cita ha quedado programada para la siguente fecha: "
                    +cita.getFecha();
            serviceEmailImpl.sendEmailMessage(cita.getCorreo(), subject,text);

        }catch(NullPointerException e) {
            System.out.println("Null Pointer: "+e.getMessage());
        };
        return this.citaRepository.save(cita);
    }



    @Override
    public Flux<Cita> findAll() {
        return this.citaRepository.findAll();
    }

    @Override
    public Mono<Cita> findById(String id) {
        return citaRepository.findById(id);
    }
}
