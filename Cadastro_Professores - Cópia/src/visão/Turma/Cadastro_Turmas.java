/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Turma;

import Conexao.Hibernate_Sessao;
import Controller.Controller_Turma;
import visão.Disciplina.*;
import Dao.Dao_Entidades.Dao_Curso;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Cursos;
import Entidades.Turmas;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Curso.Novo_Curso;

public class Cadastro_Turmas extends javax.swing.JDialog {

    private HashMap cursos = new HashMap();
//    private List<Turmas> turmas = new ArrayList();
    private Cursos cursoSelecionado;
    private Turmas turmaNova;
    private boolean editar;

    public Cadastro_Turmas() {
        initComponents();
        super.setModal(true);
        this.setTitle("Grade Curricular");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        carregarComboCurso();
        this.insere_Disciplina.setEnabled(false);
        this.editar = false;
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
        serie = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        seriacao = new javax.swing.JComboBox();
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
                "Id", "Série", "Seriação"
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
        jLabel4.setText("TURMAS DO CURSO");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Obs: Selecione a grade e clique com botão direito do mouse para Editá-la ou Excluí-la.");

        jLabel8.setText("Curso*:");

        jLabel9.setText("Série*:");

        curso.setToolTipText("Curso da Turma");
        curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoActionPerformed(evt);
            }
        });

        serie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        serie.setToolTipText("Série da Turma");
        serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serieActionPerformed(evt);
            }
        });

        jLabel2.setText("Seriação*:");

        seriacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Z" }));
        seriacao.setToolTipText("Seriação da Turma");
        seriacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seriacaoActionPerformed(evt);
            }
        });

        insere_Disciplina.setBackground(new java.awt.Color(0, 204, 51));
        insere_Disciplina.setText("Adicionar");
        insere_Disciplina.setToolTipText("Salvar Turma");
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4)
                                .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)
                                .addComponent(serie, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(seriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(insere_Disciplina)))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insere_Disciplina))))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarComboCurso() {
        Dao_Curso dc = new Dao_Curso();
        List<Cursos> list = dc.list();
        if (list.isEmpty()) {
            int op = JOptionPane.showConfirmDialog(null, "Não há Cursos Cadastrados.\n", "Confirmação", 0);
            if (op == 0) {
                new Novo_Curso().setVisible(true);
                carregarComboCurso();
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
        int se = Integer.parseInt(this.serie.getSelectedItem().toString());
        Object ser = this.seriacao.getSelectedItem();
        for (int i = 0; i < linhas; i++) {
            int serieTab = Integer.parseInt(this.tabela_Grade.getValueAt(i, 1).toString());
            String seriacaoTab = (String) this.tabela_Grade.getValueAt(i, 2);

            if (se == serieTab & ser.equals(seriacaoTab)) {
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
        this.editar = true;
        int linha = this.tabela_Grade.getSelectedRow();
        String se = this.tabela_Grade.getValueAt(linha, 1).toString();
        Object ser = this.tabela_Grade.getValueAt(linha, 2);

        this.serie.setSelectedItem(se);
        this.seriacao.setSelectedItem(ser);
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        int linha = this.tabela_Grade.getSelectedRow();
        int idTurmaTabela = Integer.parseInt(this.tabela_Grade.getValueAt(linha, 0).toString());

//        int idCurso = this.cursoSelecionado.getId();

        Dao_Turma dt = new Dao_Turma();
        boolean retorno = dt.verDependencias(idTurmaTabela);

        if (!retorno) {
            //se existir disciplina suprida na turma, impedir exclusão
            JOptionPane.showMessageDialog(null, "A Turma não pode ser excluída, pois a mesma possui Disciplinas supridas");
        } else {

            Session sessao = Hibernate_Sessao.getInstance().retornaSession();
            Transaction tr = sessao.beginTransaction();
            try {
                new Dao_Disciplina().removerIdTurma(idTurmaTabela, sessao);
                new Dao_Turma().deletaPorId(idTurmaTabela, sessao);
                tr.commit();
                JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
                recarregarTabela();
            } catch (HibernateException | HeadlessException ex) {
                tr.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir Turma \n" + ex.getCause());
            }
        }
    }//GEN-LAST:event_ExcluirActionPerformed

//    private void removeLinha(int linha) {
//        DefaultTableModel d = (DefaultTableModel) this.tabela_Grade.getModel();
//        d.removeRow(linha);
//    }

    private void insere_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_DisciplinaActionPerformed
        // TODO add your handling code here:
        StringBuilder ver = verificaCampos();
        if (ver.length() == 0) {
            //se não for editar criar nova disciplina
            if (!this.editar) {
                this.turmaNova = new Turmas();
            }
            this.turmaNova.setSerie(Integer.parseInt(this.serie.getSelectedItem().toString()));
            this.turmaNova.setSeriacao(this.seriacao.getSelectedItem().toString());

            Dao_Turma dt = new Dao_Turma();

//            if (dd.getDisciplinaTurmaId(disciplinaSelecionada)) {
            try {
                this.turmaNova.setCurso(cursoSelecionado);
                dt.persist(this.turmaNova);
                insereTurmaTabela(this.turmaNova);
                JOptionPane.showMessageDialog(null, "Turma adicionada com sucesso!");
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
            this.insere_Disciplina.setEnabled(true);
            removeLinhasTabela();
            //pegar turmas do curso selecionado
            List<Turmas> turm = new Dao_Turma().getTurmasIdCurso(c.getId());

//            if (turm.isEmpty()) {//se não existir turmas para o curso dar opção de adicionar
//
//                int op = JOptionPane.showConfirmDialog(null, "Não há Turmas para este curso!\nDeseja Cadastrar?");
//
//                if (op == 0) {
//                    new Inserir_Turma().setVisible(true);
//                    cursoActionPerformed(evt);
//                }
//            } else {//ser houver turmas no curso adicionar na tabela

            for (Turmas t : turm) {
                insereTurmaTabela(t);
            }

            this.cursoSelecionado = c;
//            }
        }
    }//GEN-LAST:event_cursoActionPerformed

    private void recarregarTabela() {
        List<Turmas> turm = new Dao_Turma().getTurmasIdCurso(this.cursoSelecionado.getId());
        removeLinhasTabela();
        for (Turmas t : turm) {
            insereTurmaTabela(t);
        }
    }

    private void serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serieActionPerformed
        // TODO add your handling code here:
        if (this.serie.getSelectedIndex() > 0) {
        }
    }//GEN-LAST:event_serieActionPerformed

    private void seriacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seriacaoActionPerformed
        // TODO add your handling code here:
        if (this.seriacao.getSelectedIndex() > 0) {
        }
    }//GEN-LAST:event_seriacaoActionPerformed

    private void insereTurmaTabela(Turmas c) {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Grade.getModel();
        this.tabela_Grade.getRowCount();
        model.addRow(new Object[]{
            c.getId(),
            c.getSerie(),
            c.getSeriacao()
        });
    }

    private void limpaCampos() {
//        this.turma.setSelectedIndex(0);
        this.seriacao.setSelectedIndex(0);
        this.serie.setSelectedIndex(0);
    }

    private StringBuilder verificaCampos() {

        String d = this.curso.getSelectedItem().toString();
        String s = this.serie.getSelectedItem().toString();
        String dis = this.seriacao.getSelectedItem().toString();
        StringBuilder not = new StringBuilder();
        if (d.equals("") || d.equals(" ")) {
            not.append("Selecione o Curso!\n");
        }
        if (s.equals("") || s.equals(" ")) {
            not.append("Selecione a Série!\n");
        }
        if (dis.equals("") || dis.equals(" ")) {
            not.append("Selecione uma Seriação!\n");
        }
        if (!verificaDuplicidade()) {
            not.append("A Turma já está inserida!\n");
        }

        return not;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Excluir;
    private javax.swing.JComboBox curso;
    private javax.swing.JButton insere_Disciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JComboBox seriacao;
    private javax.swing.JComboBox serie;
    private javax.swing.JTable tabela_Grade;
    // End of variables declaration//GEN-END:variables
}
