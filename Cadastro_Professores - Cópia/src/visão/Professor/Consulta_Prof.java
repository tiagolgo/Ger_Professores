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
        buscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoBusca = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        trechoNome = new javax.swing.JTextField();

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

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.setToolTipText("Buscar Professor");
        buscar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
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

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Sair");
        cancelar.setToolTipText("Sair desta tela");
        cancelar.setMargin(new java.awt.Insets(2, 2, 2, 14));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Buscar por:");

        tipoBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Nome Completo", "RG", "CPF", "Trecho de Nome" }));
        tipoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBuscaActionPerformed(evt);
            }
        });

        jLabel6.setText("Trecho de Nome:");

        trechoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                trechoNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(buscar)
                        .addGap(41, 41, 41)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trechoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(tipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(trechoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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
        } else if (this.tipoBusca.getSelectedItem().equals("Trecho de Nome")) {
            List<Professora> ret = busca_PorTrecho();
            if (ret.size() > 0) {
                new Todos_Professores(ret).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Não foram encotrados registros com esses parâmetros.");
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void notificação(Professora p) {
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
        } else {
            if (consulta) {
                new Cadastro(p, false).setVisible(true);
                this.dispose();
            } else {
                reflection(p);
            }
        }

    }

    private void tipoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBuscaActionPerformed
        if (this.tipoBusca.getSelectedItem().equals("Nome Completo")) {
            flags(true, false, false, false);
            limparCampos(this.rg, this.cpf, this.trechoNome);
            this.nome.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("CPF")) {
            flags(false, true, false, false);
            limparCampos(this.nome, this.rg, this.trechoNome);
            this.cpf.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("RG")) {
            flags(false, false, true, false);
            limparCampos(this.nome, this.cpf, this.trechoNome);
            this.rg.requestFocus();
        } else if (this.tipoBusca.getSelectedItem().equals("Trecho de Nome")) {
            flags(false, false, false, true);
            limparCampos(this.nome, this.cpf, this.rg);
            this.trechoNome.requestFocus();

        }
    }//GEN-LAST:event_tipoBuscaActionPerformed

    private void limparCampos(javax.swing.JTextField campo1, javax.swing.JTextField campo2, javax.swing.JTextField campo3) {
        campo1.setText(null);
        campo2.setText(null);
        campo3.setText(null);
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

    private void trechoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trechoNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_trechoNomeKeyReleased

    private void flags(boolean nome, boolean cpf, boolean rg, boolean trecho) {
        this.nome.setEditable(nome);
        this.nome.setEnabled(nome);
        this.cpf.setEditable(cpf);
        this.cpf.setEnabled(cpf);
        this.rg.setEditable(rg);
        this.rg.setEnabled(rg);
        this.trechoNome.setEditable(trecho);
        this.trechoNome.setEnabled(trecho);
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

    public List<Professora> busca_PorTrecho() {
        Dao_Professor dp = new Dao_Professor();
        return (List<Professora>) dp.getPorTrechoNome(this.trechoNome.getText(), this.sessao);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField rg;
    private javax.swing.JComboBox tipoBusca;
    private javax.swing.JTextField trechoNome;
    // End of variables declaration//GEN-END:variables
}
