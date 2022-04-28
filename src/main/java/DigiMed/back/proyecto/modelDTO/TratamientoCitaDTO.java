package DigiMed.back.proyecto.modelDTO;

import DigiMed.back.proyecto.model.Tratamiento;

import java.time.LocalDateTime;
import java.util.Objects;

public class TratamientoCitaDTO {

    private LocalDateTime fecha;

    private Tratamiento tratamiento;

    public TratamientoCitaDTO() {
    }

    public TratamientoCitaDTO(LocalDateTime fecha, Tratamiento tratamiento) {
        this.fecha = fecha;
        this.tratamiento = tratamiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TratamientoCitaDTO that = (TratamientoCitaDTO) o;
        return Objects.equals(fecha, that.fecha) && Objects.equals(tratamiento, that.tratamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tratamiento);
    }

    @Override
    public String toString() {
        return "CitaPosteriorDTO{" +
                "fecha=" + fecha +
                ", tratamiento=" + tratamiento +
                '}';
    }
}
