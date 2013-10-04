package visão.Afastamento;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Afastamento;
import Entidades.Afastament;
import Entidades.Disciplinas;
import Entidades.Professora;
import Validações.DataDoSistema;
import Validações.Valida_Datas;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Professor.Consulta_Prof;

/**
 *
 * @author Meus Documentos
 */
public class Novo_Afastamento extends javax.swing.JDialog {

    private Professora professor;
    private Session sessao;
    private Afastament afastamento;
    private boolean alterar;

    public Novo_Afastamento() {
        this.alterar = false;
        this.setTitle("Inserir Afastamento de Professor");
        this.sessao = Hibernate_Sessao.getInstance().retornaSession();
        this.afastamento = new Afastament();
        auxConstrutor();
        flag(false);
    }

    private void auxConstrutor() {
        initComponents();
        super.setModal(true);
        super.setTitle("Afastamento");
        configuraTabela();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public Novo_Afastamento(Afastament a, Session sessão) {
        this.alterar = true;
        this.afastamento = a;
        this.professor = a.getAfastado();
        this.sessao = sessão;
        auxConstrutor();

        atualizar();
    }

    private void atualizar() {
        preencheTabela(true);

        this.inicioAfastamento.setText(this.afastamento.getInicio());
        this.fimAfastamento.setText(this.afastamento.getFim());
        this.motivo.setSelectedItem(this.afastamento.getMotivo());
    }

    //
    public void setProfessor(Professora professor) {
        this.professor = professor;
        if (professor != null) {
            preencheTabela(false);
            flag(true);
        }
    }

    private void preencheTabela(Boolean afasta) {
        this.afastado.setText(this.professor.getNome());

        DefaultTableModel model = (DefaultTableModel) this.tabelaDisciplinas.getModel();

        List<Disciplinas> s = null;
        if (!this.alterar) {
            s = this.professor.getDisciplinas();

        } else if (this.alterar) {
            s = this.afastamento.getDisciplinas();
        }

        if (!(s.isEmpty())) {
            for (Disciplinas n : s) {
                model.addRow(new Object[]{
                    n.getId(),
                    n.getCodigo() + " " + n.getNome(),
                    n.getTurma().getSerie(),
                    n.getTurma().getSeriacao(),
                    n.getTurma().getCurso().getNome(),
                    afasta});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Professor não possui Disciplinas para Afastar");
        }
    }

    private void flag(Boolean f) {
        this.inserir.setEnabled(f);
        this.inicioAfastamento.setEnabled(f);
        this.fimAfastamento.setEnabled(f);
        this.motivo.setEnabled(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inserir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        inicioAfastamento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        fimAfastamento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplinas = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        afastado = new javax.swing.JLabel();
        motivo = new javax.swing.JComboBox();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AFASTAMENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        inserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        inserir.setText("Salvar");
        inserir.setToolTipText("Salvar os dados");
        inserir.setMargin(new java.awt.Insets(2, 2, 2, 2));
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });
        getContentPane().add(inserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 391, 97, 33));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Início do Afastamento*:");

        try {
            inicioAfastamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Fim do Afastamento*:");

        try {
            fimAfastamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Motivo*:");

        jLabel6.setText("Afastado:");

        tabelaDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Disciplina", "Série", "Turma", "Ensino", "Afastar"
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
        jScrollPane1.setViewportView(tabelaDisciplinas);

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar...");
        buscar.setToolTipText("Buscar Professor Afastado");
        buscar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        afastado.setBackground(new java.awt.Color(255, 255, 255));
        afastado.setText(" ");
        afastado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        afastado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                afastadoKeyReleased(evt);
            }
        });

        motivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Licença Médica", "Licença Maternidade", "Licença Especial", "Outro" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inicioAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fimAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motivo, 0, 206, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(afastado, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(afastado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inicioAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fimAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, -1, -1));

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair desta tela");
        cancelar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 391, 95, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        Consulta_Prof consulta = new Consulta_Prof(this, this.sessao);
        consulta.setVisible(true);
    }//GEN-LAST:event_buscarActionPerformed
    
    private boolean movimentaDisciplina() {

        for (int i = 0; i < this.tabelaDisciplinas.getRowCount(); i++) {
            if (this.tabelaDisciplinas.getValueAt(i, 5) == true & !this.alterar) {
                //verificar a disciplina selecionada
                Disciplinas d = procuraDisciplina(this.tabelaDisciplinas.getValueAt(i, 0));
                //remover a disciplina do professor
                this.professor.getDisciplinas().remove(d);
                this.afastamento.setDisciplina(d);
            } else if (this.alterar) {
                Disciplinas d = procuraDisciplina(this.tabelaDisciplinas.getValueAt(i, 0));
                this.professor.setDisciplina(d);
                this.afastamento.getDisciplinas().remove(d);
            }
        }
        return true;
    }

    private Disciplinas procuraDisciplina(Object id) {
        List<Disciplinas> aux;
        if (!this.alterar) {
            aux = this.professor.getDisciplinas();
        } else {
            aux = this.afastamento.getDisciplinas();
        }

        for (Disciplinas d : aux) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    private StringBuilder validaCampos() {
        Valida_Datas vd = new Valida_Datas();
        StringBuilder notificacao = new StringBuilder();

        String dataInicio = this.inicioAfastamento.getText().replaceAll("/", "");
        String dataFim = this.fimAfastamento.getText().replaceAll("/", "");
        String afast = this.afastado.getText();
        String mo = this.motivo.getSelectedItem().toString();

        if (!vd.validações(dataInicio)) {
            JOptionPane.showMessageDialog(null, "data inicio invalica");
            notificacao.append("Data de Início inválida.\n");
        }
        if (!vd.validações(dataFim)) {
            JOptionPane.showMessageDialog(null, "data fim invalica");
            notificacao.append("Data de Fim inválida.\n");
        }
        if (afast.equals("")||afast.equals(" ")) {
            JOptionPane.showMessageDialog(null, "professor vazio");
            notificacao.append("Busque um Professor.\n");
        }
        if (mo.equals(" ") || mo.equals("")) {
            JOptionPane.showMessageDialog(null, "motivo vazio");
            notificacao.append("Informe o motivo do Afastamento.\n");
        }

        return notificacao;
    }

    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed
        // TODO add your handling code here:
        Dao_Afastamento dp = new Dao_Afastamento();
        StringBuilder not = validaCampos();
        if (not.length()==0) {
            afastamento.setDataAfas(new DataDoSistema().getDataAtual());
            afastamento.setInicio(this.inicioAfastamento.getText().replaceAll("/", ""));
            afastamento.setFim(this.fimAfastamento.getText().replaceAll("/", ""));
            afastamento.setMotivo(this.motivo.getSelectedItem().toString());
            if (movimentaDisciplina()) {
                
                if (!this.alterar) {
                    this.afastamento.setAfastado(this.professor);
                }
                Transaction tr = this.sessao.beginTransaction();
                try {
                    dp.persist(this.afastamento, this.sessao);
                    tr.commit();
                    excluiLinhas();
                    limpaCampos();
                    preencheTabela(false);
                    confirma_NovoAfastamento();
                } catch (Exception ex) {
                    Logger.getLogger(Novo_Afastamento.class.getName()).log(Level.SEVERE, null, ex);
                    this.sessao.beginTransaction().rollback();
                    System.out.println("Erro ao gravar alteração");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Notificacão "+not);
        }
    }//GEN-LAST:event_inserirActionPerformed

    private void confirma_NovoAfastamento() {
        int opção = JOptionPane.showConfirmDialog(null, "Afastamento Inserido!\nDeseja realizar novo Afastamento?", "Confirmação", 0);
        if (opção == 0) {
            limpaCampos();
        } else {//fecha se o usuário não quiser realizar novo cancelamento
            this.dispose();
        }
    }

    private void afastadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_afastadoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyChar() == 10) {
            buscarActionPerformed(null);
        }
    }//GEN-LAST:event_afastadoKeyReleased

    private void configuraTabela() {
        TableColumnModel model = this.tabelaDisciplinas.getColumnModel();
        model.getColumn(0).setMinWidth(100);
        model.getColumn(1).setMinWidth(250);
        model.getColumn(2).setMinWidth(80);
        model.getColumn(3).setMinWidth(80);
        model.getColumn(4).setMinWidth(150);
        model.getColumn(5).setMinWidth(50);
    }

    private void limpaCampos() {
        this.afastado.setText(null);
        this.tabelaDisciplinas.removeAll();
        this.inicioAfastamento.setText(null);
        this.fimAfastamento.setText(null);
        this.motivo.setSelectedIndex(0);
    }

    private void excluiLinhas() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaDisciplinas.getModel();

        int linhas = this.tabelaDisciplinas.getRowCount();

        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
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
//            java.util.logging.Logger.getLogger(Novo_Afastamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Novo_Afastamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Novo_Afastamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Novo_Afastamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Novo_Afastamento().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel afastado;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField fimAfastamento;
    private javax.swing.JFormattedTextField inicioAfastamento;
    private javax.swing.JButton inserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox motivo;
    private javax.swing.JTable tabelaDisciplinas;
    // End of variables declaration//GEN-END:variables
}
