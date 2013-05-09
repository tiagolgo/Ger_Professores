/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import modelo.Pessoa.Servidor;
import modelo.Pessoa.Telefone;
import modelo.Pessoa.Email;
import modelo.Pessoa.Endereco;
import javax.persistence.OneToOne;

@Entity
public class Estabelecimento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 5)
    private int código;
    @Column(length = 25)
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private Telefone telefone;
    @OneToOne(cascade = CascadeType.ALL)
    private Email email;
    @OneToOne(cascade = CascadeType.ALL)
    private Servidor diretor;
    @OneToOne(cascade = CascadeType.ALL)
    private Mun_Estabelecimento municipio;

    public Estabelecimento() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setDiretor(Servidor diretor) {
        this.diretor = diretor;
    }

    public void setMunicipio(Mun_Estabelecimento municipio) {
        this.municipio = municipio;
    }

    
    //Getters
    public int getId() {
        return id;
    }

    public int getCódigo() {
        return código;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Email getEmail() {
        return email;
    }

    public Servidor getDiretor() {
        return diretor;
    }

    public Mun_Estabelecimento getMunicipio() {
        return municipio;
    }
    
}
