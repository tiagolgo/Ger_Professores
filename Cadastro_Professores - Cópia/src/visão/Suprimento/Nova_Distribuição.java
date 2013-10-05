/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Suprimento;

import Conexao.Hibernate_Sessao;
import Conexao.JPA_FabricaSessao;
import Controller.Controller_Substituicao;
import Dao.Dao_Entidades.Dao_Curso;
import Dao.Dao_Entidades.Dao_Disciplina;
import Dao.Dao_Entidades.Dao_Suprimento;
import Dao.Dao_Entidades.Dao_Turma;
import Entidades.Cursos;
import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Suprim;
import Entidades.Turmas;
import visão.Professor.Consulta_Prof;
import Validações.DataDoSistema;
import Validações.Valida_Datas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visão.Ajuda.Ajuda_Suprimento;
import visão.Curso.Novo_Curso;
import visão.Disciplina.Cadastrar_Disciplina;
import visão.Disciplina.Inserir_Disciplina_Turma;
import visão.Turma.Cadastro_Turmas;

/**
 *
 * @author Meus Documentos
 */
public class Nova_Distribuição extends javax.swing.JDialog {

    private HashMap turmas = new HashMap();
    private HashMap cursos = new HashMap();
    private Professora professor;
    private List<Disciplinas> disc_Suprimento;
    private Session sessão;
    private EntityManager em = JPA_FabricaSessao.getEntityManager();
    private Suprim supri;
    private Turmas turmaSelecionada;
    private List<Disciplinas> disciplinas;

    public Nova_Distribuição() {
        initComponents();
        super.setModal(true);
        this.setTitle("Distribuição de Aula");
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        this.disc_Suprimento = new ArrayList();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarComboCurso();
        this.selectTurma.setEnabled(false);
        this.select_Curso.setEnabled(false);
    }

//    public static void main(String[] args) {
//        new Nova_Distribuição().setVisible(true);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Distribuição = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        inserir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        data_Início = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        nome_Professor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        select_Curso = new javax.swing.JComboBox();
        selectTurma = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("Grade");
        jPanel1.setName("Grade"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("ATRIBUIÇÃO DE DISCIPLINAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(209, 209, 209))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_Distribuição.setAutoCreateRowSorter(true);
        tabela_Distribuição.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Disciplina", "Comp. Curric.", "CH", "Atribuir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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
        tabela_Distribuição.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela_Distribuição.setRowHeight(25);
        jScrollPane1.setViewportView(tabela_Distribuição);

        cancelar.setBackground(new java.awt.Color(255, 153, 0));
        cancelar.setText("Sair");
        cancelar.setToolTipText("Cancelar as ações");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        inserir.setBackground(new java.awt.Color(0, 204, 51));
        inserir.setText("Salvar");
        inserir.setToolTipText("Gravar as ações");
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });

        jLabel2.setText("* Professor:");

        jLabel3.setText("* Data de início:");

