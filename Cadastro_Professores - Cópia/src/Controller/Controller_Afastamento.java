/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Entidades.Dao_Afastamento;
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

/**
 *
 * @author Tiago
 */
public class Controller_Afastamento {

    private ArrayList<String> notificacao = new ArrayList();

    public ArrayList<String> delete(Afastament a, Session sessao) {
        //chama método para reatribuir as disciplinas do afastado

        //chamar método para excluir 

        if (verificaSeSubstituido(a)) {
            return null;
        } else {
            Professora professor = reatribuirDisciplinas(a);
            persistirAfastado(professor, sessao);
            return this.notificacao;
        }
    }

    private Professora reatribuirDisciplinas(Afastament a) {
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
            dp.persist(afastado, sessao);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller_Afastamento.class.getName()).log(Level.SEVERE, null, ex);
            this.notificacao.add("Não foi possível realizar o remoção do Afastamento!");
            return false;
        }
    }

    private boolean verificaSeSubstituido(Afastament a) {
        Dao_Substituicao ds = new Dao_Substituicao();
        Substituica s = ds.getSubstituicaoEqualsId(a.getId());
        if (s != null) {
            this.notificacao.add("O Afastamento não pode ser excluído.\n Há uma Substituição do mesmo.\n Realize o Cancelamento");
            return false;
        }
        return true;
    }
}
