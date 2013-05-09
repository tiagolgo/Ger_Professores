package modelo.Pessoa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dependente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 50)
    private int nome;
    @Column(length = 8)
    private int nascimento;

    public Dependente() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getNome() {
        return nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    @Override
    public String toString() {
        return "Dependente{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + '}';
    }
}
