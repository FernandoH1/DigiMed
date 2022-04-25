package DigiMed.back.proyecto.modelDTO;

import DigiMed.back.proyecto.model.Funcion;
import javax.validation.constraints.NotBlank;


public class EmailEnfermeroDTO {

    @NotBlank(message = "Debe existir el enfermeroId para este objeto")
    private String enfermeroId;
    @NotBlank(message = "Debe existir una funcion a asignar")
    private Funcion funcion;
    @NotBlank(message = "Debe existir un documento de identidad de paciente")
    private String pacienteDNI;

    public EmailEnfermeroDTO() {
    }

    public EmailEnfermeroDTO(String enfermeroId, Funcion funcion, String pacienteDNI) {
        this.enfermeroId = enfermeroId;
        this.funcion = funcion;
        this.pacienteDNI = pacienteDNI;
    }

    public String getEnfermeroId() {
        return enfermeroId;
    }

    public void setEnfermeroId(String enfermeroId) {
        this.enfermeroId = enfermeroId;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public String getPacienteDNI() {
        return pacienteDNI;
    }

    public void setPacienteDNI(String pacienteDNI) {
        this.pacienteDNI = pacienteDNI;
    }

    @Override
    public String toString() {
        return "EmailEnfermeroDTO{" +
                "enfermeroId='" + enfermeroId + '\'' +
                ", funcion=" + funcion +
                ", pacienteDNI='" + pacienteDNI + '\'' +
                '}';
    }
}
