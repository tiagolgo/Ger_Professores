/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

//import Tarefa.Estoque;
import Sessão.Sessão;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
class Dao_Basic {

    public Session session;

    public Dao_Basic(Session sessão) {
        this.session = sessão;
    }

    public Transaction retornaTransaction() {
        Transaction tx = this.session.beginTransaction();
        return tx;
    }

    //salva ou atualiza objeto
    public void persiste(Object obj) throws Exception {
        this.session.saveOrUpdate(obj);
        retornaTransaction().commit();
    }

    //deleta um objeto
    public void deleta(Object obj) {
        this.session.delete(obj);
        retornaTransaction().commit();
    }

    //retorna lista de objetos
    public List retornaObjetos(Object obj) {
        List list = session.createCriteria(obj.getClass()).list();
        return list;
    }

    //retorna um objeto pelo ID
    public Object retornaObjetoId(Object obj, Integer id) {
        Object estoque = session.get(obj.getClass(), id);
        return estoque;
    }

    public void fechaSessão() {
        this.session.close();
    }
}
