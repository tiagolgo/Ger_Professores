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
public class Substituica implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String dataSubs, inicio;
    @OneToMany
    @JoinColumn(name = "id_Subst")
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<Disciplinas> disciplinas = new ArrayList();
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professora substituto;
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Afastament afastamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataSubs() {
        return dataSubs;
    }

    public void setDataSubs(String dataSubs) {
        this.dataSubs = dataSubs;
    }

    public Professora getSubstituto() {
        return substituto;
    }

    public void setSubstituto(Professora substituto) {
        this.substituto = substituto;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplina(Disciplinas d) {
        this.disciplinas.add(d);
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public Afastament getAfastamento() {
        return afastamento;
    }

    public void setAfastamento(Afastament afastamento) {
        this.afastamento = afastamento;
    }
}
