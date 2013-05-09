/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.outras;

import java.util.ArrayList;
import modelo.Dao.Dao_Disciplina;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Meus Documentos
 */
public class Disciplina_Tela extends JFrame {

    private Disciplina_Tela disc;
    private Dao_Disciplina dao;
    private String codAltera;
    private ArrayList<Object> campos;

    public static void main(String[] args) {
        Disciplina_Tela t = new Disciplina_Tela();
        t.setVisible(true);
    }

    public Disciplina_Tela() {
        super.setTitle("Disciplinas");
        this.campos = new ArrayList<>();
        initComponents();
        this.setLocationRelativeTo(null);

        this.itemAlterar.setText("Alterar");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        itemAlterar = new javax.swing.JMenuItem();
        itemExcluir = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        campo1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inserirDisciplina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplinas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        compCurricular = new javax.swing.JComboBox();

        itemAlterar.setText("jMenuItem1");
        itemAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAlterarActionPerformed(evt);
            }
        });
        menuPopup.add(itemAlterar);

        itemExcluir.setText("Excluir");
        itemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcluirActionPerformed(evt);
            }
        });
        menuPopup.add(itemExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Comp. Curricular:");

        inserirDisciplina.setBackground(new java.awt.Color(0, 255, 51));
        inserirDisciplina.setText("Inserir");
        inserirDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirDisciplinaActionPerformed(evt);
            }
        });
        inserirDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inserirDisciplinaKeyReleased(evt);
            }
        });

        tabelaDisciplinas.setAutoCreateRowSorter(true);
        tabelaDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Comp. Curricular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDisciplinas.setInheritsPopupMenu(true);
        tabelaDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaDisciplinasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDisciplinas);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DISCIPLINAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(51, 0, 102));
        jLabel5.setText("Obs.: Selecione a disciplina desejada e clique com o botão direito para Editá-la ou Excluí-la.");

        sair.setBackground(new java.awt.Color(255, 102, 102));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 143, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(670, 26));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DISCIPLINAS CADASTRADAS");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        compCurricular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(compCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(inserirDisciplina)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(inserirDisciplina)
                    .addComponent(compCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();

    }//GEN-LAST:event_sairActionPerformed

    private void inserirDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirDisciplinaActionPerformed
                if (verificaCampos()) {
                    preencheTabela();
                    limpaCampos();
                }

    }//GEN-LAST:event_inserirDisciplinaActionPerformed

    private void preencheTabela() {
        javax.swing.table.DefaultTableModel model;
        model = (javax.swing.table.DefaultTableModel) this.tabelaDisciplinas.getModel();//pegar modelo da tabela
        model.addRow(new Object[]{this.campo1.getText(), this.campo2.getText(),"arrumar"});//adicionar linha na tabela

    }
    int x = 0, y = 0;
    private void tabelaDisciplinasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinasMouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            x = evt.getX();
            y = evt.getY();
        }
        if (this.tabelaDisciplinas.getSelectedRow() != -1 & evt.getButton() == 3) {
            this.menuPopup.show(this.tabelaDisciplinas, x, y);
        }
    }//GEN-LAST:event_tabelaDisciplinasMouseReleased

    private void inserirDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inserirDisciplinaKeyReleased

        inserirDisciplinaActionPerformed(null);
    }//GEN-LAST:event_inserirDisciplinaKeyReleased

    private void itemAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAlterarActionPerformed
        desmarcaTabela();
    }//GEN-LAST:event_itemAlterarActionPerformed

    private void itemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcluirActionPerformed
        desmarcaTabela();
    }//GEN-LAST:event_itemExcluirActionPerformed

    private void desmarcaTabela() {
        int s = this.tabelaDisciplinas.getSelectedRow();
        this.tabelaDisciplinas.removeRowSelectionInterval(s, s);
        this.tabelaDisciplinas.setFocusable(false);
    }

    private boolean verificaCampos() {
        if (this.campo1.getText().isEmpty() || this.campo2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação inválida: campos obrigatórios vazios");
            this.inserirDisciplina.transferFocus();
            return false;
        }
        return true;
    }

    private void limpaCampos() {
        this.campo1.setText("");
        this.campo2.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campo1;
    private javax.swing.JTextField campo2;
    private javax.swing.JComboBox compCurricular;
    private javax.swing.JButton inserirDisciplina;
    private javax.swing.JMenuItem itemAlterar;
    private javax.swing.JMenuItem itemExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabelaDisciplinas;
    // End of variables declaration//GEN-END:variables
}
