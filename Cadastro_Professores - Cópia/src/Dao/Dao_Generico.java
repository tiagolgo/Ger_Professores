/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.Hibernate_Sessao;
import Entidades.Cancel;
//import Conexao.JPA_FabricaSessao;
//import Conexao.Sessão;
//import java.sql.Connection;
import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Dao_Generico<T> implements Dao<T> {

    protected static Class clazz;

    @Override
    public void persist(T o) throws Exception {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        Transaction tr = sessao.beginTransaction();
        sessao.saveOrUpdate(o);
        tr.commit();
        sessao.close();
    }

    @Override
    public void persist(T o, Session sessao) throws Exception {
        sessao.saveOrUpdate(o);
//        sessao.beginTransaction().commit();
    }

    @Override
    public void delete(T o) throws Exception {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        sessao.delete(o);
        sessao.beginTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(T o, Session sessao) throws Exception {
        sessao.delete(o);
//        sessao.beginTransaction().commit();
    }
    

    @Override
    public T retrieve(int id) throws Exception {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        T res = (T) sessao.createCriteria(clazz).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.beginTransaction().commit();
        sessao.close();
        return res;
    }

    @Override
    public List<T> list() {
        List<T> res;
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        res = (List<T>) sessao.createCriteria(clazz).list();
        sessao.beginTransaction().commit();
        sessao.close();
        return res;
    }
    public List<T> list(Session sessao) {
        List<T> res;
        res = (List<T>) sessao.createCriteria(clazz).list();
//        sessao.beginTransaction().commit();
//        sessao.close();
        return res;
    }
}
