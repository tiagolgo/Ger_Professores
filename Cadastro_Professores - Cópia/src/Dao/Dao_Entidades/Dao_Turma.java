/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Generico;
import Entidades.Turmas;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Dao_Turma extends Dao_Generico<Turmas> {

    public Dao_Turma() {
        clazz = Turmas.class;
    }

    public List<String> getNomeTurmas() {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<String> list = sessao.createQuery("SELECT c.nome FROM Turmas").list();
        sessao.close();
        return list;
    }

    public boolean verDuplicidade(Turmas d) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Turmas> res = (List<Turmas>) sessao.createQuery("FROM Turmas WHERE seriacao=:c and serie=:n and id_Curso=(SELECT id FROM Cursos where id=:curso)").setParameter("c", d.getSeriacao()).setParameter("n", d.getSerie()).setParameter("curso", d.getCurso().getId()).list();
        sessao.beginTransaction().commit();
        if (res.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Turmas> getTurmasIdCurso(int idCurso) {
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Turmas> res = (List<Turmas>) sessao.createQuery("FROM Turmas WHERE id_Curso=:c").setParameter("c", idCurso).list();
        sessao.beginTransaction().commit();
        return res;
    }
    public boolean deletaPorId(int id, Session sessao) {
//        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        int res = sessao.createQuery("DELETE FROM Turmas WHERE id=:c").setParameter("c", id).executeUpdate();
        if (res>0) {
            return true;
        }
        return false;
    }
    
    public boolean verDependencias(int id){
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        List<Turmas> res = (List<Turmas>) sessao.createQuery("from Disciplinas where suprida=true and id_Supim is not null and id_Turma=:i").setParameter("i", id).list();
        if (res.size()>0) {
            return false;
        }
        return true;
    }
   
}
