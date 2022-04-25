package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "enfermeros")
public class Enfermero {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;

    private String email;

    private Boolean isActive;

    public Enfermero() {}

    public Enfermero(String nombre, String email, Boolean isActive) {
        this.nombre = nombre;
        this.email = email;
        this.isActive = isActive;
    }

   public Enfermero(String id, String nombre, String email, Boolean isActive) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void cambiarDisponibilidad(){
        this.isActive = !this.isActive;
    }

    @Override
    public String toString() {
        return "Enfermero{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enfermero enfermero = (Enfermero) o;
        return Objects.equals(id, enfermero.id) && Objects.equals(nombre, enfermero.nombre) && Objects.equals(email, enfermero.email) && Objects.equals(isActive, enfermero.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
