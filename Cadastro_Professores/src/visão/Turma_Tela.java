/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meus Documentos
 */
public class Turma_Tela extends javax.swing.JFrame {

    private int linhaEditar;
    private boolean edita;

    /**
     * Creates new form Turma_Tela
     */
    public Turma_Tela() {
        initComponents();
        this.edita = false;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Turma_Tela t = new Turma_Tela();
        t.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Excluir = new javax.swing.JMenuItem();
        label_1 = new javax.swing.JLabel();
        label_2 = new javax.swing.JLabel();
        label_3 = new javax.swing.JLabel();
        label_4 = new javax.swing.JLabel();
        curso = new javax.swing.JComboBox();
        turno = new javax.swing.JComboBox();
        sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        título = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTurma = new javax.swing.JTable();
        série = new javax.swing.JComboBox();
        turma = new javax.swing.JComboBox();
        ok = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        turmasInseridas = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        label_1.setText("Série:");

        label_2.setText("Seriação:");

        label_3.setText("Turno:");

        label_4.setText("Curso:");

        curso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Item 1", "Item 2", "Item 3", "Item 4" }));

        turno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Manhã", "Tarde", "Noite", "Integral" }));

        sair.setBackground(new java.awt.Color(255, 51, 51));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(104, 75, 138));

        título.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        título.setForeground(new java.awt.Color(255, 255, 255));
        título.setText("PLATAFORMA DE TURMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(título)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(título)
                .addContainerGap())
        );

        tabelaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Série", "Turma", "Turno", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaTurmaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTurma);

        série.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1ª", "2ª", "3ª", "4ª", "5ª", "6ª", "7ª", "8ª", "9ª" }));

        turma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" }));

        ok.setBackground(new java.awt.Color(0, 204, 0));
        ok.setText("Inserir");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        ok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                okKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Obs: Selecione a linha, depois clique com o botão esquerdo para Editar ou Excluir.");

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        turmasInseridas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        turmasInseridas.setForeground(new java.awt.Color(255, 255, 255));
        turmasInseridas.setText("TURMAS INSERIDAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(turmasInseridas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(turmasInseridas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(série, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_1)
                    .addComponent(label_2)
                    .addComponent(label_3)
                    .addComponent(label_4)
                    .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(série, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(sair)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int x = 0, y = 0;
    private void tabelaTurmaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTurmaMouseReleased
        // TODO add your handling code here:

        if (evt.getButton() == 1) {
            x = evt.getX();
            y = evt.getY();
        }
        if (this.tabelaTurma.getSelectedRow() != -1 & evt.getButton() == 3) {
            this.menuPopup.show(this.tabelaTurma, x, y);
        }
    }//GEN-LAST:event_tabelaTurmaMouseReleased

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
        if (verificaCombos()) {
            if (edita) {
                insereAlteração();
            } else {
                preencheTabela();
            }
        }
        this.tabelaTurma.setFocusable(false);
        this.série.setSelectedIndex(0);
        
    }//GEN-LAST:event_okActionPerformed
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
        int linha = this.tabelaTurma.getSelectedRow();
        this.série.setSelectedItem(this.tabelaTurma.getValueAt(linha, 0));
        this.turma.setSelectedItem(this.tabelaTurma.getValueAt(linha, 1));
        this.turno.setSelectedItem(this.tabelaTurma.getValueAt(linha, 2));
        this.curso.setSelectedItem(this.tabelaTurma.getValueAt(linha, 3));

        this.edita = true;
        this.linhaEditar = linha;
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        // TODO add your handling code here:
        javax.swing.table.DefaultTableModel model;
        model = (DefaultTableModel) this.tabelaTurma.getModel();

        model.removeRow(this.tabelaTurma.getSelectedRow());
    }//GEN-LAST:event_ExcluirActionPerformed

    private void okKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okKeyReleased
        // TODO add your handling code here:
        okActionPerformed(null);

    }//GEN-LAST:event_okKeyReleased

    private void preencheTabela() {
        javax.swing.table.DefaultTableModel model;
        model = (DefaultTableModel) this.tabelaTurma.getModel();//pegar modelo da tabela
        model.addRow(new Object[]{this.série.getSelectedItem(), this.turma.getSelectedItem(), this.turno.getSelectedItem(), this.curso.getSelectedItem()});//adicionar linha na tabela
        
        desmarcaCombos();
    }

    private void insereAlteração() {
        this.tabelaTurma.setValueAt(this.série.getSelectedItem(), this.linhaEditar, 0);
        this.tabelaTurma.setValueAt(this.turma.getSelectedItem(), this.linhaEditar, 1);
        this.tabelaTurma.setValueAt(this.turno.getSelectedItem(), this.linhaEditar, 2);
        this.tabelaTurma.setValueAt(this.curso.getSelectedItem(), this.linhaEditar, 3);

        this.edita = false;
        desmarcaCombos();
    }

    private void desmarcaCombos() {//por padrão os ComboBoxes devem possuir a posição 0 vazia
        this.série.setSelectedIndex(0);
        this.turma.setSelectedIndex(0);
        this.turno.setSelectedIndex(0);
        this.curso.setSelectedIndex(0);
    }

    private boolean verificaCombos() {
        boolean ser = this.série.getSelectedItem().equals("");
        boolean tur = this.turma.getSelectedItem().equals("");
        boolean turn = this.turno.getSelectedItem().equals("");
        boolean cur = this.curso.getSelectedItem().equals("");

        if (ser || tur || turn || cur) {
            JOptionPane.showMessageDialog(null, "Operação não executada, há campos em branco!");
            this.ok.transferFocus();
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Excluir;
    protected javax.swing.JComboBox curso;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel label_1;
    protected javax.swing.JLabel label_2;
    protected javax.swing.JLabel label_3;
    protected javax.swing.JLabel label_4;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JButton ok;
    private javax.swing.JButton sair;
    protected javax.swing.JComboBox série;
    protected javax.swing.JTable tabelaTurma;
    protected javax.swing.JComboBox turma;
    protected javax.swing.JLabel turmasInseridas;
    protected javax.swing.JComboBox turno;
    protected javax.swing.JLabel título;
    // End of variables declaration//GEN-END:variables
}
