/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Cursos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

/**
 *
 * @author Tiago
 */
public class Dao_Curso extends Dao_Generico<Cursos> {

    public Dao_Curso() {
        clazz = Cursos.class;
    }

    public boolean retrievePorNome(String nome, String codigo, String turno) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List res = sessao.createQuery("FROM Cursos WHERE (codigo=:c and turno=:t) or (nome=:n and turno=:t)").setParameter("c", codigo).setParameter("n", nome).setParameter("t", turno).list();
        if (res.isEmpty()) {
            return false;
        }
        return true;
    }

    public Object[] getNomeCursos() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List ret = sessao.createQuery("SELECT c.codigo, c.nome FROM Cursos c").list();
        
        return ret.toArray();
    }
}
