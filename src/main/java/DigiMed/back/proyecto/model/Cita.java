package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Document(collection = "citas")
public class Cita {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private LocalDateTime fecha;

    private Sintomas sintoma;

    public Cita() {}

    public Cita(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Sintomas getSintomas() {
        return sintoma;
    }

    public void setSintomas(Sintomas sintoma) {
        this.sintoma = sintoma;
    }
}
