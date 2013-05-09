/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.awt.List;

/**
 *
 * @author Meus Documentos
 */
public interface Dao<T> {
    void insert(T object);
    void update(T object);
    void delete(T object);
    T retrieve(int id);
//    List<T> List();
    
}
