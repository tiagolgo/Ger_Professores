/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Turma;


import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Turmas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import visão.Detalhes_Disciplinas.Detalhes_Disciplinas;

/**
 *
 * @author tiago
 */
public class Turmas_Cadastradas extends javax.swing.JDialog {

    /**
     * Creates new form Turmas_Cadastradas
     */
    private List<Turmas> turmas;
    private Session sessão;

//    public static void main(String[] args) {
//        new Turmas_Cadastradas().setVisible(true);
//    }
    public Turmas_Cadastradas() {
        initComponents();
        super.setModal(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Turmas Cadastradas");
        this.setLocationRelativeTo(null);
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        carregaTabela();
    }

    private void carregaTabela() {
        Dao_Turma dt = new Dao_Turma();
        DefaultTableModel model = (DefaultTableModel) this.tabela_Turmas.getModel();

        this.turmas = dt.list();

        if (turmas != null) {
            for (Turmas turma : turmas) {
                model.addRow(new Object[]{
                    turma.getId(),
                    turma.getSerie() + turma.getSeriacao(),
                    turma.getCurso().getNome(),
                    turma.getCurso().getTurno()
                });
            }
        }
    }

    private void removeLinhasTabela(){
        DefaultTableModel model=(DefaultTableModel) this.tabela_Turmas.getModel();
        int linhas = this.tabela_Turmas.getRowCount();
        while(linhas>0){
            model.removeRow(0);
            linhas--;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Turmas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        detalhes_Turma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Turmas Cadastradas");

        jButton2.setText("Adicionar");
        jButton2.setToolTipText("Adicionar Nova Turma");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        tabela_Turmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Turma", "Curso", "Turno"
            }
        ));
        jScrollPane1.setViewportView(tabela_Turmas);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setToolTipText("Sair desta tela");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        detalhes_Turma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        detalhes_Turma.setText("Disciplinas");
        detalhes_Turma.setToolTipText("Exibe as Disciplinas da Turma selecionada");
        detalhes_Turma.setMargin(new java.awt.Insets(2, 2, 2, 14));
        detalhes_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhes_TurmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(detalhes_Turma)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detalhes_Turma)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void detalhes_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhes_TurmaActionPerformed
        // TODO add your handling code here:
        Turmas t=localizaTurma();
        if (t!= null) {
            int linha = this.tabela_Turmas.getSelectedRow();
            int id = (int) this.tabela_Turmas.getValueAt(linha, 0);
            Dao_Disciplina dd = new Dao_Disciplina();
            
            new Detalhes_Disciplinas(dd.getPorIdTurma(id), this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_detalhes_TurmaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Cadastro_Turmas().setVisible(true);
        removeLinhasTabela();
        carregaTabela();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private Turmas localizaTurma() {
        int linha;
        if (this.tabela_Turmas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não há Turmas Cadastradas!");
        } else if ((linha = this.tabela_Turmas.getSelectedRow()) == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Turma!");
        } else {
            Object id = this.tabela_Turmas.getValueAt(linha, 0);
            for (Turmas turma : turmas) {
                if (id.equals(turma.getId())) {
                    return turma;
                }
            }
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Turmas_Cadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Turmas_Cadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Turmas_Cadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Turmas_Cadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Turmas_Cadastradas().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detalhes_Turma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_Turmas;
    // End of variables declaration//GEN-END:variables
}
