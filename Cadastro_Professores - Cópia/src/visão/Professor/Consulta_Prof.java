/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Professor;

import Conexao.Hibernate_Sessao;
import Dao.Dao_Entidades.Dao_Professor;
import Entidades.Professora;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Meus Documentos
 */
public class Consulta_Prof extends javax.swing.JDialog {

    private Session sessao;
    private Object telaDestino;
    private String op;
    private boolean consulta = false;

    public Consulta_Prof(Object origem, Session s) {
        iniciação();
        this.sessao = s;
        this.telaDestino = origem;
    }

    public Consulta_Prof(Object origem) {
        iniciação();
        this.telaDestino = origem;
        this.sessao = Hibernate_Sessao.getInstance().retornaSession();
    }

    public Consulta_Prof() {
        iniciação();
        this.consulta = true;
        this.sessao = Hibernate_Sessao.getInstance().retornaSession();

    }

    private void iniciação() {
        initComponents();
        super.setModal(true);
        this.setTitle("Consulta de Professor");
        this.setLocationRelativeTo(null);
        flags(false, false, false, false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoBusca = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("RG:");

        rg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rgKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome Completo:");

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONSULTA PROFESSOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("CPF:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfKeyReleased(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Buscar por:");

        tipoBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Nome Completo", "RG", "CPF", "Trecho de Nome" }));
        tipoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBuscaActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.setToolTipText("Buscar Professor");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair desta tela");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(cancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(rg, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                    .addComponent(tipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 119, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Professora prof = null;

        if (this.tipoBusca.getSelectedItem().equals("Nome Completo")) {
            prof = busca_PorNome();
            notificação(prof);
        } else if (this.tipoBusca.getSelectedItem().equals("CPF")) {
            prof = busca_PorCpf();
            notificação(prof);
        } else if (this.tipoBusca.getSelectedItem().equals("RG")) {
            prof = busca_PorRg();
            notificação(prof);
        } 
    }//GEN-LAST:event_buscarActionPerformed

    private void notificação(Professora p) {
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
        } else {
            if (consulta) {
                new Cadastro(p, this.sessao).setVisible(true);
                this.dispose();
            } else {
                reflection(p);
            }
        }

    }

    private void tipoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBuscaActionPerformed
        if (this.tipoBusca.getSelectedItem().equals("Nome Completo")) {
            flags(true, false, false, false);
            limparCampos(this.rg, this.cpf);
            this.nome.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("CPF")) {
            flags(false, true, false, false);
            limparCampos(this.nome, this.rg);
            this.cpf.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("RG")) {
            flags(false, false, true, false);
            limparCampos(this.nome, this.cpf);
            this.rg.requestFocus();
        } 
    }//GEN-LAST:event_tipoBuscaActionPerformed

    private void limparCampos(javax.swing.JTextField campo1, javax.swing.JTextField campo2) {
        campo1.setText(null);
        campo2.setText(null);
    }

    private void rgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rgKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyChar() == 10) {
            buscarActionPerformed(null);
        }
    }//GEN-LAST:event_rgKeyReleased

    private void cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyChar() == 10) {
            buscarActionPerformed(null);
        }
    }//GEN-LAST:event_cpfKeyReleased

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyChar() == 10) {
            buscarActionPerformed(null);
        }
    }//GEN-LAST:event_nomeKeyReleased

    private void flags(boolean nome, boolean cpf, boolean rg, boolean trecho) {
        this.nome.setEditable(nome);
        this.nome.setEnabled(nome);
        this.cpf.setEditable(cpf);
        this.cpf.setEnabled(cpf);
        this.rg.setEditable(rg);
        this.rg.setEnabled(rg);
    }

    public Professora busca_PorNome() {
        Dao_Professor dp = new Dao_Professor();
        return dp.unicoPorNome(this.nome.getText(), this.sessao);
    }

    public Professora busca_PorRg() {//corrigir
        Dao_Professor dp = new Dao_Professor();
        return dp.retornaPorRG(this.rg.getText(), this.sessao);
    }

    public Professora busca_PorCpf() {
        Dao_Professor dp = new Dao_Professor();
        return dp.retornaPorCPF(this.cpf.getText().replace('.', '-').replaceAll("-", ""), this.sessao);
    }



    private void reflection(Professora professor) {
        Professora pf = professor;

        try {
            Class classe = this.telaDestino.getClass();
            Method method = classe.getMethod("setProfessor", new Class[]{Professora.class});
            method.invoke(this.telaDestino, pf);
            this.dispose();
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Consulta_Prof.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro");
        }
    }
//    public static void main(String[] args) {
//        new Consulta_Prof().setVisible(true);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField rg;
    private javax.swing.JComboBox tipoBusca;
    // End of variables declaration//GEN-END:variables
}
