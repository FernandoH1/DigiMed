package DigiMed.back.proyecto.model;

public class Sintomas {

    private String descripcion;

    public Sintomas(){
    }

    public Sintomas(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
