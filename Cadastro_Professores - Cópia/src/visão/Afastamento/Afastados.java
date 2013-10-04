/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Afastamento;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Afastamento;
import Dao.Dao_Entidades.Dao_Afastamento;
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
            this.afastamentos = da.list();

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
        Sair = new javax.swing.JButton();
        alterarAfastamento = new javax.swing.JButton();
        excluirAfastamento = new javax.swing.JButton();
        detalhes_Afastamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AFASTAMENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 808, -1));

        tabelaAfastados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Afastado", "Início", "Fim", "Motivo"
            }
        ));
        tabelaAfastados.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabelaAfastados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 788, 370));

        Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        Sair.setText("Sair");
        Sair.setToolTipText("Sair desta tela");
        Sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 448, 84, 42));

        alterarAfastamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        alterarAfastamento.setText("Alterar");
        alterarAfastamento.setToolTipText("Alterar Professor selecionado");
        alterarAfastamento.setMargin(new java.awt.Insets(2, 2, 2, 2));
        alterarAfastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAfastamentoActionPerformed(evt);
            }
        });
        getContentPane().add(alterarAfastamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 448, 88, 42));

        excluirAfastamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lixeira.png"))); // NOI18N
        excluirAfastamento.setText("Excluir");
        excluirAfastamento.setToolTipText("Excluir Professor selecionado");
        excluirAfastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirAfastamentoActionPerformed(evt);
            }
        });
        getContentPane().add(excluirAfastamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 448, -1, 42));

        detalhes_Afastamento.setText("Detalhes");
        detalhes_Afastamento.setToolTipText("Detalhes dos Professores");
        detalhes_Afastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhes_AfastamentoActionPerformed(evt);
            }
        });
        getContentPane().add(detalhes_Afastamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 448, 85, 42));

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

    private void excluirAfastamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirAfastamentoActionPerformed
        Dao_Afastamento da = new Dao_Afastamento();
        Afastament afast = localizaAfastamento();
        if (afast != null) {
            Controller_Afastamento ca = new Controller_Afastamento();
            ArrayList<String> res = ca.delete(afast, sessão);
            
            if (res!=null) {
                JOptionPane.showMessageDialog(null, "Afastamento removido com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, res);
                
//                if (reverteAfastamento(afast)) {
//                    try {
//                        Transaction tr = this.sessão.beginTransaction();
//                        da.delete(afast);
//                        tr.commit();
//                        excluiLinha();
//                        JOptionPane.showMessageDialog(null, "Afastamento Excluído");
//                    } catch (Exception ex) {
//                        this.sessão.beginTransaction().rollback();
//                        JOptionPane.showMessageDialog(null, "Não foi possível excluir o Afastemento!");
//                        Logger.getLogger(Afastados.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
        }
    }//GEN-LAST:event_excluirAfastamentoActionPerformed

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
//
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
//            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Afastados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Afastados().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sair;
    private javax.swing.JButton alterarAfastamento;
    private javax.swing.JButton detalhes_Afastamento;
    private javax.swing.JButton excluirAfastamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAfastados;
    // End of variables declaration//GEN-END:variables
}
