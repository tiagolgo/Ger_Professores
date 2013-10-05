/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Substituicao;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Afastamento;
import Dao.Dao_Entidades.Dao_Substituicao;
import Entidades.Afastament;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Substituica;
import Entidades.Turmas;
import Validações.DataDoSistema;
import Validações.Valida_Datas;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import visão.Afastamento.Novo_Afastamento;
import visão.Ajuda.Ajuda_Substituicao;
import visão.Professor.Consulta_Prof;

public class Nova_Substituição extends javax.swing.JDialog {

    private Afastament afastamento;
    private Professora substituto;
    private Session sessão;
//    private List<Disciplinas> disciplinas;
    private Substituica substituicao;
    private HashMap afastados = new HashMap();

    public Nova_Substituição() {
        super.setTitle("Nova Substituição");
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        this.substituicao = new Substituica();
//        this.disciplinas=new ArrayList();
        aux_Substituicao();
        carregaComboProfessores();
    }

//    public static void main(String[] args) {
//        new Nova_Substituição().setVisible(true);
//    }
    public Nova_Substituição(Substituica s, Session sessão) {
        super.setTitle("Alterar Substituição");
//        this.afastado = s.getAfastado();
        this.select_Afastado.setSelectedItem(s.getAfastamento().getAfastado().getNome());
        this.substituto = s.getSubstituto();
        this.nomeSubstituto.setText(this.substituto.getNome());

        carregaTabelaAfastado();
    }

