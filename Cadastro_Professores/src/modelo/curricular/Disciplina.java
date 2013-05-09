package modelo.curricular;

import java.io.Serializable;
import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue
    private int id;
//    @Column(length = 5)
    private int codigo;
//    @Column(length = 10)
    private String nome;
//    @Column(length = 2)
    private int CargaHorária;
    private boolean atribuida;
    private Comp_Curricular compCurricular;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Disciplina")
    private Turma turma;

    public Disciplina() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHorária(int ch) {
        this.CargaHorária = ch;
    }

    public void setAtribuida(boolean atribuida) {
        this.atribuida = atribuida;
    }
   
    public void setCompCurricular(Comp_Curricular compCurricular) {
        this.compCurricular = compCurricular;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCargaHorária() {
        return CargaHorária;
    }

    public boolean isAtribuida() {
        return atribuida;
    }
    
    public Comp_Curricular getCompCurricular() {
        return compCurricular;
    }

    public Turma getTurma() {
        return turma;
    }
    
    
    @Override
    public String toString() {
        return "Disciplina:" + codigo + "-" + nome + ", CargaHor\u00e1ria=" + CargaHorária + ", compCurricular=" + compCurricular;
    }
}
