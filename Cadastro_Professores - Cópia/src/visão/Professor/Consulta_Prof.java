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
        flags(false, false, false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoBusca = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("RG:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 136, -1, -1));

        rg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rgKeyReleased(evt);
            }
        });
        getContentPane().add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 133, 136, -1));

        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 186, -1, -1));

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 183, 323, -1));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.setToolTipText("Buscar Professor");
        buscar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 257, -1, 33));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONSULTA PROFESSOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 441, -1));

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair desta tela");
        cancelar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 257, 89, -1));

        jLabel5.setText("CPF:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 136, -1, -1));

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
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 133, 142, -1));

        jLabel2.setText("Buscar por:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 77, -1, -1));

        tipoBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Nome", "RG", "CPF" }));
        tipoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(tipoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 74, 92, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Professora prof = null;

        if (this.tipoBusca.getSelectedItem().equals("Nome")) {     
            prof = busca_PorNome();
        } else if (this.tipoBusca.getSelectedItem().equals("CPF")) {
            prof = busca_PorCpf();
        } else if (this.tipoBusca.getSelectedItem().equals("RG")) {
            prof = busca_PorRg();
        }

        if (prof == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
        } else {
            if (consulta) {
                new Cadastro(prof, false).setVisible(true);
                this.dispose();
            } else {
                reflection(prof);
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void tipoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBuscaActionPerformed
        if (this.tipoBusca.getSelectedItem().equals("Nome")) {
            flags(true, false, false);
            limparCampos(this.rg, this.cpf);
            this.nome.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("CPF")) {
            flags(false, true, false);
            limparCampos(this.nome, this.rg);
            this.cpf.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("RG")) {
            flags(false, false, true);
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

    private void flags(boolean nome, boolean cpf, boolean rg) {
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
    private javax.swing.JTextField nome;
    private javax.swing.JTextField rg;
    private javax.swing.JComboBox tipoBusca;
    // End of variables declaration//GEN-END:variables
}