    private void aux_Substituicao() {
        initComponents();
        super.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        inserir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inícioSubtituicao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        buscaSubstituto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Cancelado = new javax.swing.JTable();
        select_Afastado = new javax.swing.JComboBox();
        nomeSubstituto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SUBSTITUIÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inserir.setBackground(new java.awt.Color(0, 153, 0));
        inserir.setForeground(new java.awt.Color(255, 255, 255));
        inserir.setText("Salvar");
        inserir.setToolTipText("Salvar Substituição");
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Afastado:");

        jLabel8.setText("Início da Substituição:");

        try {
            inícioSubtituicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Substituto:");

        buscaSubstituto.setBackground(new java.awt.Color(0, 102, 204));
        buscaSubstituto.setForeground(new java.awt.Color(255, 255, 255));
        buscaSubstituto.setText("Buscar");
        buscaSubstituto.setToolTipText("Buscar Professor Substituto");
        buscaSubstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaSubstitutoActionPerformed(evt);
            }
        });

        tabela_Cancelado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Disciplina", "Turma", "Curso", "Opção"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_Cancelado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        select_Afastado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        select_Afastado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_AfastadoActionPerformed(evt);
            }
        });

        nomeSubstituto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("DISCIPLINAS DO AFASTADO");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(select_Afastado, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeSubstituto, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaSubstituto))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inícioSubtituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(select_Afastado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(nomeSubstituto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaSubstituto)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inícioSubtituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        cancelar.setBackground(new java.awt.Color(204, 102, 0));
        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair do Cadastro de Susbtituição");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Ajuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inserir)
                .addGap(18, 18, 18)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(inserir)
                    .addComponent(jButton1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setProfessor(Professora p) {
        if (this.select_Afastado.getSelectedIndex() != 0) {
            if (!this.select_Afastado.getSelectedItem().toString().equals(p.getNome())) {

                int confirm = JOptionPane.showConfirmDialog(null, "Confirma o Substituto:\n " + p.getNome(), "Confirmação de Substituto", 0);
                if (confirm == 0) {
                    this.substituto = p;
                    this.nomeSubstituto.setText(p.getNome());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Impossível a mesma pessoa Substituir-se!");
            }
        }
    }

    private void carregaTabelaAfastado() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Cancelado.getModel();
        boolean n = false;
        for (Disciplinas aux : this.afastamento.getDisciplinas()) {
            if (!aux.isSuprida()) {
                n = true;
                model.addRow(new Object[]{
                    aux.getId(),
                    aux.getCodigo(),
                    aux.getNome(),
                    aux.getTurma().getSerie(),
                    aux.getTurma().getCurso().getNome(),
                    false
                });
            }
        }
        if (!n) {
            JOptionPane.showMessageDialog(null, "Todas as Disciplinas deste Afastado foram Substituídas.");
        }
    }

    private void limparDados() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Cancelado.getModel();
        int linhas = this.tabela_Cancelado.getRowCount();

        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
        }
        this.select_Afastado.setSelectedIndex(0);
        this.nomeSubstituto.setText(null);
        this.inícioSubtituicao.setText(null);

    }

    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed
        // TODO add your handling code here:
        StringBuilder valida = validaCampos();

        if (valida.length() == 0) {

            boolean discSubstituicao = atribuirDisciplinasSelecionadas();

            if (discSubstituicao) {

                Dao_Substituicao ds = new Dao_Substituicao();

                this.substituicao.setDataSubs(new DataDoSistema().getDataAtual());
                this.substituicao.setInicio(this.inícioSubtituicao.getText());
                this.substituicao.setSubstituto(substituto);
                this.substituicao.setAfastamento(afastamento);

                try {
                    sessão.beginTransaction();
                    ds.persist(this.substituicao, this.sessão);
                    sessão.beginTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Substituição gravada com sucesso!");
                    limparDados();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar Substituição");
                    Logger.getLogger(Nova_Substituição.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma disciplina");
            }
        } else {
            JOptionPane.showMessageDialog(null, valida);
        }
    }//GEN-LAST:event_inserirActionPerformed

    private boolean atribuirDisciplinasSelecionadas() {
        int linhas = this.tabela_Cancelado.getRowCount();
        boolean op = false;
        for (int i = 0; i < linhas; i++) {
            Object select = this.tabela_Cancelado.getValueAt(i, 5);
            if (select == true) {
                for (Iterator<Disciplinas> it = this.afastamento.getDisciplinas().iterator(); it.hasNext();) {
                    Disciplinas d = it.next();
                    if (d.getId() == this.tabela_Cancelado.getValueAt(i, 0)) {
                        this.substituto.setDisciplina(d);
                        this.substituicao.setDisciplina(d);
                        d.setSuprida(true);
                        op = true;
                        break;
                    }
                }
            }
        }
        return op;
    }

    private StringBuilder validaCampos() {
        Valida_Datas vd = new Valida_Datas();
        String inicioSubst = this.inícioSubtituicao.getText().replaceAll("/", "");
        StringBuilder not = new StringBuilder();

        if (!vd.validações(inicioSubst)) {
            not.append("Data de Início inválida.\n");
        }
        if (this.nomeSubstituto.getText().equals("") || this.nomeSubstituto.getText().equals(" ")) {
            not.append("Substituto não selecionado.\n");
        }
        if (this.select_Afastado.getSelectedIndex() == 0) {
            not.append("Afastado não selecionado.\n");
        }
        return not;
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscaSubstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaSubstitutoActionPerformed
        // TODO add your handling code here:
        Consulta_Prof cp = new Consulta_Prof(this, this.sessão);
        cp.setVisible(true);
    }//GEN-LAST:event_buscaSubstitutoActionPerformed

    private void select_AfastadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_AfastadoActionPerformed
        // TODO add your handling code here:
        if (this.select_Afastado.getSelectedIndex() > 0) {
            this.afastamento = (Afastament) this.afastados.get(this.select_Afastado.getSelectedIndex());
            carregaTabelaAfastado();
        }
    }//GEN-LAST:event_select_AfastadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Ajuda_Substituicao().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void carregaComboProfessores() {
        Dao_Afastamento da = new Dao_Afastamento();
        List<Afastament> lp = da.list(this.sessão);

        if (!lp.isEmpty()) {
//            this.afastados;
            int i = 1;
            for (Afastament a : lp) {
                this.select_Afastado.addItem(a.getAfastado().getNome());
                this.afastados.put(i, a);
                i++;
            }
        } else {
            int op = JOptionPane.showConfirmDialog(null, "Não há Professor(es) Afastado(s).\nDeseja realizar novo afastamento?", "Confirmação", 0);
            if (op == 0) {
                new Novo_Afastamento().setVisible(true);
                carregaComboProfessores();
            }
        }
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
//            java.util.logging.Logger.getLogger(Nova_Substituição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Nova_Substituição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Nova_Substituição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Nova_Substituição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Nova_Substituição().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscaSubstituto;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton inserir;
    private javax.swing.JFormattedTextField inícioSubtituicao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomeSubstituto;
    private javax.swing.JComboBox select_Afastado;
    private javax.swing.JTable tabela_Cancelado;
    // End of variables declaration//GEN-END:variables
}
