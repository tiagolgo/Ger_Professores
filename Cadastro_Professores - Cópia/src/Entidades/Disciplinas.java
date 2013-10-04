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
public class Disciplinas implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private String codigo, nome, compCurric;
    private int cargaHoraria;
    private boolean suprida, modelo;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Turma")
    private Turmas turma;

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

    public String getCompCurric() {
        return compCurric;
    }

    public void setCompCurric(String compCurric) {
        this.compCurric = compCurric;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isSuprida() {
        return suprida;
    }

    public void setSuprida(boolean suprida) {
        this.suprida = suprida;
    }

    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }

    public boolean isModelo() {
        return modelo;
    }

    public void setModelo(boolean modelo) {
        this.modelo = modelo;
    }
}
