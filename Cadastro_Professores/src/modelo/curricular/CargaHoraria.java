/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.curricular;


public class CargaHoraria {

    int id;
    private int cargaHorária;


    public CargaHoraria() {
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCargaHorária(int cargaHorária) {
        this.cargaHorária = cargaHorária;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getCargaHorária() {
        return cargaHorária;
    }
    

    @Override
    public String toString() {
        return "" + cargaHorária;
    }
}
