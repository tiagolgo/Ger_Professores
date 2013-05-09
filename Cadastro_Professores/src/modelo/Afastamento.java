package modelo;

import java.io.Serializable;
import modelo.Pessoa.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import modelo.curricular.Disciplina;

@Entity
public class Afastamento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
//    @Column(length = 8)
    private String dataAfastamento;
//    @Column(length = 8)
    private String inicioAfastamento;
//    @Column(length = 8)
    private String fimAfastamento;
    private boolean suprido;
//    @Column(length = 30)
    private String motivo;
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_Afastamento")
    private Professor afastado;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Afastamento")
    private List<Disciplina> disciplina;

    public Afastamento() {
        this.disciplina=new ArrayList();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDataAfastamento(String dataAfastamento) {
        this.dataAfastamento = dataAfastamento;
    }

    public void setInicioAfastamento(String inicioAfastamento) {
        this.inicioAfastamento = inicioAfastamento;
    }

    public void setFimAfastamento(String fimAfastamento) {
        this.fimAfastamento = fimAfastamento;
    }

    public void setSuprido(boolean suprido) {
        this.suprido = suprido;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setAfastado(Professor afastado) {
        this.afastado = afastado;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getDataAfastamento() {
        return dataAfastamento;
    }

    public String getInicioAfastamento() {
        return inicioAfastamento;
    }

    public String getFimAfastamento() {
        return fimAfastamento;
    }

    public boolean isSuprido() {
        return suprido;
    }

    public String getMotivo() {
        return motivo;
    }

    public Professor getAfastado() {
        return afastado;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplina;
    }
}
