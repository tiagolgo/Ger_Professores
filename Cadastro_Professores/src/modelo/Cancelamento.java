package modelo;

import java.io.Serializable;
import modelo.Pessoa.Professor;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import modelo.curricular.Disciplina;

@Entity
public class Cancelamento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 8)
    private String data_Cancelamento;
    @Column(length = 30)
    private String motivo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_professor")
    private Professor professor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Cancelamento")
    private ArrayList<Disciplina> disciplina;

    public Cancelamento() {
        this.disciplina = new ArrayList();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setData_Cancelamento(String data_Cancelamento) {
        this.data_Cancelamento = data_Cancelamento;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }
    
    public void setDisciplina(Disciplina d){
        this.disciplina.add(d);
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getData_Cancelamento() {
        return data_Cancelamento;
    }

    public String getMotivo() {
        return motivo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }
}
