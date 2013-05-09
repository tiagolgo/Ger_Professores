package modelo.Pessoa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("M")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String nome;
    private String estado;

    public Municipio() {
    }

    public Municipio(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + '}';
    }
}
