/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Professora;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Professor extends Dao_Generico<Professora> {

    public Dao_Professor() {
        clazz = Professora.class;
    }

    public Professora getUnicoNome(String nome) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("nome", nome)).uniqueResult();
        sessao.beginTransaction().commit();
        return res;
    }

    public Professora unicoPorNome(String nome, Session sessao) {
        //        Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("nome", nome)).uniqueResult();
        try {
            Professora res = (Professora) sessao.createQuery("FROM Professora where nome=:n").setParameter("n", nome).uniqueResult();
            return res;
        } catch (Exception ex) {
            System.out.println("erro "+ex);
            return null;
        }
    }

    public List<Professora> trechoDeNome(String nome) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            List<Professora> res = (List<Professora>) sessao.createCriteria(Professora.class).add(Restrictions.like("nome", "%" + nome + "%")).list();
            sessao.beginTransaction().commit();
            return res;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Professora> retornaPorNascimento(String nascimento) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            List<Professora> res = (List<Professora>) sessao.createCriteria(Professora.class).add(Restrictions.eq("nascimento", nascimento)).list();
            return res;
        } catch (Exception e) {
            return null;
        }
        //        sessao.beginTransaction().commit();
    }

    public Professora retornaPorRG(String rg) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("rg", rg)).uniqueResult();
            sessao.beginTransaction().commit();
            return res;
        } catch (Exception e) {
            return null;
        }finally{
            sessao.close();
        }
    }

    public Professora retornaPorRG(String rg, Session sessao) {
        try {
            Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("rg", rg)).uniqueResult();
            return res;
        } catch (Exception e) {
            return null;
        }
//        sessao.beginTransaction().commit();
    }

    public Professora retornaPorCPF(String cpf) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("cpf", cpf)).uniqueResult();
            sessao.beginTransaction().commit();
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    public Professora retornaPorCPF(String cpf, Session sessao) {
        try {
            Professora res = (Professora) sessao.createCriteria(Professora.class).add(Restrictions.eq("cpf", cpf)).uniqueResult();
//        sessao.beginTransaction().commit();
            return res;

        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getNomes() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            List<String> list = sessao.createQuery("SELECT p.nome FROM Professora p").list();
            sessao.beginTransaction().commit();
            return list;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean isExiste(String rg, String cpf) {

        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            List<Professora> ret = sessao.createQuery("FROM Professora WHERE rg=:r").setParameter("r", rg).setParameter("c", cpf).list();
            sessao.beginTransaction().commit();
            if (ret.size() > 0) {
                return false;
            }
        } catch (Exception e) {
            sessao.close();
        }
        return true;
    }
    public boolean isExiste(String rg) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            List<Professora> ret = sessao.createQuery("FROM Professora WHERE rg=:r").setParameter("r", rg).list();
            sessao.beginTransaction().commit();
            if (ret.size() > 0) {
                return false;
            }
        } catch (Exception e) {
            sessao.close();
        }
        return true;
    }

    public int getCargaHoraria(int id) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        try {
            int ret = sessao.createQuery("select SUM(cargaHoraria) from Disciplinas where suprida=true and id in (select id from Disciplinas where id_Supim in (select id from Suprim where professor_Id=:i))").setParameter("i", id).executeUpdate();
            sessao.beginTransaction().commit();
            return ret;
        } catch (Exception e) {
            sessao.close();
        }
        return 0;
    }
    
    public List<Professora> getPorTrechoNome(String trecho, Session sessao){
        //        List list = sessao.createQuery('FROM Professora where nome like "%'+trecho+'"').list();
        List list = sessao.createCriteria(clazz).add(Restrictions.like("nome","%"+trecho+"%")).list();
//        sessao.beginTransaction().commit();
        return list;
    }
}
