/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.DiscriminatorValue;

import modelo.Pessoa.Municipio;


@DiscriminatorValue("ME")
public class Mun_Estabelecimento extends Municipio {

    private int código;

    public Mun_Estabelecimento(int código) {
        this.código = código;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }
}
