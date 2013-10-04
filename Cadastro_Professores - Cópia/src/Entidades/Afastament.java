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
public class Afastament implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String dataAfas, inicio, fim, motivo;
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professora afastado;
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_Afastameto")
    private List<Disciplinas> disciplinas = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataAfas() {
        return dataAfas;
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

    public void setDataAfas(String dataAfas) {
        this.dataAfas = dataAfas;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Professora getAfastado() {
        return afastado;
    }

    public void setAfastado(Professora afastado) {
        this.afastado = afastado;
    }
}
