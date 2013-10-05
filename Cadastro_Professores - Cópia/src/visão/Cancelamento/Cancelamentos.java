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
import visão.Ajuda.Ajuda;
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
        Sair = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        detalhes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        alterar1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(258, 258, 258))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Sair.setText("Sair");
        Sair.setToolTipText("Sair desta tela");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.setToolTipText("Alterar os dados do Cancelamento selecionado");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        detalhes.setText("Detalhes");
        detalhes.setToolTipText("Detalhes/Disciplinas do Cancelamento");
        detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("PROFESSORES CANCELADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        alterar1.setText("+ Cancelamento");
        alterar1.setToolTipText("Alterar os dados do Cancelamento selecionado");
        alterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ajuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(alterar1)
                        .addGap(18, 18, 18)
                        .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(detalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sair)
                    .addComponent(detalhes)
                    .addComponent(alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alterar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeLinha() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaCancelamentos.getModel();
        model.removeRow(this.tabelaCancelamentos.getSelectedRow());
    }

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

    private void alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar1ActionPerformed
        // TODO add your handling code here:
        new Cancelamento_Tela().setVisible(true);
        removerLinhasTabela();
        carregaTabela();
    }//GEN-LAST:event_alterar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Ajuda().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void removerLinhasTabela(){
        DefaultTableModel model=(DefaultTableModel) this.tabelaCancelamentos.getModel();
        int linhas = this.tabelaCancelamentos.getRowCount();
        while(linhas>0){
            model.removeRow(0);
            linhas--;
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
    private javax.swing.JButton alterar1;
    private javax.swing.JButton detalhes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCancelamentos;
    // End of variables declaration//GEN-END:variables
}
