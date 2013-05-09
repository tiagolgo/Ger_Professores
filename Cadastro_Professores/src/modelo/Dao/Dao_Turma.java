/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Driver_Conexão.Conexão;

/**
 *
 * @author Meus Documentos
 */
public class Dao_Turma {

    private Conexão conexão;
    private Connection conn;
    private PreparedStatement prepStatement;

    private void inserir() {
        
    }

    private void consultar() {
    }

    private void alterar() {
    }

    private void excluir() {
    }

    public void conectar(String prep) {

        conexão = new Conexão();

        try {
            conn = conexão.getConnection();
            prepStatement = conn.prepareStatement(prep);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void fechar() {
        try {
            conn.close();
            prepStatement.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
