/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessão;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Tiago
 */
public class Sessão {

    public Sessão() {
    }

    public Session retornaSession() {
        SessionFactory factory = getFactory();
        
        return factory.openSession();
    }

    private SessionFactory getFactory() {
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
//        configuration.configure();

        SessionFactory factori = configuration.buildSessionFactory();
        
        return factori;
    }
}