        try {
            data_Início.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data_Início.setText("");
        data_Início.setToolTipText("Data de Início das atividades");

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.setToolTipText("Busca de Professores");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nome_Professor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("*Curso:");

        jLabel5.setText("*Turma:");

        select_Curso.setToolTipText("Curso da Disciplina");
        select_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_CursoActionPerformed(evt);
            }
        });

        selectTurma.setToolTipText("Turma da Disciplina");
        selectTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTurmaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(383, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("DISCIPLINAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(301, 301, 301))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jButton2.setText("Ajuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(nome_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(select_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(selectTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(data_Início, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(nome_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(select_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(selectTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_Início, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(inserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Grade");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setProfessor(Professora professor) {
        int op = JOptionPane.showConfirmDialog(null, "Professor encontrado: " + professor.getNome() + "\nConfirma?", "Confirmação", 0);
        if (op == 0) {
            this.professor = professor;
            this.nome_Professor.setText(this.professor.getNome());
        }
    }

    private void carregarComboCurso() {
        Dao_Curso dc = new Dao_Curso();
        List<Cursos> list = dc.list();
        if (list.isEmpty()) {
            int op = JOptionPane.showConfirmDialog(null, "Não há Cursos Cadastrados.\nDeseja Cadastrar?", "Confirmação", 0);
            if (op == 0) {
                new Novo_Curso().setVisible(true);
                carregarComboCurso();
            }
        } else {
            int i = 1;
            this.select_Curso.addItem("");
            for (Iterator<Cursos> it = list.iterator(); it.hasNext();) {
                Cursos curs = it.next();
                this.cursos.put(i, curs);
                this.select_Curso.addItem(curs.getNome() + " - " + curs.getTurno());
                i++;
            }
        }
    }

    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed

        StringBuilder ret = validaData();
        this.supri = new Suprim();
        if (ret.length() == 0) {

            boolean ad = getDisciplinasSelecionadas();

            if (ad) {
                Dao_Suprimento ds = new Dao_Suprimento();

                this.supri.setDataInicio(this.data_Início.getText());
                this.supri.setDataSuprim(new DataDoSistema().getDataAtual());
                this.supri.setProfessor(professor);
//                    this.supri.setDisciplinas(ad);
//                    this.professor.setDisciplinas(ad);

                try {
                    Transaction tran = this.sessão.beginTransaction();
                    ds.persist(this.supri, this.sessão);
                    tran.commit();
                    confirma_NovaDistribuição();
                } catch (Exception ex) {
                    this.sessão.beginTransaction().rollback();
                    Logger.getLogger(Nova_Distribuição.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione a(s) Disciplina(s)!");
            }
        } else {
            JOptionPane.showMessageDialog(null, ret);
        }
    }//GEN-LAST:event_inserirActionPerformed

    private void confirma_NovaDistribuição() {
        int opção = JOptionPane.showConfirmDialog(
                null, "Distribuição realizada!\nDeseja realizar nova Distribuição?", "Confirmação", 0);
        if (opção == 0) {
            excluiLinhas();
            this.select_Curso.setSelectedIndex(0);
            this.selectTurma.setSelectedIndex(0);
            this.data_Início.setText(null);
        } else {//fecha se o usuário não quiser realizar novo cancelamento
            this.dispose();
        }
    }

    private void excluiLinhas() {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Distribuição.getModel();

        int linhas = this.tabela_Distribuição.getRowCount();
        while (linhas > 0) {
            model.removeRow(0);
            linhas--;
        }
    }
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Consulta_Prof consulta = new Consulta_Prof(this, this.sessão);
        consulta.setVisible(true);
        this.select_Curso.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void select_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_CursoActionPerformed
        // TODO add your handling code here:
        Cursos c = (Cursos) this.cursos.get(this.select_Curso.getSelectedIndex());
        if (this.select_Curso.getSelectedIndex() > 0) {
            this.selectTurma.setEnabled(true);
            List<Turmas> turm = new Dao_Turma().getTurmasIdCurso(c.getId());
            if (turm.isEmpty()) {
                int op = JOptionPane.showConfirmDialog(null, "Não há Turmas para este curso!\nDeseja Cadastrar?");
                if (op == 0) {
                    this.dispose();
                    new Cadastro_Turmas().setVisible(true);
                }
            } else {
                excluiLinhas();
                this.selectTurma.removeAllItems();
                int i = 1;
                this.selectTurma.addItem(" ");
                for (Turmas t : turm) {
                    this.turmas.put(i, t);
                    this.selectTurma.addItem(t.getSerie() + " " + t.getSeriacao());
                    i++;
                }
            }
        }
    }//GEN-LAST:event_select_CursoActionPerformed

    private void selectTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTurmaActionPerformed
        // TODO add your handling code here:
        Dao_Disciplina dd = new Dao_Disciplina();
        if (this.selectTurma.getSelectedIndex() > 0) {
            this.turmaSelecionada = (Turmas) this.turmas.get(this.selectTurma.getSelectedIndex());
            excluiLinhas();

            this.disciplinas = dd.getNaoSupridasTurma(this.turmaSelecionada.getId(), this.sessão);
            if (this.disciplinas.size() > 0) {
                JOptionPane.showMessageDialog(null, "Nao vazio " + this.disciplinas.size());
                for (Iterator<Disciplinas> it = this.disciplinas.iterator(); it.hasNext();) {
                    Disciplinas disci = it.next();
                    insereDisciplinaTabela(disci);
                }

            } else {
                JOptionPane.showMessageDialog(null, "A Turma não possui Disciplinas não supridas.\nDeseja inserir?");
            }
        }
    }//GEN-LAST:event_selectTurmaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Ajuda_Suprimento().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void insereDisciplinaTabela(Disciplinas d) {
        DefaultTableModel model = (DefaultTableModel) this.tabela_Distribuição.getModel();
        this.tabela_Distribuição.getRowCount();

        model.addRow(new Object[]{
            d.getId(),
            d.getCodigo(),
            d.getNome(),
            d.getCompCurric(),
            d.getCargaHoraria(),
            false
        });
    }

    private StringBuilder validaData() {
        StringBuilder not = new StringBuilder();
        String data = this.data_Início.getText().replaceAll("/", "");

        if (this.nome_Professor.getText().equals("")) {
            not.append("Busque o Professor.\n");
        }
        if (this.tabela_Distribuição.getRowCount() == 0) {
            not.append("Não há Disciplinas a serem distribuídas.\n");
        }
        //         else {
//            boolean s = true;
//            int linhas = this.tabela_Distribuição.getRowCount();
//            for (int i = 0; i < linhas; i++) {
//                if (this.tabela_Distribuição.getValueAt(i, 5) == true) {
//                    s = false;
//                }
//            }
//            //se não existir disciplina selecionada, informe
//            if (s) {
//                not.append("Selecione as Disciplina.\n");
//            }
//        }
        //vendo se data de início é válida
        try {
            Integer.parseInt(data);
            if (!new Valida_Datas().validações(data)) {
                not.append("Data de Início inválida.\n");
            }
        } catch (Exception e) {
            not.append("Informe a Data de Início.\n");
        }
        return not;
    }

    private boolean getDisciplinasSelecionadas() {
        int linhas = this.tabela_Distribuição.getRowCount();
        List<Disciplinas> aux = new ArrayList();

        for (int i = 0; i < linhas; i++) {
            if (this.tabela_Distribuição.getValueAt(i, 5) == true) {
                int id = Integer.parseInt(this.tabela_Distribuição.getValueAt(i, 0).toString());
                for (Disciplinas d : this.disciplinas) {//percorrer vetor de disciplinas
                    if (d.getId() == id) {
                        d.setSuprida(true);
//                        aux.add(d);
                        this.professor.setDisciplina(d);
                        this.supri.setDisciplina(d);
                        break;
                    }
                }
            }
        }

        return verCH(aux);
    }

    private boolean verCH(List<Disciplinas> ad) {
        StringBuilder verCh = new Controller_Substituicao().verificaCHSubstituto(this.professor, ad);
        if (verCh.length() != 0) {
            JOptionPane.showMessageDialog(null, verCh);
            return false;
        }
        return true;
    }

    private void configuraTabela() {
//        TableColumnModel columnModel = this.tabela_Distribuição.getColumnModel();
//        columnModel.getColumn(0).setMinWidth(80);
//        columnModel.getColumn(1).setMinWidth(190);
//        columnModel.getColumn(2).setMaxWidth(50);
//        columnModel.getColumn(3).setMinWidth(40);
//        columnModel.getColumn(4).setMinWidth(70);
//        columnModel.getColumn(5).setMinWidth(70);
//        columnModel.getColumn(6).setMinWidth(80);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField data_Início;
    private javax.swing.JButton inserir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome_Professor;
    private javax.swing.JComboBox selectTurma;
    private javax.swing.JComboBox select_Curso;
    private javax.swing.JTable tabela_Distribuição;
    // End of variables declaration//GEN-END:variables
}
