/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author Tiago
 */
public class Nc {
    private int i;
    
    public Nc(int i){
        verifica(i);
        this.i=i;
    }
    
    boolean verifica(int i){
        if(i!=3){
        return false;
        }
        return true;
    }
}
