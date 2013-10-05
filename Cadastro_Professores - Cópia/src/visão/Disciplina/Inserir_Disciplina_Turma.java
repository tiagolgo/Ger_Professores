/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Disciplina;

import visão.Turma.*;
import Dao.Dao_Entidades.Dao_Curso;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Cursos;
import Entidades.Disciplinas;
import Entidades.Turmas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import visão.Curso.Novo_Curso;

public class Inserir_Disciplina_Turma extends javax.swing.JDialog {

    private HashMap cursos = new HashMap();
    private HashMap hashDisciplinas = new HashMap();
    private HashMap turmas = new HashMap();
    private Turmas turmaSelecionada;
    private Disciplinas disciplinaSelecionada;

//    public static void main(String[] args) {
//        new Inserir_Disciplina_Turma().setVisible(true);
//    }
    public Inserir_Disciplina_Turma() {
        initComponents();
        super.setModal(true);
        this.setTitle("Grade Curricular");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        carregarComboCurso();
        carregarComboDisciplinas();
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
        sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        curso = new javax.swing.JComboBox();
        turma = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboDisciplinas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cargaHoraria = new javax.swing.JComboBox();
        insere_Disciplina = new javax.swing.JButton();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INSERÇÃO DE DISCIPLINA EM TURMA");

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
                "Id", "Código", "Disciplina", "Comp. Curricular", "CH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        sair.setBackground(new java.awt.Color(255, 153, 51));
        sair.setText("Sair");
        sair.setToolTipText("Sair desta tela");
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DISCIPLINAS DA TURMA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(14, 14, 14))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setText("Obs: Selecione a grade e clique com botão direito do mouse para Editá-la ou Excluí-la.");

        jLabel8.setText("Curso*:");

        jLabel9.setText("Turma*:");

        curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoActionPerformed(evt);
            }
        });

        turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmaActionPerformed(evt);
            }
        });

        jLabel2.setText("Disciplina*:");

        comboDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDisciplinasActionPerformed(evt);
            }
        });

        jLabel3.setText("Carga Horária*:");

        cargaHoraria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaHorariaActionPerformed(evt);
            }
        });

        insere_Disciplina.setBackground(new java.awt.Color(51, 102, 255));
        insere_Disciplina.setForeground(new java.awt.Color(255, 255, 255));
        insere_Disciplina.setText("Salvar");
        insere_Disciplina.setToolTipText("Salvar os dados");
        insere_Disciplina.setMargin(new java.awt.Insets(2, 2, 2, 2));
        insere_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_DisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insere_Disciplina, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insere_Disciplina))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarComboCurso() {
        Dao_Curso dc = new Dao_Curso();
        List<Cursos> list = dc.list();
        if (list.isEmpty()) {
            int op = JOptionPane.showConfirmDialog(null, "Não há Cursos Cadastrados.\nDeseja Cadastrar?", "Confirmação", 0);
            if (op == 0) {
                new Novo_Curso().setVisible(true);
                carregarComboCurso();
                carregarComboDisciplinas();
            }
        } else {
            int i = 1;
            this.curso.addItem("");
            for (Iterator<Cursos> it = list.iterator(); it.hasNext();) {
                Cursos curs = it.next();
                this.cursos.put(i, curs);
                this.curso.addItem(curs.getNome() + " - " + curs.getTurno());
                i++;
            }
        }
        flag();
    }

    private void carregarComboDisciplinas() {
        Dao_Disciplina dd = new Dao_Disciplina();
        List<Disciplinas> list = dd.list();
        if (list.isEmpty()) {
            int op = JOptionPane.showConfirmDialog(null, "Não há Disciplinas Cadastrados.\nDeseja Cadastrar?", "Confirmação", 0);
            if (op == 0) {
                new Cadastrar_Disciplina().setVisible(true);
                carregarComboDisciplinas();
            }
        } else {
            int i = 1;
            this.comboDisciplinas.addItem("");
            for (Iterator<Disciplinas> it = list.iterator(); it.hasNext();) {
                Disciplinas curs = it.next();
                this.comboDisciplinas.addItem(curs.getNome());
                this.hashDisciplinas.put(i, curs);
                i++;
            }
        }
    }

    private void removeLinhasTabela() {
        int linhas = this.tabela_Grade.getRowCount();
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();

        for (int i = 0; i < linhas; i++) {
            model.removeRow(0);
        }
    }

    private boolean verificaDuplicidade() {
        int linhas = this.tabela_Grade.getRowCount();
        Object disciplina = this.comboDisciplinas.getSelectedItem();
        for (int i = 0; i < linhas; i++) {
            String item3 = (String) this.tabela_Grade.getValueAt(i, 2);

            if (disciplina.equals(item3)) {
                return false;
            }
        }
        return true;
    }

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed
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
//        desmarcaTabela();
        int linha = this.tabela_Grade.getSelectedRow();

        String disc = (String) this.tabela_Grade.getValueAt(linha, 2);
        Object ch = this.tabela_Grade.getValueAt(linha, 4);

        this.comboDisciplinas.setSelectedItem(disc);
        this.cargaHoraria.setSelectedItem(ch);

    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        int linha = this.tabela_Grade.getSelectedRow();
        int idDisciplina = Integer.parseInt(this.tabela_Grade.getValueAt(linha, 0).toString());

        int idTurma = this.turmaSelecionada.getId();

        Collection<Disciplinas> values = this.hashDisciplinas.values();
        for (Disciplinas d : values) {
            if (d.getId() == idDisciplina) {
                if (d.getTurma().getId() == idTurma) {
                    if (d.isSuprida()) {
                        JOptionPane.showMessageDialog(null, "A Disciplina está suprida e não pode ser excluida!\nDisciplinas supridas não podem ser desvinculadas da Turma.");
                    } else {
                        try {
                            new Dao_Disciplina().deletePorCodigo(d.getCodigo());

                            JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso!");
                            removeLinha(linha);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir Disciplina!\n" + ex.getCause());
//                            Logger.getLogger(Inserir_Disciplina_Turma.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_ExcluirActionPerformed

    private void removeLinha(int linha) {
        DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
        d.removeRow(linha);
    }

    private void insere_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_DisciplinaActionPerformed
        // TODO add your handling code here:
        StringBuilder ver = verificaCampos();
        if (ver.length() == 0) {

            Dao_Disciplina dd = new Dao_Disciplina();

//            if (dd.getDisciplinaTurmaId(disciplinaSelecionada)) {
            try {
                dd.persist(this.disciplinaSelecionada);
                insereDisciplinaTabela(this.disciplinaSelecionada);
                JOptionPane.showMessageDialog(null, "Disciplina adicionada com sucesso!");
                limpaCampos();
            } catch (Exception ex) {
                Logger.getLogger(Prototipo.class.getName()).log(Level.SEVERE, null, ex);
            }
//            } else {
//                JOptionPane.showMessageDialog(null, "A Turma já possui esta Disciplina!");
//
//            }
        } else {
            JOptionPane.showMessageDialog(null, ver);
        }
    }//GEN-LAST:event_insere_DisciplinaActionPerformed

    private void cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoActionPerformed

        Cursos c = (Cursos) this.cursos.get(this.curso.getSelectedIndex());
        if (this.curso.getSelectedIndex() > 0) {
            this.turma.setEnabled(true);
            List<Turmas> turm = new Dao_Turma().getTurmasIdCurso(c.getId());
            if (turm.isEmpty()) {
                int op = JOptionPane.showConfirmDialog(null, "Não há Turmas para este curso!\nDeseja Cadastrar?");
                if (op == 0) {
                    this.dispose();
                    new Cadastro_Turmas().setVisible(true);
                }
            } else {
                removeLinhasTabela();
                this.turma.removeAllItems();
                int i = 1;
                this.turma.addItem(" ");
                for (Turmas t : turm) {
                    this.turmas.put(i, t);
                    this.turma.addItem(t.getSerie() + " " + t.getSeriacao());
                    i++;
                }
            }
        }
    }//GEN-LAST:event_cursoActionPerformed

    private void turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmaActionPerformed
        // TODO add your handling code here:
        Dao_Disciplina dd = new Dao_Disciplina();
        if (this.turma.getSelectedIndex() > 0) {
            this.comboDisciplinas.setEnabled(true);
            this.turmaSelecionada = (Turmas) this.turmas.get(this.turma.getSelectedIndex());
            removeLinhasTabela();

            List<Disciplinas> t = dd.getPorIdTurma(this.turmaSelecionada.getId());
            if (t != null) {
                for (Iterator<Disciplinas> it = t.iterator(); it.hasNext();) {
                    Disciplinas disci = it.next();
                    insereDisciplinaTabela(disci);
                }

            }
        }
    }//GEN-LAST:event_turmaActionPerformed

    private void comboDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDisciplinasActionPerformed
        // TODO add your handling code here:
        if (this.comboDisciplinas.getSelectedIndex() > 0) {
            this.cargaHoraria.setEnabled(true);
            Disciplinas d = (Disciplinas) this.hashDisciplinas.get(this.comboDisciplinas.getSelectedIndex());
            this.disciplinaSelecionada = new Disciplinas();
            this.disciplinaSelecionada.setCodigo(d.getCodigo());
            this.disciplinaSelecionada.setNome(d.getNome());
            this.disciplinaSelecionada.setCargaHoraria(d.getCargaHoraria());
            this.disciplinaSelecionada.setCompCurric(d.getCompCurric());
            this.disciplinaSelecionada.setTurma(turmaSelecionada);
        }
    }//GEN-LAST:event_comboDisciplinasActionPerformed

    private void cargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaHorariaActionPerformed
        // TODO add your handling code here:
        if (this.cargaHoraria.getSelectedIndex() > 0) {
            this.insere_Disciplina.setEnabled(true);
            this.disciplinaSelecionada.setCargaHoraria(Integer.parseInt(this.cargaHoraria.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cargaHorariaActionPerformed

    private void insereDisciplinaTabela(Disciplinas d) {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();
        this.tabela_Grade.getRowCount();

        model.addRow(new Object[]{
            d.getId(),
            d.getCodigo(),
            d.getNome(),
            d.getCompCurric(),
            d.getCargaHoraria()
        });
    }

    private void limpaCampos() {
//        this.turma.setSelectedIndex(0);
        this.comboDisciplinas.setSelectedIndex(0);
        this.cargaHoraria.setSelectedIndex(0);
    }

    private StringBuilder verificaCampos() {

        String d = this.curso.getSelectedItem().toString();
        String s = this.turma.getSelectedItem().toString();
        String dis = this.comboDisciplinas.getSelectedItem().toString();
        String ch = this.cargaHoraria.getSelectedItem().toString();
        StringBuilder not = new StringBuilder();
        if (d.equals("") || d.equals(" ")) {
            not.append("Selecione o Curso!\n");
        }
        if (s.equals("") || s.equals(" ")) {
            not.append("Selecione a Turma!\n");
        }
        if (dis.equals("") || dis.equals(" ")) {
            not.append("Selecione uma Disciplina!\n");
        }
        if (ch.equals("") || ch.equals(" ")) {
            not.append("Selecione a Carga Horária da Disciplina!\n");
        }
        if (!verificaDuplicidade()) {
            not.append("A Disciplina já está inserida!\n");
        }

        return not;
    }

    private void flag() {
        this.turma.setEnabled(false);
        this.comboDisciplinas.setEnabled(false);
        this.turma.setEnabled(false);
        this.cargaHoraria.setEnabled(false);
        this.insere_Disciplina.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Excluir;
    private javax.swing.JComboBox cargaHoraria;
    private javax.swing.JComboBox comboDisciplinas;
    private javax.swing.JComboBox curso;
    private javax.swing.JButton insere_Disciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela_Grade;
    private javax.swing.JComboBox turma;
    // End of variables declaration//GEN-END:variables
}
