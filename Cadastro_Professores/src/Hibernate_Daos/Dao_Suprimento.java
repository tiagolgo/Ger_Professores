/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import Sessão.Sessão;
import java.util.List;
import modelo.Suprimento;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Suprimento extends Dao_Basic {

    public Dao_Suprimento(Session sessao) {
        super(sessao);
    }

    public List retorna_SuprimData(String data) {
        return this.session.createCriteria(Suprimento.class).add(Restrictions.eq("data_Suprimento", data)).list();
    }

    public List retorna_DataAssumiu(String data) {
        return this.session.createCriteria(Suprimento.class).add(Restrictions.eq("dataAssumiu", data)).list();
    }

    public void consulta_ProfessorRG(Long rg) {
    }

    public void consulta_ProfessorCPF(Long cpf) {
    }

    public void consulta_ProfessorNome(String nome) {
    }
}
