/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Tiago
 */
@Entity
public class Turmas implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int serie;
    private String seriacao;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Curso")
    private Cursos curso;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_Turmas")
//    private List<Disciplinas> disciplinas = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getSeriacao() {
        return seriacao;
    }

    public void setSeriacao(String seriacao) {
        this.seriacao = seriacao;
    }

//    public List<Disciplinas> getDisciplinas() {
//        return disciplinas;
//    }
//
//    public void setDisciplinas(List<Disciplinas> disciplinas) {
//        this.disciplinas = disciplinas;
//    }
//
    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }
}
