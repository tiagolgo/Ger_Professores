package modelo.Pessoa;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String rua;
    @Column(length = 5)
    private int numero;
    private String bairro;
    @Column(length = 9)
    private String cep;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public Endereco() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", municipio=" + municipio + '}';
    }
}
