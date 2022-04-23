package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Document(collection = "doctores")
public class Doctor {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private Set<Funcion> funciones;

    private Set<Enfermero> enfermeros;

    private String nombre;

    public Doctor() {}

    public Doctor(Set<Funcion> funciones, Set<Enfermero> enfermeros, String nombre) {
        this.funciones = funciones;
        this.enfermeros = enfermeros;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(Set<Funcion> funciones) {
        this.funciones = funciones;
    }

    public Set<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(Set<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", funciones=" + funciones +
                ", enfermeros=" + enfermeros +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(funciones, doctor.funciones) && Objects.equals(enfermeros, doctor.enfermeros) && Objects.equals(nombre, doctor.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
