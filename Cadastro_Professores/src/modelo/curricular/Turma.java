package modelo.curricular;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Tiago
 */
@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 1)
    private int serie;
    private String seriacao;
    private String turno;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Curso")
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Turma")
    private List<Disciplina> disciplina;

    public Turma() {
        this.disciplina = new ArrayList();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public void setSeriacao(String seriacao) {
        this.seriacao = seriacao;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setDisciplina(Disciplina d) {
        this.disciplina.add(d);
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getSerie() {
        return serie;
    }

    public String getSeriacao() {
        return seriacao;
    }

    public String getTurno() {
        return turno;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplina;
    }
}
