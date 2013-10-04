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
public class Professora implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private int cargaHoraria;
    private boolean ativo;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Contato contato;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Endereco endereco;
    private String nome, nascimento, cargo, sexo, estadoNasc, munNasc, rg, ufRg, emissaoRg, cpf, lf, funcao, vinculo;
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_Professor")
    private List<Disciplinas> disciplinas = new ArrayList();

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoNasc() {
        return estadoNasc;
    }

    public void setEstadoNasc(String estadoNasc) {
        this.estadoNasc = estadoNasc;
    }

    public String getMunNasc() {
        return munNasc;
    }

    public void setMunNasc(String munNasc) {
        this.munNasc = munNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUfRg() {
        return ufRg;
    }

    public void setUfRg(String ufRg) {
        this.ufRg = ufRg;
    }

    public String getEmissaoRg() {
        return emissaoRg;
    }

    public void setEmissaoRg(String emissaoRg) {
        this.emissaoRg = emissaoRg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCargaHoraria() {
        for (Disciplinas d : disciplinas) {
            this.cargaHoraria += d.getCargaHoraria();
        }
        return cargaHoraria;
    }
}
