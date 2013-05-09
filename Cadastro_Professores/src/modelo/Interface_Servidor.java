/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Pessoa.Professor;
import java.util.ArrayList;

/**
 *
 * @author Meus Documentos
 */
public interface Interface_Servidor {
    public void inserir(Professor professor);
    public Professor consultar(String rg);
    public ArrayList consultaTodos();
    public void alterar(Professor prof, String rg);
    public boolean excluir(Professor prof);
    
}
