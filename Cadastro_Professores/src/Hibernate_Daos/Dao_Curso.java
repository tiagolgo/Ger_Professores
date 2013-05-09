/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import java.util.List;
import modelo.curricular.Curso;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Curso extends Dao_Basic {

    public Dao_Curso(Session sessão) {
        super(sessão);
    }

    public List retorna_CursoNome(String nome) {
        return this.session.createCriteria(Curso.class).add(Restrictions.eq("nome", nome)).list();
    }

    public List retorna_CursoCodigo(int codigo) {
        return this.session.createCriteria(Curso.class).add(Restrictions.eq("codigo", codigo)).list();
    }
}
