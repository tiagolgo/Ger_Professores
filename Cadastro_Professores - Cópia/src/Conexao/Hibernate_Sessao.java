/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import Entidades.Cancel;
import Entidades.Professora;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Tiago
 */
public class Hibernate_Sessao {
private static Hibernate_Sessao instance=null;

    private Hibernate_Sessao() {
    }
    
    public static Hibernate_Sessao getInstance(){
        if (instance==null) {
            instance=new Hibernate_Sessao();
        }
        return instance;
    }
    
    public Session retornaSession() {
        SessionFactory factory = getFactory();
        return factory.openSession();
    }

    private SessionFactory getFactory() {
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
        configuration.setProperty("hibernate.connection.username", DatabaseConfig.DATABASE_USER);
        configuration.setProperty("hibernate.connection.password", DatabaseConfig.DATABASE_PASSWORD);
        configuration.setProperty("hibernate.connection.url", DatabaseConfig.DATABASE_URL);
        configuration.setProperty("hibernate.connection.driver_class", DatabaseConfig.DATABASE_DRIVER);
        configuration.setProperty("show_sql", DatabaseConfig.HIBERNATE_SHOW_SQL);
        configuration.setProperty("format_sql", DatabaseConfig.HIBERNATE_FORMAT_SQL);
        configuration.setProperty("hibernate.hbm2ddl.auto", DatabaseConfig.HIBERNATE_CREATE_TABLES);
        
//        configuration.addAnnotatedClass(Cancel.class);
//        configuration.addAnnotatedClass(Professora.class);
        SessionFactory factori = configuration.buildSessionFactory();
        return factori;
    }
}
