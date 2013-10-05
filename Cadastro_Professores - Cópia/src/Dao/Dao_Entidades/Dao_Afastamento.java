/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Afastament;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Afastamento extends Dao_Generico<Afastament> {

    public Dao_Afastamento() {
        clazz = Afastament.class;
    }

    public List<Afastament> todosPorData(String data) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Afastament> res = (List<Afastament>) sessao.createCriteria(clazz.getSimpleName()).add(Restrictions.eq("data", data)).list();
        sessao.beginTransaction().commit();
        return res;
    }

    public List<Afastament> todosDataInicio(String data) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Afastament> res = (List<Afastament>) sessao.createCriteria(clazz.getSimpleName()).add(Restrictions.eq("dataInicio", data)).list();
        sessao.beginTransaction().commit();
        return res;
    }

    public List<Afastament> todosDatafFim(String data) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Afastament> res = (List<Afastament>) sessao.createCriteria(clazz.getSimpleName()).add(Restrictions.eq("dataFim", data)).list();
        sessao.beginTransaction().commit();
        return res;
    }

//    public List<Afastament> getAfastados(String id) {
//        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
//        List<Afastament> res = (List<Afastament>) sessao.createQuery("SELECT FROM ");
//        sessao.beginTransaction().commit();
//        return res;
//    }
    public boolean isAfastado(int id, Session sessao) {
        try {
            int res = sessao.createQuery("FROM Afastament WHERE afastado_Id=:i").setParameter("i", id).executeUpdate();
//            sessao.beginTransaction().commit();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            return false;
        }
    }

    public boolean getAfastaments(Session sessao, int id) {
        try {
            List<Afastament> list = sessao.createQuery("from Disciplinas where id_Afastameto=:i and suprida=true").setParameter("i", id).list();
//            sessao.beginTransaction().commit();
            if (list.size()>0) {
                return false;
            }

        } catch (Exception e) {
        }
        return false;

    }
}
