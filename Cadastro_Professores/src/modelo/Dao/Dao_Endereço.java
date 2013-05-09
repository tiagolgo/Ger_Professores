/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import modelo.curricular.Disciplina;
//import modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Driver_Conexão.Conexão;

/**
 *
 * @author Meus Documentos
 */
public class Dao_Endereço {

    private Conexão conexão;
    private Connection conn;
    private PreparedStatement prepStatement;

    public boolean inserir() {
        String insere = "INSERT INTO endereço VALUES(null,?,?,?,?,?)";
        conectar(insere);
        try {
            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, end.getRua());
//            this.prepStatement.setInt(2, end.getNúmero());
//            this.prepStatement.setString(3, end.getBairro());
//            this.prepStatement.setString(4, end.getCidade());
//            this.prepStatement.setString(5, end.getCep());

            this.prepStatement.execute();
            conn.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            fechar();
        }


    }

//    public Endereço consultar(String rg) {//consultar endereço de professor
//        String consultar = "select*from endereço e where e.id= (select p.id_endereço from professor p where p.rg=?)";
//        conectar(consultar);
//        ResultSet rs;
//        Endereço aux = null;
//        try {
//            this.prepStatement.setString(1, rg);
//            rs = this.prepStatement.executeQuery();
//            while (rs.next()) {
//                aux = new Endereço(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
//            }
//            return aux;
//        } catch (SQLException ex) {
//            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } finally {
//            fechar();
//        }
//    }

    public void alterar(String end) {
        String altera = "UPDATE endereço SET rua=?, número=?, bairro=?, cidade=?, cep=?";
        conectar(altera);
        try {

            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, d.getRua());
//            this.prepStatement.setInt(2, d.getNúmero());
//            this.prepStatement.setString(3, d.getBairro());
//            this.prepStatement.setString(4, d.getCidade());
//            this.prepStatement.setString(5, d.getCep());
            this.prepStatement.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechar();
        }
    }

    public void excluir() {
        String exclui = "DELETE FROM endereço WHERE rua=?";
        conectar(exclui);
        try {
            conn.setAutoCommit(false);
//            this.prepStatement.setString(1, d.getRua());
            this.prepStatement.execute();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechar();
        }
    }

    public int contaRegistros() {

        String conta = "select count(*)from endereço";
        conectar(conta);
        int r;
        try {
            this.conn.setAutoCommit(false);
            ResultSet rs = this.prepStatement.executeQuery();
            conn.commit();
//            r=rs.getInt(1);
            while(rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Endereço.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            fechar();
        }
        return -1;

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
