/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import Hibernate_Daos.Dao_Afastamento;
import Hibernate_Daos.Dao_Disciplina;
import Hibernate_Daos.Dao_Professor;
import Hibernate_Daos.Dao_Turma;
import Sessão.Sessão;
import modelo.Afastamento;
import modelo.Pessoa.Email;
import modelo.Pessoa.Endereco;
import modelo.Pessoa.Municipio;
import modelo.Pessoa.Professor;
import modelo.Pessoa.RG;
import modelo.Pessoa.Telefone;
import modelo.curricular.Disciplina;
import modelo.curricular.Seriação;
import modelo.curricular.Turma;
import modelo.curricular.Turno;

/**
 *
 * @author Meus Documentos
 */
public class testes {

    public static void main(String[] args) throws Exception {
        Dao_Professor d = new Dao_Professor(new Sessão().retornaSession());

        Professor p = new Professor();
        RG rg = new RG();
        Municipio mun = new Municipio();
        Telefone tel = new Telefone();
        Endereco end = new Endereco();
        Email mail = new Email();

        p.setNome("teste");
        p.setData_Nascimento("10051985");
        p.setCpf(Long.parseLong("05277403906"));
        p.setCargo("professor");
        p.setLF(1);
        p.setSexo("Masculino");
        p.setAtivo(true);
        p.setVinculo("qpm");
        Municipio mun1 = new Municipio();
        mun1.setEstado("Paraná");
        mun1.setNome("Goioere");
        d.persiste(mun1);
        p.setMunicipio(mun1);

        rg.setEmissão("05051985");
        rg.setEstado("paraná");
        rg.setNúmero(Long.parseLong("5454545454"));

        mun.setEstado("paraná");
        mun.setNome("morira sales");

        tel.setDdd(44);
        tel.setNumero(35411213);
        tel.setPrincipal(true);

        end.setBairro("centro");
        end.setCep("87375000");
        end.setMunicipio(mun);
        end.setNumero(455);
        end.setRua("15 de novembro");

        mail.setEndereco("tiagolgo@hotmail.com");
        mail.setPrincipal(true);

        p.setTelefone(tel);
        p.setEndereco(end);
        p.setEmail(mail);
//        p.setMunicipio(mun);
        p.setRg(rg);

        Disciplina ds = new Disciplina();
        ds.setNome("matemática");
        ds.setAtribuida(true);
        ds.setCodigo(40);

        Disciplina dsc = new Disciplina();
        dsc.setCodigo(5444);
        dsc.setNome("Português");

        Turma tu = new Turma();
        tu.setSerie(1);
        tu.setSeriacao("A");
        tu.setTurno("Manhã");

        tu.setDisciplina(ds);
        tu.setDisciplina(dsc);
        d.persiste(tu);

        ds.setTurma(tu);
        dsc.setTurma(tu);

        p.setDisciplina(ds);
        p.setDisciplina(dsc);
//        
////        Dao_Disciplina dp = new Dao_Disciplina();
////        Disciplina di = (Disciplina) dp.retornaObjetoId(new Disciplina(), 1);
////        System.out.println("Disciplina " + di.getTurma().getId());
//////        
////        Dao_Turma dt = new Dao_Turma();
////        Turma rt = (Turma) dt.retornaObjetoId(new Turma(), 1);
////        System.out.println("Turma " + rt.getDisciplinas());
//           
////        Dao_Professor dao=new Dao_Professor();
////        Professor ro = (Professor) dao.retornaObjetoId(new Professor(), 1);
////
////        for (Disciplina s: ro.getDisciplina()) {
////            System.out.println(s.getNome());
////            System.out.println(s.getTurma().getSerie());
////        }
        d.persiste(p);
        d.fechaSessão();
        
//         Dao_Afastamento da=new Dao_Afastamento(new Sessão().retornaSession());
//        Afastamento afastamento=new Afastamento();
//        
//        afastamento.setAfastado(null);
//        afastamento.setDisciplina(null);
//        afastamento.setDataAfastamento("10/05");
//        afastamento.setInicioAfastamento("10/06");
//        afastamento.setFimAfastamento("20/05");
//        afastamento.setMotivo("Licença médica");
//        afastamento.setSuprido(false);
//        da.persiste(afastamento);
//        da.fechaSessão();

    }
}
