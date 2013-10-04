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
public class Escola implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private String codigo, nome, login, senha;
    @OneToOne
    private Endereco endereco;
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Escola")
    private List<Cancel> cancelamentos = new ArrayList();
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Escola")
    private List<Suprim> suprimentos = new ArrayList();
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Escola")
    private List<Afastament> afastamentos = new ArrayList();
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_Escola")
    private List<Substituica> substituicoes = new ArrayList();

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Cancel> getCancelamentos() {
        return cancelamentos;
    }

    public void setCancelamentos(List<Cancel> cancelamentos) {
        this.cancelamentos = cancelamentos;
    }

    public List<Suprim> getSuprimentos() {
        return suprimentos;
    }

    public void setSuprimentos(List<Suprim> suprimentos) {
        this.suprimentos = suprimentos;
    }

    public List<Afastament> getAfastamentos() {
        return afastamentos;
    }

    public void setAfastamentos(List<Afastament> afastamentos) {
        this.afastamentos = afastamentos;
    }

    public List<Substituica> getSubstituicoes() {
        return substituicoes;
    }

    public void setSubstituicoes(List<Substituica> substituicoes) {
        this.substituicoes = substituicoes;
    }
}
