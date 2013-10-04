/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Substituicao;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Substituicao;
import Dao.Dao_Entidades.Dao_Professor;
import Dao.Dao_Entidades.Dao_Substituicao;
import Entidades.Disciplinas;
import Entidades.Substituica;

import java.util.List;
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
public class Todas_Substituições extends javax.swing.JDialog {

    private Session sessão;
    private List<Substituica> substituicoes;

    public Todas_Substituições() {
        super.setTitle("Substituições Cadastradas");
        initComponents();
        super.setModal(true);
        configuraTabela();
        carregaTabela();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
    }

//    public static void main(String[] args) {
//        new Todas_Substituições().setVisible(true);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSubstituições = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        detalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaSubstituições.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Afastado", "Substituto", "Inscrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaSubstituições.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaSubstituições.setRowHeight(20);
        jScrollPane1.setViewportView(tabelaSubstituições);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, 708, 302));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SUBSTITUIÇÕES CADASTRADAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 708, -1));

        excluir.setBackground(new java.awt.Color(255, 102, 102));
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lixeira.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setToolTipText("Excluir Substituição selecionada");
        excluir.setMargin(new java.awt.Insets(2, 2, 2, 14));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        getContentPane().add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 374, -1, 34));

        Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        Sair.setText("Sair");
        Sair.setToolTipText("Sair desta tela");
        Sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 374, 91, 34));

        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        alterar.setText("Alterar");
        alterar.setToolTipText("Alterar Substituição selecionada");
        alterar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        getContentPane().add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 374, -1, 34));

        detalhes.setText("Detalhes");
        detalhes.setToolTipText("Disciplinas da Substituição");
        detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesActionPerformed(evt);
            }
        });
        getContentPane().add(detalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 374, 84, 34));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:

        Substituica aux = localizaSubstituicao();
        if (aux != null) {
            int op = JOptionPane.showConfirmDialog(null, "Confirmação", "Deseja realmente excluir a Substituição?\nOs dados referentes a esta Substituição serão permanentemente removidos e desfeitos.", 0);
            if (op == 0) {
                Dao_Substituicao ds = new Dao_Substituicao();
                Dao_Professor p = new Dao_Professor();


                for (Disciplinas disciplinas : aux.getDisciplinas()) {
                    aux.getAfastamento().getDisciplinas().add(disciplinas);
                    aux.getSubstituto().getDisciplinas().remove(disciplinas);
                }

                try {
                    Transaction tr = this.sessão.beginTransaction();
//                p.persist(aux.getAfastado(), sessão);
//                    p.persist(aux.getSubstituto(), sessão);
                    ds.delete(aux, this.sessão);
                    tr.commit();
                    //recarregarTabela
                    carregaTabela();
                } catch (Exception e) {
                    this.sessão.beginTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir Substituição!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Substituição");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterarActionPerformed

    private void detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhesActionPerformed
        // TODO add your handling code here:
        Substituica s = localizaSubstituicao();
        if (s != null) {
            new Detalhes_Disciplinas(s.getDisciplinas(), this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_detalhesActionPerformed

    private Substituica localizaSubstituicao() {
        int linha;
        if (this.tabelaSubstituições.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Não há Substituições!");
        } else if ((linha = this.tabelaSubstituições.getSelectedRow()) == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Substituição!");
        } else {
            Object aux = this.tabelaSubstituições.getValueAt(linha, 0);
            for (Substituica substituicao : substituicoes) {
                if (aux.equals(substituicao.getId())) {
                    return substituicao;
                }
            }
        }
        return null;
    }

    private void carregaTabela() {
        Dao_Substituicao ds = new Dao_Substituicao();
        List<Substituica> subs = ds.list();

        if (subs != null) {
            this.substituicoes = subs;
            DefaultTableModel model = (DefaultTableModel) tabelaSubstituições.getModel();
            for (Substituica s : this.substituicoes) {
                List<Disciplinas> dis = s.getDisciplinas();
                if (!dis.isEmpty()) {
                    for (Disciplinas d : dis) {
                        model.addRow(new Object[]{
                            //                            s.getId(),
                            //                            s.getAfastamento().getAfastado().getNome(),
                            //                            s.getSubstituto().getNome(),
                            "", "", ""
                        });
                    }
                }
            }
        }
    }

    private void configuraTabela() {
        TableColumnModel columnModel = this.tabelaSubstituições.getColumnModel();
        columnModel.getColumn(0).setMinWidth(200);
        columnModel.getColumn(1).setMinWidth(100);
        columnModel.getColumn(2).setMaxWidth(55);
        columnModel.getColumn(3).setMaxWidth(75);
    }
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
//            java.util.logging.Logger.getLogger(Todas_Substituições.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Todas_Substituições.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Todas_Substituições.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Todas_Substituições.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Todas_Substituições().setVisible(true);
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
    private javax.swing.JTable tabelaSubstituições;
    // End of variables declaration//GEN-END:variables
}
