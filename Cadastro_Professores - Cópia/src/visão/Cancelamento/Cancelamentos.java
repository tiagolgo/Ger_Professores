/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Cancelamento;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Cancelamento;
import Entidades.Cancel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Detalhes_Disciplinas.Detalhes_Disciplinas;

/**
 *
 * @author Meus Documentos
 */
public class Cancelamentos extends javax.swing.JDialog {

    private Session sessão;
    private List<Cancel> cancelamentos;

    public Cancelamentos() {
        super.setTitle("Cancelados Cadastrados");
        initComponents();
        super.setModal(true);
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
//        configuraTabela();
        this.cancelamentos = new ArrayList();

        carregaTabela();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCancelamentos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        detalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaCancelamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Data", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCancelamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaCancelamentos.setRowHeight(20);
        jScrollPane1.setViewportView(tabelaCancelamentos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 751, 350));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CANCELAMENTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 771, -1));

        excluir.setBackground(new java.awt.Color(255, 102, 102));
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lixeira.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setToolTipText("Excluir o Cancelamento selecionado");
        excluir.setMargin(new java.awt.Insets(2, 2, 2, 14));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        getContentPane().add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 433, 91, -1));

        Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        Sair.setText("Sair");
        Sair.setToolTipText("Sair desta tela");
        Sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 433, 83, 39));

        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        alterar.setText("Alterar");
        alterar.setToolTipText("Alterar os dados do Cancelamento selecionado");
        alterar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        getContentPane().add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 433, 97, -1));

        detalhes.setText("Detalhes");
        detalhes.setToolTipText("Detalhes/Disciplinas do Cancelamento");
        detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesActionPerformed(evt);
            }
        });
        getContentPane().add(detalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 433, 83, 39));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeLinha() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaCancelamentos.getModel();
        model.removeRow(this.tabelaCancelamentos.getSelectedRow());
    }

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        Dao_Cancelamento ds = new Dao_Cancelamento();
        Cancel cancel = localizaCancelamento();

        if (cancel != null) {
            try {
                Transaction tr = this.sessão.beginTransaction();
                ds.delete(cancel, sessão);
                tr.commit();
                removeLinha();
                JOptionPane.showMessageDialog(null, "Cancelamento excluído!");
            } catch (Exception ex) {
                Logger.getLogger(Cancelamentos.class.getName()).log(Level.SEVERE, null, ex);
                this.sessão.beginTransaction().rollback();
                System.out.println("erro ao excluir cancelamento " + ex);
            }
        }
    }//GEN-LAST:event_excluirActionPerformed
    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhesActionPerformed
        // TODO add your handling code here:
        Cancel aux = localizaCancelamento();
        if (aux != null) {
            new Detalhes_Disciplinas(aux.getDisciplinas(), this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_detalhesActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
        Cancel can = localizaCancelamento();
        if (can != null) {
            new Cancelamento_Tela(can, this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void carregaTabela() {

        Dao_Cancelamento dc = new Dao_Cancelamento();
        try {
            this.cancelamentos = dc.list();
            if (this.cancelamentos != null) {
                DefaultTableModel model = (DefaultTableModel) tabelaCancelamentos.getModel();

                for (Cancel s : this.cancelamentos) {
                    int id = s.getId();
                    String data = s.getDataCancel();
                    String nome = s.getProfessor().getNome();
                    model.addRow(new Object[]{
                        id,
                        data,
                        nome
                    });
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Cancelamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Cancel localizaCancelamento() {
        int linha;
        if (this.tabelaCancelamentos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "não há Cancelamento cadastrado!");
        } else if ((linha = this.tabelaCancelamentos.getSelectedRow()) == -1) {
            System.out.println("linha " + linha);
            JOptionPane.showMessageDialog(null, "Selecione um Cancelamento!");
        } else {
            Object v = this.tabelaCancelamentos.getValueAt(linha, 0);
            for (Cancel cancelamento : cancelamentos) {
                if (v.equals(cancelamento.getId())) {
                    return cancelamento;
                }
            }
        }
        return null;
    }
//    private void configuraTabela() {
//        TableColumnModel columnModel = this.tabelaSubstituições.getColumnModel();
//        columnModel.getColumn(0).setMinWidth(200);
//        columnModel.getColumn(1).setMinWidth(100);
//    }
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Cancelamentos().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sair;
    private javax.swing.JButton alterar;
    private javax.swing.JButton detalhes;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCancelamentos;
    // End of variables declaration//GEN-END:variables
}
