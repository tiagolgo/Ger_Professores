package modelo.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1,discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value ="P" )
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(length=50)
    private String nome;
    private String sexo;
    
    private String data_Nascimento;
    
    @OneToOne
    private Municipio municipio;//local nascimento
    
    @OneToOne(cascade = CascadeType.ALL)
//    @Column(length = 9)
    private RG rg;
    
    @Column(length = 11)
    private Long cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="id_pessoa")
    private List<Telefone> telefone;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="id_pessoa")
    private List<Email> email;
    
    @OneToMany
    @JoinColumn(name="id_pessoa")
    private List<Dependente> dependente;

    public Pessoa() {
        this.dependente=new ArrayList();
        this.email=new ArrayList();
        this.telefone=new ArrayList();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setData_Nascimento(String data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setRg(RG rg) {
        this.rg = rg;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone.add(telefone);
    }
    
    public void setTelefone(List<Telefone> telefone) {
        this.telefone=telefone;
    }

    public void setEmail(Email email) {
        this.email.add(email);
    }
   
    public void setEmail(List<Email> email) {
        this.email=email;
    }

    public void setDependente(Dependente dependente) {
        this.dependente.add(dependente);
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getData_Nascimento() {
        return data_Nascimento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public RG getRg() {
        return rg;
    }

    public Long getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public List<Email> getEmail() {
        return email;
    }

    public List<Dependente> getDependente() {
        return dependente;
    }
    
 
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", nascimento=" + data_Nascimento + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", dependente=" + dependente + ", rg=" + rg + '}';
    }
}
