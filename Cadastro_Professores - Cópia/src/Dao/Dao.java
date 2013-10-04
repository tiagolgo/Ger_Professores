/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

//import java.sql.Connection;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author suporte
 */
public interface Dao<T> {
    void persist(T o)  throws Exception;
    void persist(T o, Session sessao)  throws Exception;
    void delete(T o)  throws Exception;
    void delete(T o, Session sessao)  throws Exception;
    T retrieve(int id)  throws Exception;
    List<T> list()  throws Exception;
//    List<T> list(Filter... filters)  throws Exception;
}
