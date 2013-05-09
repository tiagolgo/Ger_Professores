/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import modelo.Pessoa.Professor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Professor extends Dao_Basic {

    public Dao_Professor(Session sessão) {
        super(sessão);
    }

    public Professor consultaNome(String nome) {
//        Transaction transacao = this.sessão.beginTransaction();
        return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.eq("nome", nome)).uniqueResult();
    }

    public Professor consultaTrechoNome(String nome) {
        return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.like("nome", "%"+nome+"%")).uniqueResult();
    }

    public Professor consultaRG(Long rg) {
        return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.eq("rg", rg)).uniqueResult();

    }

    public Professor consultaCPF(Long cpf) {
        return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.eq("cpf", cpf)).uniqueResult();

    }

    public Professor consultaNascimento(String nascimento) {
        return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.eq("data_Nascimento", nascimento)).list();
    }

    public boolean deletaNome(String nome) {
        Query cq = this.session.createQuery("delete from Professor where nome=:nome").setString("nome", nome);
        int eu = cq.executeUpdate();
        if (eu == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deletaRg(Long rg) {
        Query cq = this.session.createQuery("delete from Professor where id=(select id from Rg where id_professor=?)").setLong("rg", rg);
        int eu = cq.executeUpdate();
        if (eu == 0) {
            return false;
        } else {
            return true;
        }
    }
}
