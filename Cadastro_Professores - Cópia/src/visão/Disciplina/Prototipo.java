/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Disciplina;

import visão.Turma.*;
import Conexao.Hibernate_Sessao;
import Controller.Controller_Disciplina;
import Controller.Controller_Turma;
import Dao.Dao_Entidades.Dao_Curso;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Cursos;
import Entidades.Disciplinas;
import Entidades.Turmas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Session;

public class Prototipo extends javax.swing.JDialog {

    private HashMap cursos = new HashMap();
    private Cursos ensino;
    private HashMap turmas = new HashMap();
    private Turmas turmaSelecionada;
    private List<Disciplinas> disciplinas;

//    public static void main(String[] args) {
//        new Prototipo().setVisible(true);
//    }

    public Prototipo() {
        initComponents();
        super.setModal(true);
        this.setTitle("Cadastro de Turmas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        carregarComboCurso();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Grade = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        curso = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        turma = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_DisciplinasTurma = new javax.swing.JTable();
        addDisciplina = new javax.swing.JButton();
        removeDisciplina = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ATRIBUIR DISCIPLINA À TURMA");

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
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_Grade.setAutoCreateRowSorter(true);
        tabela_Grade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Grade.setRowHeight(20);
        tabela_Grade.setRowMargin(2);
        tabela_Grade.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabela_Grade);

        sair.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        sair.setText("Sair");
        sair.setToolTipText("Sair");
        sair.setMargin(new java.awt.Insets(2, 2, 2, 14));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setAutoscrolls(true);
        jLabel6.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(31, 31, 31))
        );

        Salvar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        Salvar.setText("Salvar");
        Salvar.setToolTipText("Salvar as Turmas");
        Salvar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        jLabel8.setText("Curso*:");

        curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoActionPerformed(evt);
            }
        });

        jLabel9.setText("Turma:");

        turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmaActionPerformed(evt);
            }
        });

        tabela_DisciplinasTurma.setAutoCreateRowSorter(true);
        tabela_DisciplinasTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_DisciplinasTurma.setRowHeight(20);
        tabela_DisciplinasTurma.setRowMargin(2);
        tabela_DisciplinasTurma.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(tabela_DisciplinasTurma);

        addDisciplina.setBackground(new java.awt.Color(102, 255, 102));
        addDisciplina.setText(">>");
        addDisciplina.setToolTipText("Adicionar Disicplina na Turma");
        addDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDisciplinaActionPerformed(evt);
            }
        });

        removeDisciplina.setBackground(new java.awt.Color(255, 51, 51));
        removeDisciplina.setText("<<");
        removeDisciplina.setToolTipText("Remover Disciplina");
        removeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDisciplinaActionPerformed(evt);
            }
        });

        jLabel2.setText("Disciplinas Cadastradas");

        jLabel3.setText("Disciplinas da Turma");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(Salvar)
                                .addGap(18, 18, 18)
                                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4)
                                .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addDisciplina)
                                    .addComponent(removeDisciplina)))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 205, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(addDisciplina)
                        .addGap(39, 39, 39)
                        .addComponent(removeDisciplina))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sair)
                    .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarComboCurso() {
        Dao_Curso dc = new Dao_Curso();
        List<Cursos> list = dc.list();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Cursos Cadastrados.\n");
        } else {
            int i = 0;

//            this.curso.addItem(null);
            for (Iterator<Cursos> it = list.iterator(); it.hasNext();) {
                Cursos curs = it.next();
                this.cursos.put(i, curs);
                this.curso.addItem(curs.getNome() + " - " + curs.getTurno());
                i++;
            }
        }
    }

    private void carregaTabela() {
        List<Disciplinas> aux = new Dao_Disciplina().list();
        this.disciplinas = aux;
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();

        if (aux.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Não há Disciplinas Cadastradas.");
        } else {
            for (Disciplinas d : aux) {
                model.addRow(new Object[]{
                    d.getId(),
                    d.getCodigo(),
                    d.getNome()
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

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        StringBuilder ver = verificações();
        if (ver.length() == 0) {
            if (confirmação()) {
//                Session sessao = Hibernate_Sessao.getInstance().retornaSession();

                Dao_Disciplina dd = new Dao_Disciplina();
                
                for (Disciplinas disci : disciplinas) {
                    if (pegarDisciplina(disci)) {
                        try {
                            dd.persist(disci);
//                            sessao.beginTransaction().commit();

                        } catch (Exception ex) {
                            Logger.getLogger(Prototipo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, ver);
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private boolean pegarDisciplina(Disciplinas d) {
        for (int i = 0; i < this.tabela_DisciplinasTurma.getRowCount(); i++) {
            if (d.getId() == this.tabela_DisciplinasTurma.getValueAt(i, 0)) {
                d.setTurma(turmaSelecionada);
                return true;
            }
        }
        return false;
    }

    private StringBuilder verificações() {
        StringBuilder noti = new StringBuilder();
        int linhas = this.tabela_DisciplinasTurma.getRowCount();
        boolean s = (this.turmaSelecionada == null);

        if (s) {
            noti.append("Selecione uma turma!\n");
        }
        if (linhas == 0) {
            noti.append("Adicione as Disciplinas!\n");
        }

        return noti;
    }

    private boolean confirmação() {
        int linhas = this.tabela_DisciplinasTurma.getRowCount();
        StringBuilder conf = new StringBuilder("Confirma a inserção das Disciplinas:\n");

        for (int i = 0; i < linhas; i++) {
            conf.append(this.tabela_DisciplinasTurma.getValueAt(i, 1)).append(" - ").append(this.tabela_DisciplinasTurma.getValueAt(i, 2)).append("\n");
        }
        conf.append("Na ").append(this.turmaSelecionada.getSerie()).append(this.turmaSelecionada.getSeriacao()).append("?");
        //solicita confirmação do usuário
        if (JOptionPane.showConfirmDialog(null, conf) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoActionPerformed
        // TODO add your handling code here:
        Cursos c = (Cursos) this.cursos.get(this.curso.getSelectedIndex());

        List<Turmas> turm = new Dao_Turma().getTurmasIdCurso(c.getId());
        if (turm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Turmas para este curso!");
        } else {
            int i = 0;
            for (Turmas t : turm) {
                this.turmas.put(i, t);
                this.turma.addItem(t.getSerie() + " " + t.getSeriacao());
                i++;
            }
        }
    }//GEN-LAST:event_cursoActionPerformed

    private void removeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDisciplinaActionPerformed
        // TODO add your handling code here:
        if (selecionouLinha(this.tabela_DisciplinasTurma)) {
            removeInsere(this.tabela_DisciplinasTurma, tabela_Grade);
        }
    }//GEN-LAST:event_removeDisciplinaActionPerformed

    private void addDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDisciplinaActionPerformed
        // TODO add your handling code here:
        if (selecionouLinha(this.tabela_Grade)) {
            removeInsere(tabela_Grade, this.tabela_DisciplinasTurma);
        }
    }//GEN-LAST:event_addDisciplinaActionPerformed

    private void turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmaActionPerformed
        // TODO add your handling code here:

        this.turmaSelecionada = (Turmas) this.turmas.get(this.turma.getSelectedIndex());

    }//GEN-LAST:event_turmaActionPerformed

    private void removeInsere(javax.swing.JTable selecionada, javax.swing.JTable destino) {
        int linha = selecionada.getSelectedRow();
        DefaultTableModel tab = (DefaultTableModel) destino.getModel();

        tab.addRow(new Object[]{
            selecionada.getValueAt(linha, 0),//id
            selecionada.getValueAt(linha, 1),//codigo
            selecionada.getValueAt(linha, 2)//nome
        });

        DefaultTableModel dest = (DefaultTableModel) selecionada.getModel();
        dest.removeRow(linha);
    }

    private boolean selecionouLinha(javax.swing.JTable tabela) {
        if (tabela.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Disciplina!");
            return false;
        }
        return true;
    }

    private void limpaCampos() {
        this.curso.setSelectedIndex(0);
        this.turma.setSelectedIndex(0);
    }

    private StringBuilder verificaCampos() {
        String d = this.curso.getSelectedItem().toString();
        String s = this.turma.getSelectedItem().toString();
        StringBuilder not = new StringBuilder();
        if (d.equals("") || d.equals(" ")) {
            not.append("Selecione o Curso!\n");
        }
        if (s.equals("") || s.equals(" ")) {
            not.append("Selecione a Turma!");
        }

        return not;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salvar;
    private javax.swing.JButton addDisciplina;
    private javax.swing.JComboBox curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeDisciplina;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela_DisciplinasTurma;
    private javax.swing.JTable tabela_Grade;
    private javax.swing.JComboBox turma;
    // End of variables declaration//GEN-END:variables
}
