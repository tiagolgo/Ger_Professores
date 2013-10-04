/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import Hibernate_Daos.Dao_Suprimento;
import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Turmas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Disciplina.Cadastrar_Disciplina;
import visão.Suprimento.Nova_Distribuição;

/**
 *
 * @author Tiago
 */
public class Controller_Turma {

    private ArrayList<String> notificações = new ArrayList();
    private Session sessão;

    public void cadastrarAtualizar(Turmas t, Session s) {
        this.sessão = s;
    }

    private boolean verificaDuplicidade(Turmas t) {

        Turmas retorno = null;

        if (retorno.getCurso().getNome().equals(t.getCurso().getNome())
                & retorno.getSerie() == t.getSerie()
                & retorno.getSeriacao().equals(t.getSeriacao())
                & retorno.getCurso().getTurno().equals(t.getCurso().getTurno())) {
            this.notificações.add("A Turma em questão já está cadastrada!");
            return false;
        }
        return true;
    }

    public boolean verificaSeSupridosNaTurma(int t) {
        //aqui verificar se existe professores supridos na turma a ser excluída
        //se existir informar que todos os supridos devem ser cancelados antes da exclusão da turma
        Dao_Disciplina dd = new Dao_Disciplina();
        List<Disciplinas> disciplinas = dd.getPorIdTurma(t);

        for (Disciplinas d : disciplinas) {
            if (d.isSuprida()) {
                return true;
            }
        }
        return false;
    }

    private void persistir(Professora s, int op) {
//        Dao_Suprimento ds = new Dao_Suprimento(this.sessão);
        try {
            Transaction tran = this.sessão.beginTransaction();
            if (op == 0) {
//                ds.deleta(s);
            } else if (op == 1) {
//                ds.persiste(s);
            }
            tran.commit();
        } catch (Exception ex) {
            this.sessão.beginTransaction().rollback();
            Logger.getLogger(Nova_Distribuição.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }
}
