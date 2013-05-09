/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.curricular;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author tiago
 */
@Entity
public class MatrizCurricular implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int serie;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Matriz")
    private Curso curso;
    private Turno turno;//enum
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Matriz")
    private List<Disciplina> disciplinas;

    public MatrizCurricular() {
        disciplinas = new ArrayList();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplina(Disciplina disciplinas) {
        this.disciplinas.add(disciplinas);
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getSerie() {
        return serie;
    }

    public Curso getCurso() {
        return curso;
    }

    public Turno getTurno() {
        return turno;
    }

    public Disciplina getDisciplina(int código) {    //consulta disciplina por código
        for (Disciplina d : disciplinas) {
            if (código == d.getCodigo()) {
                return d;
            }
        }
        return null;
    }

    public List<Disciplina> getDisciplinas() {    //retorna as disciplinas da matriz
        return disciplinas;
    }
}
