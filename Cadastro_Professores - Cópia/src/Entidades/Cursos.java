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
import javax.persistence.OneToMany;

/**
 *
 * @author Tiago
 */
@Entity
public class Cursos implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private String codigo, nome, turno;
//    @OneToMany
//    private List<Turmas> turmas = new ArrayList();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

//    public List<Turmas> getTurmas() {
//        return turmas;
//    }
//
//    public void setTurmas(List<Turmas> turmas) {
//        this.turmas = turmas;
//    }
//    public void setTurma(Turmas turma) {
//        this.turmas.add(turma);
//    }
}
