/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Entidades.Dao_Afastamento;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Professor;
import Dao.Dao_Entidades.Dao_Substituicao;
import Entidades.Afastament;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Substituica;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class Controller_Afastamento {

    private ArrayList<String> notificacao = new ArrayList();


    public Professora reatribuirDisciplinas(Afastament a) {
        List<Disciplinas> disciplinas = a.getDisciplinas();
        Professora afastado = a.getAfastado();

        for (Disciplinas disciplina : disciplinas) {
            disciplina.setSuprida(true);
            afastado.setDisciplina(disciplina);
        }

        return afastado;

        //chama método
    }

    private boolean persistirAfastado(Professora afastado, Session sessao) {
        Dao_Professor dp = new Dao_Professor();
        try {
            Transaction tr = sessao.beginTransaction();
            dp.persist(afastado, sessao);
            tr.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller_Afastamento.class.getName()).log(Level.SEVERE, null, ex);
            this.notificacao.add("Não foi possível realizar o remoção do Afastamento!");
            return false;
        }
    }

    private boolean verificaSeSubstituido(Afastament a, Session sessao) {
        Dao_Disciplina ds = new Dao_Disciplina();
        boolean s = ds.getSupridasAfastamento(a.getId(), sessao);
        if (s) {
            this.notificacao.add("O Afastamento não pode ser excluído.\n Há uma Substituição do mesmo.\n Realize o Cancelamento");
            return false;
        }
        return true;
    }
}
