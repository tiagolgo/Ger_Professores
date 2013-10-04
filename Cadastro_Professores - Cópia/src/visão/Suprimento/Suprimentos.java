/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Suprimento;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Suprimento;
import Entidades.Suprim;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import visão.Detalhes_Disciplinas.Detalhes_Disciplinas;

/**
 *
 * @author tiago
 */
public class Suprimentos extends javax.swing.JDialog {

    private Session sessão;
    private List<Suprim> todos;

    public Suprimentos() {
        initComponents();
        super.setModal(true);
        this.setTitle("Professores Supridos");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        carregaTabela();
    }
//    public static void main(String[] args) {
//        new Suprimentos().setVisible(true);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Suprimentos = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        detalhes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela_Suprimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Professor", "Data do Suprimento"
            }
        ));
        tabela_Suprimentos.setToolTipText("");
        jScrollPane1.setViewportView(tabela_Suprimentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 634, 294));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        sair.setText("Sair");
        sair.setToolTipText("Sair desta tela");
        sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel1.add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 387, 90, -1));

        detalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        detalhes.setText("Detalhes");
        detalhes.setToolTipText("Disciplinas do Suprimento");
        detalhes.setMargin(new java.awt.Insets(2, 2, 2, 14));
        detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesActionPerformed(evt);
            }
        });
        jPanel1.add(detalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 387, -1, 33));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUPRIMENTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 634, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("SUPRIMENTOS CADASTRADOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 61, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaTabela() {

        DefaultTableModel model = (DefaultTableModel) this.tabela_Suprimentos.getModel();

        Dao_Suprimento ds = new Dao_Suprimento();

        this.todos = ds.list();

        if (todos != null) {
            for (Suprim suprimento : todos) {
//                System.out.println("suprimento "+suprimento.getId());
                model.addRow(new Object[]{
                    suprimento.getId(),
                    suprimento.getProfessor().getNome(),
                    suprimento.getDataSuprim()
                });
            }
        }
    }

    private Suprim localizaSuprimento() {
        int linha;
        if (this.tabela_Suprimentos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não há Suprimentos!");
        } else if ((linha = this.tabela_Suprimentos.getSelectedRow()) == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Suprimento!");
        } else {
            for (Suprim s : todos) {
                if (this.tabela_Suprimentos.getValueAt(linha, 0).equals(s.getId())) {
                    return s;
                }
            }
        }
        return null;
    }

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhesActionPerformed
        // TODO add your handling code here:
        Suprim suprimento=localizaSuprimento();
        if (suprimento != null) {
            new Detalhes_Disciplinas(suprimento.getDisciplinas(), this.sessão).setVisible(true);
        }
    }//GEN-LAST:event_detalhesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detalhes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela_Suprimentos;
    // End of variables declaration//GEN-END:variables
}
