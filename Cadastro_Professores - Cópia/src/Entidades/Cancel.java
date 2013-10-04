/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 *
 * @author Tiago
 */
@Entity
public class Cancel implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private String codigo, dataCancel;
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_Cancel")
    private List<Disciplinas> disciplinas = new ArrayList();
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professora professor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataCancel() {
        return dataCancel;
    }

    public void setDataCancel(String dataCancel) {
        this.dataCancel = dataCancel;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplina(Disciplinas disciplina) {
        this.disciplinas.add(disciplina);
    }

    public Professora getProfessor() {
        return professor;
    }

    public void setProfessor(Professora professor) {
        this.professor = professor;
    }
}
