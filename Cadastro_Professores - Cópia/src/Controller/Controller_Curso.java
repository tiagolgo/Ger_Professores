/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Entidades.Dao_Curso;
import Entidades.Cursos;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Controller_Curso {

    public List<Cursos> retornaCursos() {
        Dao_Curso dc = new Dao_Curso();
        return dc.list();
    }

    public void excluirCurso(Cursos c, Session sessao) throws Exception {
        Dao_Curso dc = new Dao_Curso();
        dc.delete(c, sessao);
    }

   
    public StringBuilder verificaCampos(Cursos c) {
        String codigo = c.getCodigo();
        System.out.println("codigo "+codigo);
        String nome = c.getNome();
        System.out.println("nome "+nome);
        String turno = c.getTurno();
        System.out.println("turno "+turno);
        StringBuilder not = new StringBuilder();

        if (codigo.equals("") || codigo.equals(" ")) {
            not.append("Informe o Código do Curso!\n");
        }
        if (nome.equals("") || nome.equals(" ")) {
            not.append("Informe o Nome do Curso!\n");
        }
        if (turno.equals("")||turno.equals(" ")) {
            not.append("Selecione o Turno\n");
        }
        return not;
    }
    
    public void excluirCurso(Cursos c){
        
    }
}
