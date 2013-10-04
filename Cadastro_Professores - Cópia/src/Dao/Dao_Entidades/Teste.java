/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao_Entidades;

import Conexao.Hibernate_Sessao;
import Entidades.Cursos;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Suprim;
import Entidades.Turmas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.type.Type;

/**
 *
 * @author Tiago
 */
public class Teste {

    public static void main(String[] args) {
//          int opção = JOptionPane.showConfirmDialog(
//                null, "Distribuição realizada!\nDeseja realizar nova Distribuição?", "Confirmação", 0);
//          System.out.println(opção);
//        Dao_Curso dc = new Dao_Curso();

        Dao_Professor dp = new Dao_Professor();
////        boolean r = dc.retrievePorNome("4000", "celem","diurno");
////        System.out.println("retorno "+r);
        Session sessao = Hibernate_Sessao.getInstance().retornaSession();
//        Suprim s = new Suprim();
//        s.setCodigo("s65");
//        s.setDataInicio("10022002");
//        s.setDataSuprim("10033203");
//        List<Disciplinas> naoSupridas = dd.getNaoSupridas();
//        s.setDisciplinas(naoSupridas);
        try {
            Professora p = dp.retornaPorRG("91661195", sessao);

            Dao_Disciplina dd = new Dao_Disciplina();
//            Disciplinas retrieve = dd.retrieve(3, sessao);

//            p.setDisciplina(retrieve);




            //            System.out.println(dp.isExiste("91661195", "05277403906"));
            //            Dao_Suprimento ds = new Dao_Suprimento();
            //            ds.persist(s);
            //            Object[] nomeCursos = dc.getNomeCursos();
            //            List ret = dd.getPorIdTurma(3);
            //            Professora unicoNome = dp.getUnicoNome("tiago");
            //            if (unicoNome==null) {
            //                System.out.println("vazio");
            //            }else{
            //                System.out.println("professor");
            //            }
            //            System.out.println("tamanho do retorno "+ret.size());
            //            System.out.println("nome dos cursos "+nomeCursos[0].toString());
            //            Dao_Turma dt = new Dao_Turma();
            //            Turmas t = dt.retrieve(3);
            //            System.out.println("turma "+t.getCurso().getNome());
            //            Dao_Disciplina dd = new Dao_Disciplina();
            //            Disciplinas d = dd.retrieve(1);
            //            System.out.println("disciplina "+d.getNome());
            ////
            //            d.setTurma(t);
            //////
            //            dd.persist(d);
            //            sessao.beginTransaction().commit();
            //        Professora p = new Professora();
            //        Disciplinas d=new Disciplinas();
            //        Dao_Professor dp = new Dao_Professor();
            //        Dao_Disciplina dd = new Dao_Disciplina();
            //
            //        p.setNome("Tiago");
            //        p.setNascimento("10/02/2002");
            //
            //        d.setNome("geografia");
            //        d.setCodigo("454654");
            //        try {
            
            dp.persist(p, sessao);
            //        } catch (Exception ex) {
            //        }
            //        }
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
