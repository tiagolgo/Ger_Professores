/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Afastamento;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Afastamento;
import Dao.Dao_Entidades.Dao_Afastamento;
import Dao.Dao_Entidades.Dao_Disciplina;
import Entidades.Afastament;
import Entidades.Disciplinas;
import java.util.ArrayList;
import visão.Detalhes_Disciplinas.Detalhes_Disciplinas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Ajuda.Ajuda;

/**
 *
 * @author tiago
 */
public class Afastados extends javax.swing.JDialog {

    private Session sessão;
    private List<Afastament> afastamentos;

    public Afastados() {
        initComponents();
        super.setModal(true);
        this.setTitle("Professores Afastados");
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        configuraTabela();
        this.setLocationRelativeTo(null);
        carregarAfastados();
    }
//    public static void main(String[] args) {
//        new Afastados().setVisible(true);
//    }

    private void carregarAfastados() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaAfastados.getModel();

        Dao_Afastamento da = new Dao_Afastamento();
        try {
            this.afastamentos = da.list(this.sessão);

            if (afastamentos != null) {
                for (Afastament a : afastamentos) {
                    model.addRow(new Object[]{
                        a.getId(),
                        a.getDataAfas(),
                        a.getAfastado().getNome(),
                        a.getInicio(),
                        a.getFim(),
                        a.getMotivo()
                    });
                }
            } else {
                int op = JOptionPane.showConfirmDialog(null, "Não há Afastamentos cadastrados.\nDeseja realizar novo Afastamento?", "Confirmação", 0);
                if (op == 0) {
                    new Novo_Afastamento().setVisible(true);
                    removeLinhasTabela();
                    carregarAfastados();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Afastados.class.getName()).log(Level.SEVERE, null, ex);
        }

//        else {
//            JOptionPane.showMessageDialog(null, "Não há Afastamentos cadastrados!");
//        }
    }

    private void configuraTabela() {
        TableColumnModel coluna = this.tabelaAfastados.getColumnModel();
        coluna.getColumn(0).setMaxWidth(100);
        coluna.getColumn(2).setMaxWidth(100);
        coluna.getColumn(3).setMaxWidth(100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAfastados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        detalhes_Afastamento = new javax.swing.JButton();
        alterarAfastamento = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AFASTAMENTOS");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaAfastados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Afastado", "Início", "Fim", "Motivo"
            }
        ));
        tabelaAfastados.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabelaAfastados);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("PROFESSORES AFASTADOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jButton1.setText("+ Novo Afastamento");
        jButton1.setToolTipText("Cadastrar novo Afastamento");
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        detalhes_Afastamento.setText("Detalhes");
        detalhes_Afastamento.setToolTipText("Detalhes dos Professores");
        detalhes_Afastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhes_AfastamentoActionPerformed(evt);
            }
        });

        alterarAfastamento.setText("Alterar");
        alterarAfastamento.setToolTipText("Alterar Professor selecionado");
        alterarAfastamento.setMargin(new java.awt.Insets(2, 2, 2, 2));
        alterarAfastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAfastamentoActionPerformed(evt);
            }
        });

        Sair.setText("Sair");
        Sair.setToolTipText("Sair desta tela");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        jButton2.setText("Ajuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(detalhes_Afastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(alterarAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(detalhes_Afastamento)
                    .addComponent(alterarAfastamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Sair)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private Afastament localizaAfastamento() {
        int linha = this.tabelaAfastados.getSelectedRow();

        if (this.tabelaAfastados.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não há Afastamentos!");
        } else if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Afastamento!");
        } else {
            Object valueAt = this.tabelaAfastados.getValueAt(linha, 0);
            for (Afastament afastamento : afastamentos) {
                if (valueAt.equals(afastamento.getId())) {
                    return afastamento;
                }
            }
        }
        return null;
    }

    private void detalhes_AfastamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhes_AfastamentoActionPerformed
        Afastament afas = localizaAfastamento();
        if (afas != null) {
            new Detalhes_Disciplinas(afas.getDisciplinas(), this.sessão).setVisible(true);
        }

    }//GEN-LAST:event_detalhes_AfastamentoActionPerformed

    private void excluiLinha() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaAfastados.getModel();
        model.removeRow(this.tabelaAfastados.getSelectedRow());
    }

    private void alterarAfastamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAfastamentoActionPerformed
        Afastament a = localizaAfastamento();
        if (a != null) {
            new Novo_Afastamento(a, this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_alterarAfastamentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Novo_Afastamento().setVisible(true);
        removeLinhasTabela();
        carregarAfastados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Ajuda().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void removeLinhasTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaAfastados.getModel();
        int linhas = this.tabelaAfastados.getRowCount();
        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Afastados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sair;
    private javax.swing.JButton alterarAfastamento;
    private javax.swing.JButton detalhes_Afastamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAfastados;
    // End of variables declaration//GEN-END:variables
}
