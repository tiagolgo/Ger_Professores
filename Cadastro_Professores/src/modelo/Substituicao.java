package modelo;

import modelo.Pessoa.Professor;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import modelo.curricular.Disciplina;
import org.hibernate.annotations.Entity;

@Entity
public class Substituicao {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 8)
    private String data;
    @Column(length = 8)
    private String dataInicio;
    @Column(length = 30)
    private String motivo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Substituicao")
    private Afastamento afastamento;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Substituicao")
    private Professor substituto;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Substituicao")
    private List<Disciplina> disciplinas;
    
    public Substituicao() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDataSubstituicao(String dataSubstituicao) {
        this.dataInicio = dataSubstituicao;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setAfastamento(Afastamento afastamento) {
        this.afastamento = afastamento;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplinas = disciplina;
    }

    public void setSubstituto(Professor substituto) {
        this.substituto = substituto;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getDataSubstituicao() {
        return dataInicio;
    }

    public String getMotivo() {
        return motivo;
    }

    public Afastamento getAfastamento() {
        return afastamento;
    }

    public List<Disciplina> getDisciplina() {
        return disciplinas;
    }

    public Professor getSubstituto() {
        return substituto;
    }   
}
