/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate_Daos;

import java.util.List;
import modelo.Pessoa.Servidor;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class Dao_Servidor extends Dao_Basic {

    public Dao_Servidor(Session sessão) {
        super(sessão);
    }

    public List retorna_ServidorNome(String nome) {
        return this.session.createCriteria(Servidor.class).add(Restrictions.eq("nome", nome)).list();
    }

    public List retorna_ServidorFuncao(String cargo) {
        return this.session.createCriteria(Servidor.class).add(Restrictions.eq("cargo", cargo)).list();
    }

    public List retorna_ServidorStatus(boolean status) {
        return this.session.createCriteria(Servidor.class).add(Restrictions.eq("ativo", status)).list();
    }
}
