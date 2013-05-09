/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import Sessão.Sessão;
import java.util.List;
import modelo.Substituicao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Substituicao extends Dao_Basic {

    public Dao_Substituicao(Session sessão) {
        super(sessão);
    }

    public List consultaData(String data) {
        return this.session.createCriteria(Substituicao.class).add(Restrictions.eq("data", data)).list();
    }

    public List consultaInicio(String data) {
        return this.session.createCriteria(Substituicao.class).add(Restrictions.eq("dataInicio", data)).list();
    }

    public void retorna_AfastadoNome(String nome) {
    }

    public void retorna_AfastadoCpf(Long cpf) {
    }

    public void retorna_AfastadoRg(Long rg) {
    }

    public void getSubst_AfastadoNome(String afastado) {
    }

    public void getSubst_AfastadoRg(Long Rg) {
    }

    public void getSubst_AfastadoCpf(Long cpf) {
    }
}
