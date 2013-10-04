/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Afastament;
import Entidades.Substituica;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Substituicao extends Dao_Generico<Substituica> {

    public Dao_Substituicao() {
        clazz = Substituica.class;
    }

    public Substituica getSubstituicaoEqualsId(int param) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        Substituica res = (Substituica) sessao.createQuery("FROM Substituica where afastado_id = :param").setParameter("param", param).uniqueResult();
        sessao.beginTransaction().commit();
        return res;
    }
    public boolean isSubstituido(int id, Session sessao) {
        try {
            int res = sessao.createQuery("FROM Substituica WHERE afastado_Id=(SELECT Id FROM Afastament WHERE afastado_Id=:i)").setParameter("i", id).executeUpdate();
//            sessao.beginTransaction().commit();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
//            sessao.close();
            return false;
        }
    }
}
