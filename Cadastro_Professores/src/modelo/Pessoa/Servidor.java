package modelo.Pessoa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "S")
public class Servidor extends Pessoa {
  
    @Column(length = 2)
    private int LF;
    private boolean ativo;
    private String cargo;
    @Column(length=2)
    private int cargaHorária;

    public Servidor() {
    }

    public int getLF() {
        return LF;
    }

    public void setLF(int LF) {
        this.LF = LF;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargaHorária() {
        return cargaHorária;
    }

    public void setCargaHorária(int cargaHorária) {
        this.cargaHorária = cargaHorária;
    }
            
    @Override
    public String toString() {
        return "LF=" + LF +  ", ativo=" + ativo;
    }   
}
