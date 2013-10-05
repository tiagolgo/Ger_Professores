/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Disciplina;
import Entidades.Disciplinas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Disciplina.Cadastrar_Disciplina;

/**
 *
 * @author Tiago
 */
public class Controller_Disciplina {

    public StringBuilder verificaSeSuprida(List<Disciplinas> disciplinas) {
        StringBuilder not = new StringBuilder();
        for (Disciplinas disc : disciplinas) {
            if (disc.isSuprida()) {
                not.append("A(s) Disciplina(s) em questão já estão supridas, favor realizar o Cancelamento das mesmas.");
                return not;
            }
        }
        return null;
    }

    public StringBuilder persistirDisciplinas(Disciplinas d) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        Dao_Disciplina dd = new Dao_Disciplina();
        StringBuilder not = new StringBuilder();

        if (dd.verDuplicidade(d)) {
            try {
                Transaction tr = sessao.beginTransaction();
                dd.persist(d);
                tr.commit();
            } catch (Exception ex) {
                sessao.beginTransaction().rollback();
                Logger.getLogger(Cadastrar_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (not.length() == 0) {
                not.append("As Seguintes Disciplinas não foram Gravadas:\n");
            }
            not.append(d.getCodigo()).append(" - ").append(d.getNome()).append(" - ").append(d.getCompCurric()).append("\n");
        }

        return not;
    }

   
}
