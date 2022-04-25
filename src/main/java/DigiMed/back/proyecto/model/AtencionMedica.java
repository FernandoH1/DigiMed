package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "atencion_medica")
public class AtencionMedica {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String DoctorID;
    private String PacienteID;
    private Diagnostico diagnostico;
    private Tratamiento tratamiento;

    public AtencionMedica(){}

    public AtencionMedica(String doctorID, String pacienteID, Diagnostico diagnostico) {
        DoctorID = doctorID;
        PacienteID = pacienteID;
        this.diagnostico = diagnostico;
    }

    public AtencionMedica(String id, String doctorID, String pacienteID, Diagnostico diagnostico, Tratamiento tratamiento) {
        this.id = id;
        DoctorID = doctorID;
        PacienteID = pacienteID;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(String doctorID) {
        DoctorID = doctorID;
    }

    public String getPacienteID() {
        return PacienteID;
    }

    public void setPacienteID(String pacienteID) {
        PacienteID = pacienteID;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "AtencionMedica{" +
                "id='" + id + '\'' +
                ", DoctorID='" + DoctorID + '\'' +
                ", PacienteID='" + PacienteID + '\'' +
                ", diagnostico=" + diagnostico +
                ", tratamiento=" + tratamiento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtencionMedica that = (AtencionMedica) o;
        return Objects.equals(id, that.id) && Objects.equals(DoctorID, that.DoctorID) && Objects.equals(PacienteID, that.PacienteID) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(tratamiento, that.tratamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
