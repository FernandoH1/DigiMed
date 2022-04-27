package DigiMed.back.proyecto.modelDTO;

import DigiMed.back.proyecto.model.Cita;
import DigiMed.back.proyecto.model.Sintomas;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProgramarCitaDTO{

    private String id = UUID.randomUUID().toString().substring(0, 10);

    private LocalDateTime fecha;

    private String correo;

    private Sintomas sintomas;

    public ProgramarCitaDTO(){
    }

    public ProgramarCitaDTO(LocalDateTime fecha, String correo, Sintomas sintomas) {
        this.fecha = fecha;
        this.correo = correo;
        this.sintomas = sintomas;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return "ProgramarCitaDTO{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", correo='" + correo + '\'' +
                ", sintomas=" + sintomas +
                '}';
    }
}
