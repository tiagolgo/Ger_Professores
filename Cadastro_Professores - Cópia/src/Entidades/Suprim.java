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
public class Suprim implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String codigo, dataSuprim, dataInicio;
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_Supim")
    private List<Disciplinas> disciplinas = new ArrayList();
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professora professor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataSuprim() {
        return dataSuprim;
    }

    public void setDataSuprim(String dataSuprim) {
        this.dataSuprim = dataSuprim;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplina(Disciplinas disciplinas) {
        this.disciplinas.add(disciplinas);
    }

    public Professora getProfessor() {
        return professor;
    }

    public void setProfessor(Professora professor) {
        this.professor = professor;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
