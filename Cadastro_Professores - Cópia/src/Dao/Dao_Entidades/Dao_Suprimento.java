/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Suprim;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Dao_Suprimento extends Dao_Generico<Suprim> {

    public Dao_Suprimento() {
        clazz = Suprim.class;
    }
    
    public boolean isSuprido(int id, Session sessao) {
        try {
            int res = sessao.createQuery("FROM Supriment WHERE professor_Id=:i").setParameter("i", id).executeUpdate();
//            sessao.beginTransaction().commit();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            return false;
        }
    }
}
