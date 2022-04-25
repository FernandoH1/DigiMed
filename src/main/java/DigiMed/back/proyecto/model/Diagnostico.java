package DigiMed.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "diagnosticos")
public class Diagnostico {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String medicamentos;
    private String resultados;

    public Diagnostico() {}

    public Diagnostico(String medicamentos, String resultados) {
        this.medicamentos = medicamentos;
        this.resultados = resultados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }


    @Override
    public String toString() {
        return "Diagnostico{" +
                "id='" + id + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", resultados='" + resultados + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostico that = (Diagnostico) o;
        return Objects.equals(id, that.id) && Objects.equals(medicamentos, that.medicamentos) && Objects.equals(resultados, that.resultados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
