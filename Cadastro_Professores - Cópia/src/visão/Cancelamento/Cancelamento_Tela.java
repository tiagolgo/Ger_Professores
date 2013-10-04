/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Cancelamento;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Disciplina;
import Dao.Dao_Entidades.Dao_Cancelamento;
import Entidades.Cancel;
import Entidades.Disciplinas;
import Entidades.Professora;
import Validações.Valida_Datas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Professor.Consulta_Prof;

/**
 *
 * @author Meus Documentos
 */
public class Cancelamento_Tela extends javax.swing.JDialog {

    private Professora cancelado;
    private Session sessão;
    private Cancel cancelamento;
    private boolean alterar;

    public Cancelamento_Tela() {
        this.alterar = false;
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        super.setTitle("Cancelamento de Professor");
        aux_Cancelamento();
        flag(false);
    }

    private void aux_Cancelamento() {
        initComponents();
        this.salvar.setText("Alterar");
        super.setModal(true);
        configuraTabela();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public Cancelamento_Tela(Cancel c, Session sessão) {
        this.alterar = true;
        super.setTitle("Alterar Cancelamento");
        this.cancelamento = c;
        this.sessão = sessão;
        this.cancelado = c.getProfessor();
//        this.buscar.setEnabled(false);

        aux_Cancelamento();
        preencheTabela();
        flag(true);
    }

    public void setProfessor(Professora prof) {
        this.cancelado = prof;
        preencheTabela();
        flag(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        professor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inscrição = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCancelamento = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 255, 255), null, null, new java.awt.Color(153, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CANCELAMENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 728, -1));

        jLabel2.setText("Professor(RG):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, -1, 26));

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        salvar.setText("Salvar");
        salvar.setToolTipText("Salvar os dados");
        salvar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        getContentPane().add(salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 513, 95, 33));

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair desta tela");
        cancelar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 513, 97, -1));

        jLabel5.setText("Data*:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 470, -1, -1));

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data.setText(" dd /mm /aaaa    ");
        getContentPane().add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 467, 75, -1));

        professor.setBackground(new java.awt.Color(102, 255, 102));
        getContentPane().add(professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 61, 387, 26));

        jLabel8.setText("Inscrição:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 470, -1, -1));
        getContentPane().add(inscrição, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 467, 86, -1));

        tabelaCancelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Disciplina", "Série", "Curso", "Turno", "CH", "Cancelar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCancelamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaCancelamento.setIntercellSpacing(new java.awt.Dimension(2, 2));
        tabelaCancelamento.setRowHeight(20);
        jScrollPane2.setViewportView(tabelaCancelamento);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 708, 296));

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Atenção: Selecione as disciplinas a serem canceladas.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.setToolTipText("Buscar Professor a ser Cancelado");
        buscar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 61, -1, 26));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("DISCIPLINAS DO PROFESSOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, 708, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //

    private void preencheTabela() {//preencher a tabela com os dados do professor

        if (!this.cancelado.getDisciplinas().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) this.tabelaCancelamento.getModel();

            this.professor.setText(this.cancelado.getNome());

            for (Disciplinas d : this.cancelado.getDisciplinas()) {
                model.addRow(new Object[]{
                    d.getId(),
                    d.getCodigo() + "-" + d.getNome(),
                    d.getTurma().getSerie() + d.getTurma().getSeriacao(),
                    d.getTurma().getCurso().getNome(),
                    d.getTurma().getCurso().getTurno(),
                    d.getCargaHoraria(),
                    false
                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Professor não possui disciplinas a serem Canceladas!");
        }
    }
    //
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void flag(Boolean f){
        this.data.setEditable(f);
        this.inscrição.setEditable(f);
        this.salvar.setEnabled(f);
    }
    
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Consulta_Prof prof = new Consulta_Prof(this, this.sessão);
        prof.setVisible(true);

    }//GEN-LAST:event_buscarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        if (!this.alterar) {
            this.cancelamento = new Cancel();
        }
        StringBuilder ret = verificações();

        if (ret.length() == 0) {
            if (cancelaDisciplinas()) {

                this.cancelamento.setProfessor(cancelado);
                this.cancelamento.setDataCancel(this.data.getText());

                Dao_Cancelamento dc = new Dao_Cancelamento();

                try {
                    Transaction beginTransaction = this.sessão.beginTransaction();
                    dc.persist(this.cancelamento, this.sessão);
                    beginTransaction.commit();
                    pergunta();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar Cancelamento.");
                    this.sessão.beginTransaction().rollback();
                    Logger.getLogger(Cancelamento_Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, ret);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private boolean cancelaDisciplinas() {
        boolean retorno = false;
        int linhas = this.tabelaCancelamento.getRowCount();
        for (int i = 0; i < linhas; i++) {
            if (this.tabelaCancelamento.getValueAt(i, 6) == true) {
                int size = this.cancelado.getDisciplinas().size();
                for (int j = 0, p = 0; j < this.cancelado.getDisciplinas().size(); j++) {
                    Disciplinas get = this.cancelado.getDisciplinas().get(p);
                    if (this.tabelaCancelamento.getValueAt(i, 0) == get.getId()) {
                        get.setSuprida(false);
                        this.cancelamento.setDisciplina(get);
                        this.cancelado.getDisciplinas().remove(get);
                        retorno = true;
                    } else {
                        p++;
                    }
                }
            }
        }
        return retorno;
    }

    private StringBuilder verificações() {
        Valida_Datas vd = new Valida_Datas();

        StringBuilder not = new StringBuilder();
        String dat = this.data.getText().replaceAll("/", "");
        String prof = this.professor.getText();

        try {
            Integer.parseInt(dat);
            if (vd.validações(dat)) {
                not.append("Data Inválida.\n");
            }
        } catch (Exception e) {
            not.append("Data inválida!");
        }

        if (vd.validações(prof)) {
            not.append("Selecione um Professor.\n");
        }
        if (this.alterar) {
            StringBuilder ret = new Controller_Disciplina().verificaSeSuprida(this.cancelamento.getDisciplinas());
            not.append(ret);
        }

        return not;
    }

    private void removerLinhas() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaCancelamento.getModel();
        int linhas = this.tabelaCancelamento.getRowCount();
        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
        }
    }

    private void configuraTabela() {
        TableColumnModel cm = this.tabelaCancelamento.getColumnModel();
        cm.getColumn(0).setMinWidth(60);
        cm.getColumn(1).setMinWidth(250);
        cm.getColumn(2).setMinWidth(100);
        cm.getColumn(3).setMinWidth(110);
        cm.getColumn(4).setMinWidth(110);
        cm.getColumn(5).setMinWidth(80);
    }

    private void limparCampos() {
        this.professor.setText(null);
        this.data.setText(null);
        this.inscrição.setText(null);
        this.tabelaCancelamento.removeAll();
        this.cancelado = null;
        this.cancelamento=null;
    }

    private void pergunta() {
        int opção = JOptionPane.showConfirmDialog(null, "Cancelamento Confirmado!\nDeseja realizar novo Cancelamento?", "Confirmação", 0);
        if (opção == 0) {
            limparCampos();
            removerLinhas();
            flag(false);
        } else {//fecha se o usuário não quiser realizar novo cancelamento
            this.dispose();
        }
    }

//    public static void main(String[] args) {
//        new Cancelamento_Tela().setVisible(true);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField inscrição;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel professor;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabelaCancelamento;
    // End of variables declaration//GEN-END:variables
}
