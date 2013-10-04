/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ana
 */
public class Hibernate_Conexao {

    private Connection con = null;
    private static Hibernate_Conexao instancia;
    private String driver;// Variavel do Driver
    private String usuario;//Variavel que guarda o valor do usuario
    private String senha;//Variavel que guarda o valor da senha
    private String endereco;//Variavel que guarda o valor da string de conexao

    private Hibernate_Conexao() {
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        senha = "root";
        endereco = "jdbc:mysql://localhost/lp2";

        getConnection();
    }

    private void getConnection() {
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        } catch (Exception erro) {
            erro.getMessage();
            System.out.println("Nao foi possivel efetuar a conexao!");
        }
    }

    public Connection getConexao() {
        return con;
    }

    public static Hibernate_Conexao getInstance() {
        if (instancia == null) {
            instancia = new Hibernate_Conexao();
        }
        return instancia;
    }
}
