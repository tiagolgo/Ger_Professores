/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import java.util.List;
import modelo.curricular.MatrizCurricular;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Matriz extends Dao_Basic {

    public Dao_Matriz(Session sessão) {
        super(sessão);
    }

        public List getMatriz_Serie(int serie) {
        return this.session.createCriteria(MatrizCurricular.class).add(Restrictions.eq("serie", serie)).list();
    }

    public List getMatriz_Turno(String turno) {
        return this.session.createCriteria(MatrizCurricular.class).add(Restrictions.eq("turno", turno)).list();
    }
        
    public List getMatriz_Curso() {
        return null;
    }
}
