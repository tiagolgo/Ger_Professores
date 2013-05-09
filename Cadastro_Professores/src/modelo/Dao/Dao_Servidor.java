/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Driver_Conexão.Conexão;
import modelo.Interface_Servidor;
import modelo.Pessoa.Professor;

/**
 *
 * @author Meus Documentos
 */
public class Dao_Servidor implements Interface_Servidor {

    private Conexão conexão;
    private Connection conn;
    private PreparedStatement prepStatement;

    @Override
    public void inserir(Professor professor) {
        String inserir = "INSERT INTO professor VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conectar(inserir);
        try {
//    professor(id INT NOT NULL AUTO_INCREMENT,
//    Nome varchar(50) not null,
//    Rg varchar(10) unique,
//    UF varchar(2),
//    Expedição varchar,
//    Cpf varchar(11),
//    Sexo enum("M","F") not null,
//    nascimento varchar not null,
            
//    vínculo enum("QPM","PSS","REPR"),
//    status enum("ATIVO", "INATIVO","SUBSTITUIDO"),
//    função enum("PROFESSOR","FUNCIONÁRIO","DIRETOR","PEDAGOGO"),
//    id_endereço int)
            conn.setAutoCommit(false);
//            prepStatement.setString(1, professor.getNome());
//            prepStatement.setString(2, professor.getRg());
//            prepStatement.setString(3, professor.getUF());
//            prepStatement.setString(4, professor.getExpedição());
//            prepStatement.setString(5, professor.getCpf());
//            prepStatement.setString(6, professor.getSexo());
//            prepStatement.setString(7, professor.getNascimento());
//
//            //prepStatement.setInt(9, professor.getLF());
//            prepStatement.setString(8, professor.getVínculo());
//            prepStatement.setString(9, professor.isStatus());
//            prepStatement.setString(10, professor.getFunção());
//            Dao_Endereço dae = new Dao_Endereço();
//            prepStatement.setInt(11, dae.contaRegistros());

            prepStatement.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
        } finally {
            fechar();
        }
    }

    @Override
    public Professor consultar(String rg) {
        String consulta = "SELECT*FROM professor WHERE Rg=?";
        conectar(consulta);
        ResultSet rs;
        try {
            Professor aux = null;
            prepStatement.setString(1, rg);
            rs = prepStatement.executeQuery();
            while (rs.next()) {
//String Nome, String Rg, String UF, String Expedição, String Cpf, String Sexo, String nascimento//           
//                aux = new Professor();
//                aux.setNome(rs.getString(2));
//                aux.setRg(rs.getString(3));
//                aux.setUF(rs.getString(4));
//                aux.setExpedição(rs.getString(5));
//                aux.setCpf(rs.getString(6));
//                aux.setSexo(rs.getString(7));
//                aux.setNascimento(rs.getString(8));
//                aux.setVínculo(rs.getString(9));
//                aux.setStatus(rs.getString(10));
//                aux.setFunção(rs.getString(11));                      
            }
            return aux;

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            fechar();
        }

    }

    @Override
    public ArrayList<String> consultaTodos() {
        String consulta = "select nome from professor";
        conectar(consulta);
        ResultSet rs;
        try {
            ArrayList<String> nomes = new ArrayList<>();
            rs = this.prepStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                //String Nome, long Rg, String UF, String Expedição, long Cpf, String Sexo, String nascimento
                nomes.add(rs.getString(i));
                i++;
            }


            return nomes;
        } catch (Exception ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            // fechar();
        }
    }

    @Override
    public void alterar(Professor prof, String rg) {
        //String Nome, long Rg, String UF, String Expedição, long Cpf, String Sexo, String nascimento

        String altera = "UPDATE professor SET Nome=?, Rg=?, Uf=?, Expedição=?, Cpf=?, Sexo=?, nascimento=? WHERE Rg=?";
        conectar(altera);
        try {
            conn.setAutoCommit(false);
//            prepStatement.setString(1, prof.getNome());
//            prepStatement.setString(2, prof.getRg());
//            prepStatement.setString(3, prof.getUF());
//            prepStatement.setString(4, prof.getExpedição());
//            prepStatement.setString(5, prof.getCpf());
//            prepStatement.setString(6, prof.getSexo());
//            prepStatement.setString(7, prof.getNascimento());
            prepStatement.setString(8, rg);
            /*
             prepStatement.setString(9, prof.isStatus());
             prepStatement.setString(10, prof.getFunção());
             prepStatement.setString(11, prof.getVínculo());
             prepStatement.setString(12, prof.getEndereço());
             */
            prepStatement.execute();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            fechar();
        }

    }

    @Override
    public boolean excluir(Professor prof) {
        String exclui = "DELETE FROM professor WHERE Rg=?";
        conectar(exclui);
        try {
            conn.setAutoCommit(false);
//            prepStatement.setString(1, prof.getRg());
            prepStatement.execute();
            conn.commit();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            fechar();
        }
    }

    private void conectar(String prep) {

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
