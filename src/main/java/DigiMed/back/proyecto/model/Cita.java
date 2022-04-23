package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Document(collection = "citas")
public class Cita {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private LocalDate fecha;

    private Set<Sintomas> sintomas;

    public Cita() {}

    public Cita(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<Sintomas> getSintomas() {
        return sintomas;
    }

    public void setSintomas(Set<Sintomas> sintomas) {
        this.sintomas = sintomas;
    }
}
