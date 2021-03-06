/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Disciplinas;
import Entidades.Professora;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Disciplina extends Dao_Generico<Disciplinas> {

    public Dao_Disciplina() {
        clazz = Disciplinas.class;
    }

    public List<Disciplinas> getModelos() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Disciplinas> res = (List<Disciplinas>) sessao.createQuery("FROM Disciplinas where modelo=true").list();
        sessao.beginTransaction().commit();
//        sessao.close();
        return res;
    }

    public List<Disciplinas> getNaoSupridas() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Disciplinas> res = (List<Disciplinas>) sessao.createQuery("FROM Disciplinas WHERE suprida=false and id_Turma<>''").list();
        sessao.beginTransaction().commit();
//        sessao.close();
        return res;
    }

    public boolean verDuplicidade(Disciplinas d) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Disciplinas> res = (List<Disciplinas>) sessao.createQuery("FROM Disciplinas WHERE codigo=:c or nome=:n and modelo=true").setParameter("c", d.getCodigo()).setParameter("n", d.getNome()).list();
        sessao.beginTransaction().commit();
        if (res.isEmpty()) {
            return true;
        }
        return false;
    }

    public List getPorIdTurma(int id) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List res = sessao.createQuery("FROM Disciplinas WHERE id_Turma=:i").setParameter("i", id).list();
        return res;
    }

    public boolean getDisciplinaTurmaId(Disciplinas d) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Disciplinas> res = (List<Disciplinas>) sessao.createQuery("FROM Disciplinas WHERE codigo=:c and nome=:n and id_Turma=:i").setParameter("c", d.getCodigo()).setParameter("n", d.getNome()).setParameter("i", d.getTurma().getId()).list();
        sessao.beginTransaction().commit();
        if (res.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean deletePorCodigo(String id) throws Exception{
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        int res = sessao.createSQLQuery("DELETE FROM Disciplinas WHERE codigo=:i").setParameter("i", id).executeUpdate();
        sessao.beginTransaction().commit();
        if (res > 0) {
            return true;
        }
        return false;
    }

    public boolean deletePorIdTurma(int id) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        int res = sessao.createQuery("DELETE FROM Disciplinas WHERE id_Turma=:i").setParameter("i", id).executeUpdate();
        sessao.beginTransaction().commit();
        if (res > 0) {
            return true;
        }
        return false;
    }

    public boolean removerIdTurma(int id, Session sessao) {
//        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        int res = sessao.createQuery("update Disciplinas set id_Turma=null where id_Turma=:i").setParameter("i", id).executeUpdate();
//        sessao.beginTransaction().commit();
        if (res > 0) {
            return true;
        }
        return false;

    }

    public Disciplinas getPorCodigo(String codigo, Session sessao) {
        Disciplinas d = (Disciplinas) sessao.createQuery("FROM Disciplinas WHERE codigo=:c").setParameter("c", codigo).uniqueResult();
        return d;
    }
    public Disciplinas getPorId(int id, Session sessao) {
        Disciplinas d = (Disciplinas) sessao.createQuery("FROM Disciplinas WHERE id=:c").setParameter("c", id).uniqueResult();
        return d;
    }

    public List<Disciplinas> getNaoSupridasTurma(int id, Session sessao) {
        List<Disciplinas> list = sessao.createQuery("FROM Disciplinas WHERE suprida=false and id_Turma=:i").setParameter("i", id).list();
        return list;
    }

    public boolean getSupridasAfastamento(int id, Session sessao) {
        List<Disciplinas> list = sessao.createQuery("FROM Disciplinas WHERE suprida=false and id_Afastameto=:i").setParameter("i", id).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean exclusaoDisciplina(String codigo) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List ret = sessao.createSQLQuery("select*from Disciplinas where codigo=:i and suprida=true and id_Supim is not null").setParameter("i", codigo).list();
        System.out.println("tamanho da lista "+ret.size());
        if (ret.size() > 0) {
            return false;
        }
        return true;
    }
}
