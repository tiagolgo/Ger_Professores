/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import java.util.List;
import modelo.Afastamento;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Afastamento extends Dao_Basic {


    public Dao_Afastamento(Session s) {
        super(s);
    }

    public List consultaPelaData(String data) {
        return this.session.createCriteria(Afastamento.class).add(Restrictions.eq("dataAfastamento", data)).list();
    }

    public List consultaPeloInicio(String data) {
        return this.session.createCriteria(Afastamento.class).add(Restrictions.eq("inicioAfastamento", data)).list();
    }

    public List consultapPeloFim(String data) {
        return this.session.createCriteria(Afastamento.class).add(Restrictions.eq("fimAfastamento", data)).list();
    }
    
    public List afastamentoNãoSuprido(){
        return this.session.createCriteria(Afastamento.class).add(Restrictions.eq("suprido", false)).list();
    }
}
