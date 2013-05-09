/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import modelo.curricular.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import Driver_Conexão.Conexão;
import org.hibernate.Session;

/**
 *
 * @author Meus Documentos
 */
public class Dao_Disciplina {

    private Conexão conexão;
    private Connection conn;
    private PreparedStatement prepStatement;

//    public void inserir(Disciplina disc) {
//        String insere = "INSERT INTO disciplina(código, nome, comp_curricular) VALUES(?,?,?)";
//        conectar(insere);
//        try {
//            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, disc.getCódigo());
//            this.prepStatement.setString(2, disc.getNome());
//            this.prepStatement.setString(3, disc.getCompCurric());
//
//            this.prepStatement.execute();
//            conn.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            fechar();
//        }
//
//
//    }
//
//    public Disciplina consultar(String código) {
//        String consultar = "SELECT * FROM disciplina WHERE código=?";
//        conectar(consultar);
//        ResultSet rs;
//        Disciplina aux = null;
//        try {
//            this.prepStatement.setString(1, código);
//            rs = this.prepStatement.executeQuery();
//            while (rs.next()) {
//                aux = new Disciplina(rs.getString(2), rs.getString(3), rs.getString(4));
//            }
//            this.prepStatement.execute();
//            return aux;
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } finally {
//            fechar();
//        }
//    }
//
//    public void alterar(String cód, Disciplina d) {
//        String altera = "UPDATE disciplina SET código=?, nome=?,comp_curricular=?";
//        conectar(altera);
//        try {
//
//            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, d.getCódigo());
//            this.prepStatement.setString(2, d.getNome());
//            this.prepStatement.setString(3, d.getCompCurric());
//            this.prepStatement.executeUpdate();
//            conn.commit();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            fechar();
//        }
//    }
//
//    public void excluir(Disciplina d) {
//        String exclui = "DELETE FROM disciplina WHERE código=?";
//        conectar(exclui);
//        try {
//            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, d.getCódigo());
//            conn.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            fechar();
//        }
//
//
//
//    }
//
//    public void conectar(String prep) {
//
//        conexão = new Conexão();
//
//        try {
//            conn = conexão.getConnection();
//            prepStatement = conn.prepareStatement(prep);
//            System.out.println("Conectado!");
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
//    }
//
//    private void fechar() {
//        try {
//            conn.close();
//            prepStatement.close();
//            System.out.println("Conexão Fechada");
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public Dao_Disciplina(Session sessão) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
