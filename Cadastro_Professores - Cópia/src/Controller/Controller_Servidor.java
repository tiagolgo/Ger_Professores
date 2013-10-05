/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Entidades.Dao_Afastamento;
import Dao.Dao_Entidades.Dao_Cancelamento;
import Dao.Dao_Entidades.Dao_Professor;
import Dao.Dao_Entidades.Dao_Substituicao;
import Dao.Dao_Entidades.Dao_Suprimento;
import Entidades.Professora;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Controller_Servidor {

    private Session sessão;
    StringBuilder notificacoes = new StringBuilder();
    private Dao_Professor dp;

    public Controller_Servidor() {
        dp = new Dao_Professor();
    }

    public StringBuilder cadastrarServidor(Professora s, Session session) {
        //instanciar o dao para persistir
        if (verificaDuplicidade(s).length()==0) {
            try {
                dp.persist(s);
                return null;
            } catch (Exception ex) {
                Logger.getLogger(Controller_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.notificacoes;
    }

    public StringBuilder removerServidor(Professora s, Session session) {
        boolean excluir = true;
        this.notificacoes.append("O Professor não pode ser excluído:");
        if (verificaSeAtivo(s)) {
            excluir = false;
            this.notificacoes.append("O Professor ainda está ativo.\n");
        }
        if (new Dao_Suprimento().isSuprido(s.getId(), sessão)) {
            excluir = false;
            this.notificacoes.append("O Professor ainda está Suprido.\n");
        }
        if (new Dao_Cancelamento().isCancelado(s.getId(), sessão)) {
            excluir = false;
            this.notificacoes.append("O Professor possui registro de Cancelamento.");
        }
        if (new Dao_Substituicao().isSubstituido(s.getId(), sessão)) {
            excluir = false;
            this.notificacoes.append("O Professor possui registro de Substituição.\n");
        }
        if (new Dao_Afastamento().isAfastado(s.getId(), sessão)) {
            this.notificacoes.append("O Professor possui registro de Afastamento.\n");
        }
        if (excluir) {
            return this.notificacoes;
        }
        return null;
    }

    public StringBuilder alterarServidor(Professora s) {
        if (verificaDuplicidade(s).length()==0) {
            try {
                dp.persist(s);
                return null;
            } catch (Exception ex) {
                Logger.getLogger(Controller_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.notificacoes;
    }

    public StringBuilder verificaDuplicidade(Professora s) {
        Dao_Professor dao = new Dao_Professor();
        if (dao.isExiste(s.getRg(), s.getCpf())) {
            this.notificacoes.append("Já existe um Professor cadastrado com esses RG ou CPF.");
        }
        return this.notificacoes;
    }

    public boolean verificaSeAtivo(Professora s) {
        if (s.isAtivo()) {
            this.notificacoes.append("Servidor está ativo e não pode ser removido. Para remover é necessário realizar o Cancelamento.\n");
            return false;
        }
        return true;
    }
}
