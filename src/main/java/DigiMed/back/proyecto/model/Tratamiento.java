package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "tratamientos")
public class Tratamiento {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String procedimiento;

    private Estados estado;

    public Tratamiento() {}

    public Tratamiento(String procedimiento, Estados estado) {
        this.procedimiento = procedimiento;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "id='" + id + '\'' +
                ", procedimiento='" + procedimiento + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tratamiento that = (Tratamiento) o;
        return Objects.equals(id, that.id) && Objects.equals(procedimiento, that.procedimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Estados{
        INGRESADO_HOSPITAL, DADO_DE_ALTA , REMITIDO
    }
}
