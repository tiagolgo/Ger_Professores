/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.curricular;

/**
 *
 * @author Tiago
 */
public enum Comp_Curricular {

    BNC, PD;

    @Override
    public String toString() {
        switch (this) {
            case BNC:
                return "Base Nacional Comum";
            case PD:
                return "Parte Diversificada";
            default:
                return null;
        }
    }
}
