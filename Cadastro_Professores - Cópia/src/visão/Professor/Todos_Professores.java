/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Professor;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Servidor;
import Dao.Dao_Entidades.Dao_Professor;
import Entidades.Professora;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class Todos_Professores extends javax.swing.JDialog {

    private Session sessão;
    private List<Professora> professores;

    public Todos_Professores() {
        initComponents();
        super.setModal(true);
        buscaDadosProf();
        this.setTitle("Professores Cadastrados");
        this.setLocationRelativeTo(null);
    }
    public Todos_Professores(List<Professora> p) {
        initComponents();
        super.setModal(true);
        this.professores=p;
        this.setTitle("Professores Cadastrados");
        this.setLocationRelativeTo(null);
        preencheTabela();
    }

//    public static void main(String[] args) {
//        new Todos_Professores().setVisible(true);
//    }

    private void buscaDadosProf() {
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        Dao_Professor dp = new Dao_Professor();
        try {
            professores = dp.list(this.sessão);
        } catch (Exception ex) {
            Logger.getLogger(Todos_Professores.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!professores.isEmpty()) {
            preencheTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Não há Professores Cadastrados");
        }
    }

    private void preencheTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Professores.getModel();

        for (Professora p : this.professores) {
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getRg(), p.getCpf()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Professores = new javax.swing.JTable();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        sair = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PROFESSORES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_Professores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "RG", "CPF"
            }
        ));
        jScrollPane1.setViewportView(tabela_Professores);

        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        alterar.setText("Alterar");
        alterar.setToolTipText("Alterar dados do Professor selecionado");
        alterar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lixeira.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setToolTipText("Excluir professor selecionado");
        excluir.setMargin(new java.awt.Insets(2, 2, 2, 14));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        sair.setText("Sair");
        sair.setToolTipText("Sair desta tela");
        sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PROFESSORES CADASTRADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(alterar)
                .addGap(18, 18, 18)
                .addComponent(excluir)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
        Professora p = localizaProfessor();
        if (p != null) {
            new Cadastro(p, true).setVisible(true);
            limparTabela();
            buscaDadosProf();
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
//        this.sessão.close();
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private Professora localizaProfessor() {
        int linha = this.tabela_Professores.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Professor!");
        } else {
            int v = Integer.parseInt(this.tabela_Professores.getValueAt(linha, 0).toString());
            for (Professora professor : professores) {
                if (professor.getId() == v) {
                    return professor;
                }
            }
        }
        return null;
    }

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        Professora p = localizaProfessor();

        if (p != null) {
            StringBuilder retorno = new Controller_Servidor().removerServidor(p, sessão);
            if (retorno == null) {
                if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão de: " + p.getNome() + "?") == 0) {
                    Dao_Professor dp = new Dao_Professor();
                    try {
                        Transaction tr = this.sessão.beginTransaction();
                        dp.delete(p, this.sessão);
                        tr.commit();
                        removeLinha();//remove linha selecionada
                        confirma_NovaOperação();
                    } catch (Exception es) {
                        JOptionPane.showMessageDialog(null, "O Professor possui registros válidos e não pode ser removido!");
                        this.sessão.beginTransaction().rollback();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, retorno);
            }
    }//GEN-LAST:event_excluirActionPerformed
    }

    private void removeLinha() {
        int linha = this.tabela_Professores.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel model = (DefaultTableModel) this.tabela_Professores.getModel();
            model.removeRow(linha);
        }
    }

    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Professores.getModel();
        int linhas = this.tabela_Professores.getRowCount();
        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
        }
    }

    private void confirma_NovaOperação() {
        if (JOptionPane.showConfirmDialog(null, "Operação realizada!\nDeseja realizar nova Operação?", "Confirmação", 0) == 1) {
            this.dispose();
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
//            java.util.logging.Logger.getLogger(Todos_Professores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Todos_Professores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Todos_Professores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Todos_Professores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Todos_Professores().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton sair;
    private javax.swing.JTable tabela_Professores;
    // End of variables declaration//GEN-END:variables
}
