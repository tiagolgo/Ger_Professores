/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Ajuda;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Curso;
import Dao.Dao_Entidades.Dao_Professor;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Cursos;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Turmas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class Teste {

    public static void main(String[] args) {
        //        Professora p = new Professora();
        //        p.setNome("Tiago luiz gomes de oliveira");
        //        p.setRg("91661195");
        //        p.setCpf("05277403906");
        //        Dao_Professor dd = new Dao_Professor();
        //
        //        Cursos c = new Cursos();
        //        c.setCodigo("4546");
        //        c.setNome("ensino medio");
        //        c.setTurno("noite");
        //        //
        //        Turmas t = new Turmas();
        //        t.setSeriacao("A");
        //        t.setSerie(1);
        //        //
        //        Disciplinas d = new Disciplinas();
        //        d.setNome("Matemática");
        //        d.setCodigo("302");
        //        d.setCompCurric("BNC");
        //        //
        //        Disciplinas d1 = new Disciplinas();
        //        d1.setNome("geografia");
        //        d1.setCodigo("301");
        //        d1.setCompCurric("BNC");
        //        //
        //        Disciplinas d2 = new Disciplinas();
        //        d2.setNome("ciencias");
        //        d2.setCodigo("354");
        //        d2.setCompCurric("BNC");
        //        //
        //        Disciplinas d3 = new Disciplinas();
        //        d3.setNome("historia");
        //        d3.setCodigo("201");
        //        d3.setCompCurric("BNC");
        //        //
        //        Disciplinas d4 = new Disciplinas();
        //        d4.setNome("portugues");
        //        d4.setCodigo("656");
        //        d4.setCompCurric("BNC");
        //
        //        //inserir disciplinas na turma
        //
        //        //
        //        t.setCurso(c);
        //        d.setTurma(t);
        //
        //        //
        //        d1.setTurma(t);
        //        d2.setTurma(t);
        //        d3.setTurma(t);
        //        d4.setTurma(t);
        //        //
        //        d.setTurma(t);
        //        d1.setTurma(t);
        //        d2.setTurma(t);
        //        d3.setTurma(t);
        //        d4.setTurma(t);
        //
        //        Dao_Turma dt = new Dao_Turma();
        //        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
        //        Dao_Professor dp = new Dao_Professor();
        boolean verDuplicidade = new Dao_Curso().verDuplicidade("ensino medio", "654", "matutino");
        System.out.println("já há cursos "+verDuplicidade);

//        try {
////            List<Professora> r = dp.getPorTrechoNome("ti", sessao);
//            JOptionPane.showMessageDialog(null, "Encotrados " + r.size());
//        } catch (Exception ex) {
//            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
