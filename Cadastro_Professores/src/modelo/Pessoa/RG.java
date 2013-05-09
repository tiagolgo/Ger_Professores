/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Pessoa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrador
 */
@Entity
public class RG implements Serializable {

    @Id
    @GeneratedValue
    private int id;
//    @Column(length = 9)
    private Long número;
//    @Column(length = 8)
    private String emissão;
    private String estado;

    public RG() {
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNúmero(Long número) {
        this.número = número;
    }

    public void setEmissão(String emissão) {
        this.emissão = emissão;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public Long getNúmero() {
        return número;
    }

    public String getEmissão() {
        return emissão;
    }

    public String getEstado() {
        return estado;
    }
    

    @Override
    public String toString() {
        return "RG{" + "id=" + id + ", n\u00famero=" + número + ", estado=" + estado + '}';
    }
}
