/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão;

import Relatorios.Relatorio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import visão.Curso.Novo_Curso;
import visão.Suprimento.Nova_Distribuição;
import visão.Afastamento.Afastados;
import visão.Cancelamento.Cancelamento_Tela;
import visão.Afastamento.Novo_Afastamento;
import visão.Cancelamento.Cancelamentos;
import visão.Curso.Cursos_Cadastrados;
import visão.Professor.Cadastro;
import visão.Professor.Consulta_Prof;
import visão.Professor.Todos_Professores;
import visão.Substituicao.Todas_Substituições;
import visão.Substituicao.Nova_Substituição;
import visão.Suprimento.Suprimentos;
import visão.Disciplina.Cadastrar_Disciplina;
import visão.Disciplina.Inserir_Disciplina_Turma;
import visão.Turma.Antigo_cadastro;
import visão.Turma.Cadastro_Turmas;
import visão.Turma.Turmas_Cadastradas;

/**
 *
 * @author Meus Documentos
 */
public class PáginaInicial extends javax.swing.JFrame {

    /**
     * Creates new form PáginaInicial
     */
    public PáginaInicial() {
        initComponents();
        this.setTitle("SGP - Sistema de Gerenciamento de Professores");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setSize(900, 650);
//        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        cadastrar_Curso = new javax.swing.JMenuItem();
        cadastrar_Professor = new javax.swing.JMenuItem();
        cadastrar_Disciplina = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        visualizar_TodosCursos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        todasTurmas = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        prof_Alteracao = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        insere_Afastamento = new javax.swing.JMenuItem();
        todos_Afastados = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        insere_Suprimento = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        insere_Cancelamento = new javax.swing.JMenuItem();
        todos_Cancelamentos = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        insere_Substituicao = new javax.swing.JMenuItem();
        exibe_Substituicoes = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 51));
        setPreferredSize(new java.awt.Dimension(820, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/professor.png"))); // NOI18N
        jButton7.setText("Professor");
        jButton7.setToolTipText("Novo Professor");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(47, 51));
        jButton7.setMinimumSize(new java.awt.Dimension(47, 51));
        jButton7.setName(""); // NOI18N
        jButton7.setPreferredSize(new java.awt.Dimension(47, 51));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator1);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/turma.png"))); // NOI18N
        jButton8.setText("Turma");
        jButton8.setToolTipText("Nova Turma");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(47, 51));
        jButton8.setMinimumSize(new java.awt.Dimension(47, 51));
        jButton8.setPreferredSize(new java.awt.Dimension(47, 51));
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator2);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplina.png"))); // NOI18N
        jButton1.setText("Disciplina");
        jButton1.setToolTipText("Cadastrar Disciplina");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(47, 51));
        jButton1.setMinimumSize(new java.awt.Dimension(47, 51));
        jButton1.setPreferredSize(new java.awt.Dimension(47, 51));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator3);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setToolTipText("Buscar Professor");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(47, 51));
        jButton2.setMinimumSize(new java.awt.Dimension(47, 51));
        jButton2.setPreferredSize(new java.awt.Dimension(47, 51));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 715, -1));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 51));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(442, 32769));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(0, 3));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(342, 31));

        jMenu1.setText("Arquivo");

        jMenuItem3.setText("Fechar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu13.setText("Cadastros");

        cadastrar_Curso.setText("Curso");
        cadastrar_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_CursoActionPerformed(evt);
            }
        });
        jMenu13.add(cadastrar_Curso);

        cadastrar_Professor.setText("Professor");
        cadastrar_Professor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_ProfessorActionPerformed(evt);
            }
        });
        jMenu13.add(cadastrar_Professor);

        cadastrar_Disciplina.setText("Disciplina");
        cadastrar_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_DisciplinaActionPerformed(evt);
            }
        });
        jMenu13.add(cadastrar_Disciplina);

        jMenu2.setText("Turma");

        jMenuItem5.setText("Cadastrar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Inserir Disciplinas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenu13.add(jMenu2);

        jMenuBar1.add(jMenu13);

        jMenu5.setText("Consultar");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenu8.setText("Cursos");

        visualizar_TodosCursos.setText("Visualizar Todos");
        visualizar_TodosCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizar_TodosCursosActionPerformed(evt);
            }
        });
        jMenu8.add(visualizar_TodosCursos);

        jMenu5.add(jMenu8);

        jMenu7.setText("Turmas");

        todasTurmas.setText("Visualizar Todas");
        todasTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasTurmasActionPerformed(evt);
            }
        });
        jMenu7.add(todasTurmas);

        jMenu5.add(jMenu7);

        jMenu14.setText("Professores");

        prof_Alteracao.setText("Visualizar Todos");
        prof_Alteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_AlteracaoActionPerformed(evt);
            }
        });
        jMenu14.add(prof_Alteracao);

        jMenu5.add(jMenu14);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Procedimentos");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenu11.setText("Afastamento");

        insere_Afastamento.setText("Novo");
        insere_Afastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_AfastamentoActionPerformed(evt);
            }
        });
        jMenu11.add(insere_Afastamento);

        todos_Afastados.setText("Visualizar Todos");
        todos_Afastados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todos_AfastadosActionPerformed(evt);
            }
        });
        jMenu11.add(todos_Afastados);

        jMenu6.add(jMenu11);

        jMenu4.setText("Suprimento");

        insere_Suprimento.setText("Novo");
        insere_Suprimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_SuprimentoActionPerformed(evt);
            }
        });
        jMenu4.add(insere_Suprimento);

        jMenuItem2.setText("Visualizar Todos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu6.add(jMenu4);

        jMenu9.setText("Cancelamento");

        insere_Cancelamento.setText("Novo");
        insere_Cancelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_CancelamentoActionPerformed(evt);
            }
        });
        jMenu9.add(insere_Cancelamento);

        todos_Cancelamentos.setText("Visualizar Todos");
        todos_Cancelamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todos_CancelamentosActionPerformed(evt);
            }
        });
        jMenu9.add(todos_Cancelamentos);

        jMenu6.add(jMenu9);

        jMenu10.setText("Substituição");

        insere_Substituicao.setText("Novo");
        insere_Substituicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insere_SubstituicaoActionPerformed(evt);
            }
        });
        jMenu10.add(insere_Substituicao);

        exibe_Substituicoes.setText("Visualizar Substituições");
        exibe_Substituicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibe_SubstituicoesActionPerformed(evt);
            }
        });
        jMenu10.add(exibe_Substituicoes);

        jMenu6.add(jMenu10);

        jMenuBar1.add(jMenu6);

        jMenu15.setText("Relatórios");

        jMenu16.setText("Professores");

        jMenuItem7.setText("Todos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem7);

        jMenu15.add(jMenu16);

        jMenuBar1.add(jMenu15);

        jMenu12.setText("Ajuda");

        jMenuItem4.setText("Sobre");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem4);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
        System.out.println("ok");
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void prof_AlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prof_AlteracaoActionPerformed
        // TODO add your handling code here:
        new Todos_Professores().setVisible(true);
    }//GEN-LAST:event_prof_AlteracaoActionPerformed

    private void insere_AfastamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_AfastamentoActionPerformed
        // TODO add your handling code here:
        new Novo_Afastamento().setVisible(true);
    }//GEN-LAST:event_insere_AfastamentoActionPerformed

    private void insere_SuprimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_SuprimentoActionPerformed
        // TODO add your handling code here:
        new Nova_Distribuição().setVisible(true);
    }//GEN-LAST:event_insere_SuprimentoActionPerformed

    private void insere_CancelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_CancelamentoActionPerformed
        // TODO add your handling code here:
        new Cancelamento_Tela().setVisible(true);
    }//GEN-LAST:event_insere_CancelamentoActionPerformed

    private void insere_SubstituicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insere_SubstituicaoActionPerformed
        // TODO add your handling code here:
        new Nova_Substituição().setVisible(true);
    }//GEN-LAST:event_insere_SubstituicaoActionPerformed

    private void todos_AfastadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todos_AfastadosActionPerformed
        // TODO add your handling code here:
        new Afastados().setVisible(true);
    }//GEN-LAST:event_todos_AfastadosActionPerformed

    private void todos_CancelamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todos_CancelamentosActionPerformed
        // TODO add your handling code here:
        new Cancelamentos().setVisible(true);
    }//GEN-LAST:event_todos_CancelamentosActionPerformed

    private void exibe_SubstituicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibe_SubstituicoesActionPerformed
        // TODO add your handling code here:
        new Todas_Substituições().setVisible(true);
    }//GEN-LAST:event_exibe_SubstituicoesActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new Suprimentos().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void visualizar_TodosCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizar_TodosCursosActionPerformed
        // TODO add your handling code here:
        new Cursos_Cadastrados().setVisible(true);
    }//GEN-LAST:event_visualizar_TodosCursosActionPerformed

    private void todasTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasTurmasActionPerformed
        // TODO add your handling code here:
        new Turmas_Cadastradas().setVisible(true);
    }//GEN-LAST:event_todasTurmasActionPerformed

    private void cadastrar_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_CursoActionPerformed
        // TODO add your handling code here:
        new Novo_Curso().setVisible(true);
    }//GEN-LAST:event_cadastrar_CursoActionPerformed

    private void cadastrar_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_DisciplinaActionPerformed
        // TODO add your handling code here:
        new Cadastrar_Disciplina().setVisible(true);
    }//GEN-LAST:event_cadastrar_DisciplinaActionPerformed

    private void cadastrar_ProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_ProfessorActionPerformed
        // TODO add your handling code here:
        new Cadastro().setVisible(true);
    }//GEN-LAST:event_cadastrar_ProfessorActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new Sobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new Cadastro().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Cadastro_Turmas().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Cadastrar_Disciplina().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Consulta_Prof().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        new Inserir_Disciplina_Turma().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new Cadastro_Turmas().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Relatorio r = new Relatorio();
        r.relatorioEmJFrame();
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PáginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PáginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PáginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PáginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        new PáginaInicial().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrar_Curso;
    private javax.swing.JMenuItem cadastrar_Disciplina;
    private javax.swing.JMenuItem cadastrar_Professor;
    private javax.swing.JMenuItem exibe_Substituicoes;
    private javax.swing.JMenuItem insere_Afastamento;
    private javax.swing.JMenuItem insere_Cancelamento;
    private javax.swing.JMenuItem insere_Substituicao;
    private javax.swing.JMenuItem insere_Suprimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem prof_Alteracao;
    private javax.swing.JMenuItem todasTurmas;
    private javax.swing.JMenuItem todos_Afastados;
    private javax.swing.JMenuItem todos_Cancelamentos;
    private javax.swing.JMenuItem visualizar_TodosCursos;
    // End of variables declaration//GEN-END:variables
}
