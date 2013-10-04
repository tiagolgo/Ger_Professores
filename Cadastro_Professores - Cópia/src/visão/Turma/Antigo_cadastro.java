/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Turma;

import Dao.Dao_Entidades.Dao_Curso;
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

public class Antigo_cadastro extends javax.swing.JDialog {

    private HashMap cursos = new HashMap();
    private Cursos ensino;
    private ArrayList<Turmas> turmas = new ArrayList();
    private Turmas turmaSelecionada;
    private List<Disciplinas> disciplinas;

//    public static void main(String[] args) {
//        new Antigo_cadastro().setVisible(true);
//    }

    public Antigo_cadastro() {
        initComponents();
        super.setModal(true);
        this.setTitle("Cadastro de Turmas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        carregarComboCurso();
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
        jLabel7 = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        insere_Disciplina = new javax.swing.JButton();
        curso = new javax.swing.JComboBox();
        série = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        seriacao = new javax.swing.JComboBox();

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

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO DE TURMAS");

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
                "Curso", "Série", "Seriação"
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
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Obs: Selecione a grade e clique com botão direito do mouse para Editá-la ou Excluí-la.");

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

        jLabel9.setText("Série*:");

        insere_Disciplina.setBackground(new java.awt.Color(255, 255, 255));
        insere_Disciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        insere_Disciplina.setText("Adicionar");
        insere_Disciplina.setToolTipText("Adicionar Turma para cadastro");
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

        curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoActionPerformed(evt);
            }
        });

        série.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel2.setText("Seriação*:");

        seriacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salvar)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 209, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(série, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insere_Disciplina))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(insere_Disciplina)
                    .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(série, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(seriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarComboCurso() {
        Dao_Curso dc = new Dao_Curso();
        List<Cursos> list = dc.list();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Cursos Cadastrados.\n");
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
    }

    //adiciona preenche a tabela de disciplina
    private void insere_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_DisciplinaActionPerformed
        DefaultTableModel model;
        //verificar se há campos em branco
        StringBuilder not = verificaCampos();
        if (not.length() == 0) {
            String curs = this.curso.getSelectedItem().toString();
            String serie = this.série.getSelectedItem().toString();
            String seriaca = this.seriacao.getSelectedItem().toString();

            if (verificaDuplicidade(curs, serie, seriaca)) {

                novaTurma(serie, seriaca);//criar nova turma

                model = (DefaultTableModel) this.tabela_Grade.getModel();

                model.addRow(new Object[]{
                    curs,
                    serie,
                    seriaca
                });

                limpaCampos();
                this.curso.requestFocusInWindow();
            }
        } else {
            JOptionPane.showMessageDialog(null, not);
        }
    }//GEN-LAST:event_insere_DisciplinaActionPerformed

    private void removeLinhasTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();
        int linhas = this.tabela_Grade.getRowCount();

        for (int i = 0; i < linhas; i++) {
            model.removeRow(0);
        }
    }

    private boolean verificaDuplicidade(String curso, String serie, String seriacao) {
        int linhas = this.tabela_Grade.getRowCount();

        for (int i = 0; i < linhas; i++) {
            String item1 = (String) this.tabela_Grade.getValueAt(i, 0);
            String item2 = (String) this.tabela_Grade.getValueAt(i, 1);
            String item3 = (String) this.tabela_Grade.getValueAt(i, 2);

            if (curso.equals(item1) & serie.equals(item2) & seriacao.equals(item3)) {
                JOptionPane.showMessageDialog(null, "A Turma já está adicionada");
                return false;
            }
        }
        return true;
    }

    private boolean novaTurma(String serie, String seriacao) {
        Turmas aux = new Turmas();
        aux.setSerie(Integer.parseInt(serie));
        aux.setSeriacao(seriacao);
        aux.setCurso(ensino);
        this.turmas.add(aux);


        return true;
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
//        desmarcaTabela();
        int linha = this.tabela_Grade.getSelectedRow();
        String cod = (String) this.tabela_Grade.getValueAt(linha, 0);
        String nome = (String) this.tabela_Grade.getValueAt(linha, 1);
        String bnc = (String) this.tabela_Grade.getValueAt(linha, 2);
        this.curso.setSelectedItem(cod);
        this.série.setSelectedItem(nome);
        this.seriacao.setSelectedItem(bnc);

//        ExcluirActionPerformed(evt);

        DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
        d.removeRow(linha);
//        JOptionPane.showMessageDialog(null, this.tabela_Grade.getValueAt(linha,0));
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        int linha = this.tabela_Grade.getSelectedRow();
        int serie = Integer.parseInt(this.tabela_Grade.getValueAt(linha, 1).toString());
        Object seriaca = this.tabela_Grade.getValueAt(linha, 2);

        for (Turmas t : turmas) {
            if (t.getSerie() == serie & t.getSeriacao().equals(seriaca)) {
                this.turmas.remove(t);
                DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
                d.removeRow(linha);
            }
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        if (!this.turmas.isEmpty()) {
        
            StringBuilder not = new StringBuilder();

            Dao_Turma dt = new Dao_Turma();
            for (Turmas t : turmas) {
                if (dt.verDuplicidade(t)) {
                    try {
                        dt.persist(t);
                    } catch (Exception ex) {
                        Logger.getLogger(Antigo_cadastro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (not.length() == 0) {
                        not.append("Turmas já estão cadastradas:\n");
                    }
                    not.append(t.getSerie()).append(" - ").append(t.getSeriacao()).append(" - ").append(t.getCurso().getNome()).append("\n");
                }
            }

            if (not.length() != 0) {
                JOptionPane.showMessageDialog(null, not);
            } else {
                JOptionPane.showMessageDialog(null, "Disciplinas cadastradas com sucesso!");
            }
            limpaCampos();
            removeLinhasTabela();
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoActionPerformed
        // TODO add your handling code here:
        if (curso.getSelectedIndex() != 0) {
            this.ensino = (Cursos) this.cursos.get(this.curso.getSelectedIndex());
        }
    }//GEN-LAST:event_cursoActionPerformed

    private void limpaCampos() {
        this.curso.setSelectedIndex(0);
        this.seriacao.setSelectedIndex(0);
        this.série.setSelectedIndex(0);
    }

    private StringBuilder verificaCampos() {
        String d = this.curso.getSelectedItem().toString();
        String s = this.série.getSelectedItem().toString();
        String sItem = this.seriacao.getSelectedItem().toString();
        StringBuilder not = new StringBuilder();
        if (d.equals("") || d.equals(" ")) {
            not.append("Selecione o Curso!\n");
        }
        if (s.equals("") || s.equals(" ")) {
            not.append("Selecione a Turma!");
        }
        if (sItem == null) {
            not.append("Selecione a Seriação!");
        }
        return not;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Excluir;
    private javax.swing.JButton Salvar;
    private javax.swing.JComboBox curso;
    private javax.swing.JButton insere_Disciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JButton sair;
    private javax.swing.JComboBox seriacao;
    private javax.swing.JComboBox série;
    private javax.swing.JTable tabela_Grade;
    // End of variables declaration//GEN-END:variables
}
