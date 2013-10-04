/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Conexao.Hibernate_Conexao;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Exemplo de uso da lib JasperReports. Passos para uso: - executar o
 * script_banco.sql para criar base, tabelas e povoar o banco. - executar o
 * main() desta classe.
 *
 * @author marcos
 */
public class Relatorio {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws JRException {
////        new Relatorio().relatorioPronto();
////        new Relatorio().relatorioDeConsultaSQL();
//        new Relatorio().relatorioEmJFrame();
//    }

//    public void relatorioDeConsultaSQL() {
//        try {
//            // obtem conexao com BD
//            Connection con = DBConnection.getConnection();
//
//            // monta e executa SQL (nomes das colunas devem ser iguais aos dos campos no relatorio)
//            String sql = "SELECT id AS contato_ID, nascimento AS contato_NASCIMENTO, "
//                    + "nome AS contato_NOME, telefone AS contato_TELEFONE, "
//                    + "tipo AS contato_TIPO FROM contato";
//            ResultSet res = DBConnection.executeSQL(sql);
//            // cria objeto JasperReports para resultado tipo ResultSet
//            JRResultSetDataSource jrRS = new JRResultSetDataSource(res);
//            // monta relatorio
//            JasperPrint jasperPrint = JasperFillManager.fillReport("src/ireportsteste/report1.jasper", new HashMap(), jrRS);
//            // exibe em janela
//            JasperViewer.viewReport(jasperPrint);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERRO: " + e);
//        }
//    }
    private void relatorioPronto() throws JRException {
        try {
            // obtem o arquivo de relatorio compilado
            URL arquivo = getClass().getResource("professores.jasper");

            // carrega o relatorio
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);

            // preenche o relatorio com os dados do BD
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), Hibernate_Conexao.getInstance().getConexao());

            // cria visualizador de relatorio
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
//            jrviewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
            // mostra o visualizador
            jrviewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: ");
            System.out.println(e);
        }
    }

    public void relatorioEmJFrame() {
        try {
            // obtem o arquivo de relatorio compilado
            URL arquivo = getClass().getResource("professores.jasper");

            // carrega o relatorio
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
            // preenche o relatorio com os dados do BD
            Connection con = Hibernate_Conexao.getInstance().getConexao();
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), con);

            // cria visualizador de relatorio
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            jrviewer.setSize(1200, 800);

            // adicionar visualizador ao frame
            JDialogReport frame = new JDialogReport();
            // adicionamos o visualizador a um JPanel dentro do JFrame
            frame.getjPanelReport().add(jrviewer.getContentPane());
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório: "+e.getCause());
        }
    }
}