/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import java.util.List;
import modelo.curricular.Disciplina;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Disciplina extends Dao_Basic {

    public Dao_Disciplina(Session sessao) {
        super(sessao);
    }

    public List get_DisciplinaNome(String nome) {
        return this.session.createCriteria(Disciplina.class).add(Restrictions.eq("nome", nome)).list();

    }
    
    public List get_DisciplinaTrechoNome(String nome) {
        return this.session.createCriteria(Disciplina.class).add(Restrictions.like("nome", "%"+nome+"%")).list();

    }

    public List get_DisciplinaCodigo(int codigo) {
        return this.session.createCriteria(Disciplina.class).add(Restrictions.eq("codigo", codigo)).list();

    }

    public List get_DisciplinaAtribuida(Boolean cond) {
        return this.session.createCriteria(Disciplina.class).add(Restrictions.eq("atribuida", cond)).list();
    }
}
