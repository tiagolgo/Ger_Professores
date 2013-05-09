/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver_Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ana
 */
public class Conexão {

    /**
     * Variavel de conexao
     */
    private Connection con = null;
    private String driver;// Variavel do Driver
    private String usuario;//Variavel que guarda o valor do usuario
    private String senha;//Variavel que guarda o valor da senha
    private String endereco;//Variavel que guarda o valor da string de conexao
    
    public Conexão() {//Construtor default
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        senha = "root";
        endereco = "jdbc:mysql://localhost/projeto";
    }

    /**
     * Cria e retorna a conexao do driver JDBC ao banco de dados
     */
    public Connection getConnection() {
        
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return null;
        } catch (Exception erro) {
            erro.getMessage();
            System.out.println("Nao foi possivel efetuar a conexao!");
            return null;
        }
        return con;
    }
}
