/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import Sessão.Sessão;
import modelo.Cancelamento;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Cancelamento extends Dao_Basic {


    public Dao_Cancelamento(Session sessao) {
        super(sessao);
    }

    public Cancelamento retornaPorData(String data) {
        return (Cancelamento) this.session.createCriteria(Cancelamento.class).add(Restrictions.eq("data_Cancelamento", data));
    }
}
