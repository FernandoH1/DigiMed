package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Document(collection = "pacientes")
public class Paciente {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;
    private String DNI;
    private String EPS;
    private String email;
    private String celular;
    private Set<Cita> citas;

    public Paciente(String nombre, String DNI, String EPS, String email, String celular) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.EPS = EPS;
        this.email = email;
        this.celular = celular;
        this.citas = new HashSet<>();
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Set<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", EPS='" + EPS + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", citas=" + citas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nombre, paciente.nombre) && Objects.equals(DNI, paciente.DNI) && Objects.equals(EPS, paciente.EPS) && Objects.equals(email, paciente.email) && Objects.equals(celular, paciente.celular) && Objects.equals(citas, paciente.citas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
