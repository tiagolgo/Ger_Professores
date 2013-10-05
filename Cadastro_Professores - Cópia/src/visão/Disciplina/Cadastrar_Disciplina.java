/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Disciplina;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Disciplina;
import Dao.Dao_Entidades.Dao_Disciplina;
import Entidades.Disciplinas;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cadastrar_Disciplina extends javax.swing.JDialog {

    private Disciplinas novaDisc;
    private Session sessao;
    private boolean atualizar;

//    public static void main(String[] args) {
//        new Cadastrar_Disciplina().setVisible(true);
//    }
    public Cadastrar_Disciplina() {
        initComponents();
        super.setModal(true);
        this.setTitle("Cadastro de Disciplina");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        carregarTabela();
        this.atualizar = false;
        this.sessao = Hibernate_Sessao.getInstance().retornaSession();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Excluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Grade = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        código = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        disciplina = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comp_Curricular = new javax.swing.JComboBox();
        insere_Disciplina = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        sair = new javax.swing.JButton();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuPopup.add(Editar);

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });
        menuPopup.add(Excluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO DE DISCIPLINA");

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
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_Grade.setAutoCreateRowSorter(true);
        tabela_Grade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Disciplina", "Comp. Curricular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Grade.setRowHeight(20);
        tabela_Grade.setRowMargin(2);
        tabela_Grade.setSurrendersFocusOnKeystroke(true);
        tabela_Grade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabela_GradeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_Grade);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setAutoscrolls(true);
        jLabel6.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setText("Disciplinas Cadastradas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Obs: Selecione a grade e clique com botão direito do mouse para Editá-la ou Excluí-la.");

        jLabel8.setText("Código*:");

        jLabel9.setText("Disciplina*:");

        jLabel10.setText("Comp. Curricular*:");

        comp_Curricular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "BNC", "PD" }));

        insere_Disciplina.setBackground(new java.awt.Color(0, 51, 255));
        insere_Disciplina.setForeground(new java.awt.Color(255, 255, 255));
        insere_Disciplina.setText("Salvar");
        insere_Disciplina.setToolTipText("Slavar a Disciplina");
        insere_Disciplina.setMargin(new java.awt.Insets(2, 2, 2, 2));
        insere_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_DisciplinaActionPerformed(evt);
            }
        });
        insere_Disciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                insere_DisciplinaKeyReleased(evt);
            }
        });

        sair.setBackground(new java.awt.Color(255, 153, 0));
        sair.setText("Sair");
        sair.setToolTipText("Sair destatela");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(código, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_Curricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(insere_Disciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(comp_Curricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insere_Disciplina)
                    .addComponent(código, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //adiciona preenche a tabela de disciplina
    private void insere_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_DisciplinaActionPerformed
        //verificar se há campos em branco
        StringBuilder not = verificaCampos();
        if (not.length() == 0) {
            Dao_Disciplina dd = new Dao_Disciplina();

            if (!this.atualizar) {
                this.novaDisc = new Disciplinas();
            }

            String cod = this.código.getText();
            String disc = this.disciplina.getText();
            String comp_Curric = this.comp_Curricular.getSelectedItem().toString();

            this.novaDisc.setCodigo(cod);
            this.novaDisc.setNome(disc);
            this.novaDisc.setCompCurric(comp_Curric);
            this.novaDisc.setModelo(true);

            if (!this.atualizar) {//se não for atualizar
                if (dd.verDuplicidade(this.novaDisc)) {
                    persistir(dd);
                } else {
                    JOptionPane.showMessageDialog(null, "Disciplina já cadastrada.");
                }
            } else {//se for atualizar só persistir
                persistir(dd);
            }
        } else {
            JOptionPane.showMessageDialog(null, not);
        }
    }//GEN-LAST:event_insere_DisciplinaActionPerformed

    private void persistir(Dao_Disciplina dd) {
        try {
            Transaction tr = this.sessao.beginTransaction();
            dd.persist(this.novaDisc, this.sessao);
            tr.commit();
            JOptionPane.showMessageDialog(null, "Disciplina inserida com sucesso!");
            removeLinhasTabela();
            carregarTabela();
            limpaCampos();
            this.código.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar Disciplina.");
            Logger.getLogger(Cadastrar_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarTabela() {
        List<Disciplinas> list = new Dao_Disciplina().getModelos();
        if (list != null) {
            DefaultTableModel model;
            for (Iterator<Disciplinas> it = list.iterator(); it.hasNext();) {
                Disciplinas d = it.next();

                model = (DefaultTableModel) this.tabela_Grade.getModel();

                model.addRow(new Object[]{
                    d.getCodigo(),
                    d.getNome(),
                    d.getCompCurric()
                });
            }
        }
    }

    private void removeLinhasTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();
        int linhas = this.tabela_Grade.getRowCount();

        for (int i = 0; i < linhas; i++) {
            model.removeRow(0);
        }
    }

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void insere_DisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insere_DisciplinaKeyReleased
        insere_DisciplinaActionPerformed(null);
    }//GEN-LAST:event_insere_DisciplinaKeyReleased
    int x = 0, y = 0;//coordenadas para mostrar o menu popup na linha selecionada com botão direito
    private void tabela_GradeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_GradeMouseReleased
        if (evt.getButton() == 1) {
            x = evt.getX();
            y = evt.getY();
        } else if (this.tabela_Grade.getSelectedRow() != -1 & evt.getButton() == 3) {
            this.menuPopup.show(this.tabela_Grade, x, y);
        }
    }//GEN-LAST:event_tabela_GradeMouseReleased

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed

        int linha = this.tabela_Grade.getSelectedRow();
        String cod = (String) this.tabela_Grade.getValueAt(linha, 0);
        String nome = (String) this.tabela_Grade.getValueAt(linha, 1);
        String bnc = (String) this.tabela_Grade.getValueAt(linha, 2);

        this.código.setText(cod);
        this.disciplina.setText(nome);
        this.comp_Curricular.setSelectedItem(bnc);

        Disciplinas retorno = new Dao_Disciplina().getPorCodigo(cod, this.sessao);
        if (retorno != null) {
            this.novaDisc = retorno;
            this.atualizar = true;
            DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
            d.removeRow(linha);
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
//        int linha = this.tabela_Grade.getSelectedRow();
//
//        DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
//        Dao_Disciplina dd = new Dao_Disciplina();
//        int id = Integer.parseInt(this.tabela_Grade.getValueAt(linha, 0).toString());
//        boolean ret = dd.exclusaoDisciplina(id);
//        if (ret) {
//            try {
//                dd.deletePorId(id);
//                JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso.");
//                d.removeRow(linha);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Erro ao tentar exclur Disciplina.");
//                Logger.getLogger(Cadastrar_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void limpaCampos() {
        this.código.setText(null);
        this.disciplina.setText(null);
        this.comp_Curricular.setSelectedIndex(0);
    }

    private StringBuilder verificaCampos() {
        String d = this.código.getText();
        String s = this.disciplina.getText();
        Object sItem = this.comp_Curricular.getSelectedItem();
        StringBuilder not = new StringBuilder();
        if (d.equals("") || d.equals(" ")) {
            not.append("Informe o Código da Disciplina!\n");
        }
        if (s.equals("") || s.equals(" ")) {
            not.append("Informe o Nome da Disciplina!");
        }
        if (sItem == null) {
            not.append("Selecione a Complementação Curricular!");
        }
        return not;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Excluir;
    private javax.swing.JComboBox comp_Curricular;
    private javax.swing.JTextField código;
    private javax.swing.JTextField disciplina;
    private javax.swing.JButton insere_Disciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela_Grade;
    // End of variables declaration//GEN-END:variables
}
