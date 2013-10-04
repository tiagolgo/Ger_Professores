/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Cancel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Cancelamento extends Dao_Generico<Cancel> {

    public Dao_Cancelamento() {
        clazz = Cancel.class;
    }

    public List<Cancel> todosPorData(String data) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Cancel> res = (List<Cancel>) sessao.createCriteria(Cancel.class).add(Restrictions.eq("data", data)).list();
        sessao.beginTransaction().commit();
        return res;
    }

    public List<Cancel> lista() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List list = sessao.createQuery("From Cancel").list();
//         if (list.isEmpty()) {
//             return null;
//         }
        return list;
    }

    public boolean isCancelado(int id, Session sessao) {
        try {
            int res = sessao.createQuery("FROM Cancel WHERE professor_Id=:i").setParameter("i", id).executeUpdate();
//            sessao.beginTransaction().commit();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
