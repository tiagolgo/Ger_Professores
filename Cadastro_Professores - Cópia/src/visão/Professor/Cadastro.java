/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.Professor;

import Arquivo.Arquivo_Estados;
import Conexao.Hibernate_Sessao;
import Controller.Controller_Servidor;
import Dao.Dao_Entidades.Dao_Professor;
import Entidades.Contato;
import Entidades.Endereco;
import Entidades.Professora;
import Estados.Estados;
import Validações.Valida_Cadastro;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Meus Documentos
 */
public class Cadastro extends javax.swing.JDialog {

    private Session sessão;
    private Professora pessoa;
    private boolean atualiza;
    private int id;

    public Cadastro() {
        this.setTitle("Cadastro de Professor");
        this.sessão = Hibernate_Sessao.getInstance().retornaSession();
        auxConstrutor();
        this.alterar.setEnabled(false);
        this.excluir.setEnabled(false);
    }

//    public static void main(String[] args) {
//        new Cadastro().setVisible(true);
//
//    }
    private void auxConstrutor() {
        initComponents();
        super.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        carregaCombosEstados();
    }

    public Cadastro(Professora obj, Session sessao) {
        auxConstrutor();
        this.setTitle("Atualizar Professor");
        this.sessão = sessao;
        this.pessoa = obj;
        preencheCampos();
        this.titulo.setText("Atualização de Cadastro");
        this.id = obj.getId();
        desativaCampos(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        estado_Nasc = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uf_Rg = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        emissão_Rg = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        rg = new javax.swing.JTextField();
        nascimento = new javax.swing.JFormattedTextField();
        municipio = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lFuncional = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        função = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        vínculo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        número = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        uf_Endereco = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cep = new javax.swing.JFormattedTextField();
        mun_Endereco = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        fone_Res = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        sair = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CADASTRO DE PROFESSOR");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/professor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 51)));

        jLabel1.setText("Nome*:");

        jLabel2.setText("Sexo:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));

        jLabel3.setText("Nascimento*:");

        jLabel4.setText("Município:");

        jLabel5.setText("Estado:");

        estado_Nasc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                estado_NascItemStateChanged(evt);
            }
        });

        jLabel6.setText("RG*:");

        jLabel7.setText("UF*:");

        jLabel9.setText("Emissão*:");

        jLabel10.setText("CPF:");

        try {
            emissão_Rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        municipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nascimento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(municipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uf_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emissão_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(estado_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(uf_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(emissão_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        rg.getAccessibleContext().setAccessibleName("sdsds");
        rg.getAccessibleContext().setAccessibleDescription("lklk");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 51)));

        jLabel11.setText("Lotação Funcional:");

        lFuncional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3" }));

        jLabel12.setText("Função:");

        função.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Professor", "Secretário", "Servidor" }));

        jLabel13.setText("Vínculo:");

        vínculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "PSS", "QPM", "QPPE" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lFuncional, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(função, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vínculo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lFuncional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(função, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(vínculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 51)));

        jLabel14.setText("Rua:");

        jLabel15.setText("Nº:");

        jLabel16.setText("Bairro:");

        jLabel17.setText("Município:");

        jLabel18.setText("Estado:");

        uf_Endereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        uf_Endereco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uf_EnderecoItemStateChanged(evt);
            }
        });

        jLabel19.setText("CEP:");

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        mun_Endereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uf_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mun_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cep))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(número, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(número, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(uf_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mun_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 51)));

        jLabel20.setText("Telefone:");

        jLabel23.setText("E-mail:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fone_Res, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fone_Res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        sair.setText("Sair");
        sair.setToolTipText("Sair desta tela");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.setToolTipText("Limpar todos os dados");
        limpar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        cadastrar.setText("Salvar");
        cadastrar.setToolTipText("Salvar Dados");
        cadastrar.setAlignmentY(0.0F);
        cadastrar.setAutoscrolls(true);
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cadastrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cadastrar.setIconTextGap(0);
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.setToolTipText("Alterar Dados");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.setToolTipText("Excluir Professor");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(excluir)
                .addGap(18, 18, 18)
                .addComponent(cadastrar)
                .addGap(18, 18, 18)
                .addComponent(alterar)
                .addGap(18, 18, 18)
                .addComponent(limpar)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpar)
                    .addComponent(cadastrar)
                    .addComponent(alterar)
                    .addComponent(excluir))
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Contato:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Endereço:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Informações Funcionais:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Informações Pessoais:");

        jLabel21.setForeground(new java.awt.Color(255, 51, 0));
        jLabel21.setText("* Campos obrigatórios.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel25)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel21)
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void carregaCombosEstados() {
        List<String> values = new ArrayList();

        values.add("");
        for (Estados estados : Estados.values()) {
            values.add(estados.toString().replaceAll("_", " "));
        }

        this.uf_Endereco.setModel(new javax.swing.DefaultComboBoxModel(values.toArray()));
        this.uf_Rg.setModel(new javax.swing.DefaultComboBoxModel(values.toArray()));
        this.estado_Nasc.setModel(new javax.swing.DefaultComboBoxModel(values.toArray()));
    }

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        if (!this.atualiza) {
            this.pessoa = new Professora();
        }
        StringBuilder ve = verDadosPessoais();
        if (ve.length() == 0) {
            preenche_DadosPessoais(pessoa);
            preenche_InfoFuncionais(pessoa);
            pessoa.setMunNasc(this.municipio.getSelectedItem().toString());
            pessoa.setEstadoNasc(this.estado_Nasc.getSelectedItem().toString());
            pessoa.setEndereco(cria_Endereço());

            Contato contato;
            if (this.atualiza) {
                contato = this.pessoa.getContato();
            } else {
                contato = new Contato();
            }
            contato.setEmail(this.email1.getText());
            contato.setFone(this.fone_Res.getText());
            pessoa.setContato(contato);

            chamaPersiste();
        } else {
            JOptionPane.showMessageDialog(null, ve);
        }

    }//GEN-LAST:event_cadastrarActionPerformed

    private void chamaPersiste() {

        Dao_Professor dp = new Dao_Professor();
        try {
            if (this.atualiza) {
                Transaction tr = this.sessão.beginTransaction();
                dp.persist(pessoa, this.sessão);
                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
                tr.commit();
                limparCampos();
            } else {
                dp.persist(pessoa);
                confirma_NovoAfastamento();
            }
        } catch (Exception ex) {
//            this.sessão.beginTransaction().rollback();
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirma_NovoAfastamento() {
        int opção = JOptionPane.showConfirmDialog(
                null, "Professor Inserido!\nDeseja realizar nova Inserção?", "Confirmação", 0);
//        this.sessão.flush();
        if (opção == 0) {
            limparCampos();
            this.sessão.flush();
        } else {//fecha se o usuário não quiser realizar novo cancelamento
            this.dispose();
        }
    }

    private List<String> buscaMunicipios(String estado) {
        Arquivo_Estados ae = new Arquivo_Estados();
        return ae.listaMunicipios(estado);
    }

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void estado_NascItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_estado_NascItemStateChanged
        // TODO add your handling code here:
        if (!this.estado_Nasc.getSelectedItem().equals("")) {
            String estado = this.estado_Nasc.getSelectedItem().toString();
            if (!estado.equals("")) {
                List<String> buscaMunicipios = buscaMunicipios(estado);
                municipio.setModel(new javax.swing.DefaultComboBoxModel(buscaMunicipios.toArray()));
            }
        } else {
            municipio.removeAllItems();
        }
    }//GEN-LAST:event_estado_NascItemStateChanged

    private void uf_EnderecoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uf_EnderecoItemStateChanged
        // TODO add your handling code here:

        if (!this.uf_Endereco.getSelectedItem().toString().equals("")) {
            List<String> buscaMunicipios = buscaMunicipios(this.uf_Endereco.getSelectedItem().toString());
            this.mun_Endereco.setModel(new javax.swing.DefaultComboBoxModel(buscaMunicipios.toArray()));
        } else {
            this.mun_Endereco.removeAllItems();
        }
    }//GEN-LAST:event_uf_EnderecoItemStateChanged

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        StringBuilder retorno = new Controller_Servidor().removerServidor(this.pessoa, sessão);
        if (retorno == null) {
            if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão de: " + this.pessoa.getNome() + "?") == 0) {
                Dao_Professor dp = new Dao_Professor();
                try {
                    Transaction tr = this.sessão.beginTransaction();
                    dp.delete(this.pessoa, this.sessão);
                    tr.commit();
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "O Professor possui registros válidos e não pode ser removido!");
                    this.sessão.beginTransaction().rollback();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, retorno);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
        this.atualiza = true;
        desativaCampos(true);
        this.limpar.setEnabled(false);
    }//GEN-LAST:event_alterarActionPerformed

    private void preenche_InfoFuncionais(Professora prof) {
        Object funcao = this.função.getSelectedItem();
        Object vinc = this.vínculo.getSelectedItem();
        Object lf = this.lFuncional.getSelectedItem();
        if (funcao != null) {
            prof.setCargo(funcao.toString());
        }
        if (vinc != null) {
            prof.setVinculo(vinc.toString());
        }
        if (lf != null) {
            prof.setLf(lf.toString());
        }

    }

    private void preenche_DadosPessoais(Professora prof) {
        prof.setNome(this.nome.getText());
        prof.setSexo(this.sexo.getSelectedItem().toString());
        prof.setNascimento(this.nascimento.getText().replaceAll("/", ""));
        prof.setCpf(this.cpf.getText().replace('.', '-').replaceAll("-", ""));
        prof.setRg(this.rg.getText());
        prof.setUfRg(this.uf_Rg.getSelectedItem().toString());
        prof.setEmissaoRg(this.emissão_Rg.getText().replaceAll("/", ""));
    }

    private void preencheCampos() {
        this.nome.setText(pessoa.getNome());
        this.sexo.setSelectedItem(pessoa.getSexo());
        this.nascimento.setText(pessoa.getNascimento());
        if (pessoa.getEstadoNasc() != null) {
            this.estado_Nasc.setSelectedItem(pessoa.getEstadoNasc());
        }
        if (pessoa.getMunNasc() != null) {
            this.municipio.setSelectedItem(pessoa.getMunNasc());
        }
        this.rg.setText(pessoa.getRg());
        if (pessoa.getUfRg() != null) {
            this.uf_Rg.setSelectedItem(pessoa.getUfRg());
        }
        this.emissão_Rg.setText(pessoa.getEmissaoRg());
        this.cpf.setText(pessoa.getCpf().toString());

        this.lFuncional.setSelectedItem(String.valueOf(pessoa.getLf()));
        this.função.setSelectedItem(pessoa.getFuncao());
        this.vínculo.setSelectedItem(pessoa.getVinculo());

        this.rua.setText(pessoa.getEndereco().getRua());
        this.número.setText(String.valueOf(pessoa.getEndereco().getNumero()));
        this.bairro.setText(pessoa.getEndereco().getBairro());
        this.uf_Endereco.setSelectedItem(pessoa.getEndereco().getEstado());
        this.mun_Endereco.setSelectedItem(pessoa.getEndereco().getMunicipio());
        this.cep.setText(pessoa.getEndereco().getCep());

        if (!pessoa.getContato().getFone().isEmpty()) {
            this.fone_Res.setText(String.valueOf(pessoa.getContato().getFone()));
        }

        if (!pessoa.getContato().getEmail().isEmpty()) {
            this.email1.setText(pessoa.getContato().getEmail());
        }
    }

    public StringBuilder verDadosPessoais() {
        String nom = this.nome.getText();
//        String sex = this.sexo.getSelectedItem().toString();
        String nas = this.nascimento.getText().replaceAll("/", "").trim();
//        String estnas = this.estado_Nasc.getSelectedItem().toString();
//        String mun = this.municipio.getSelectedItem().toString();
        String identidade = this.rg.getText();
        String ufr = this.uf_Rg.getSelectedItem().toString().trim();
        String emiss = this.emissão_Rg.getText().replaceAll("/", "").trim();
        String cp = this.cpf.getText().replaceAll("\\.", "").replace("-", "").trim();
        String mail = this.email1.getText();
        String fone = this.fone_Res.getText();

        StringBuilder validar = new Valida_Cadastro().validar(nom, nas, identidade, ufr, emiss, cp, fone, mail);
        boolean ret;
        if (cp == "00000000000") {
            ret = new Dao_Professor().isExiste(identidade);
        } else {
            ret = new Dao_Professor().isExiste(identidade, identidade);
        }
        StringBuilder not = new StringBuilder();
        if (validar.length() != 0 || !ret) {
            not.append("FORAM ENCONTRADOS ERRO(S) NO(S) SEGUINTE(S) CAMPO(S) OBRIGATÓRIO(S):\n\n");
            not.append(validar);
            not.append("Já existe um Professor cadastrado com esse RG ou CPF.\n");
        }
        return not;
    }

    private Endereco cria_Endereço() {
        Endereco endereco;
        if (this.atualiza) {
            endereco = this.pessoa.getEndereco();
        } else {
            endereco = new Endereco();
        }
        endereco.setRua(this.rua.getText());
        if (this.mun_Endereco.getSelectedIndex() > 0) {
            endereco.setMunicipio(this.mun_Endereco.getSelectedItem().toString() + "");
        }
        if (this.estado_Nasc.getSelectedIndex() > 0) {
            endereco.setEstado(this.uf_Endereco.getSelectedItem().toString());
        }
        endereco.setNumero(this.número.getText());
        endereco.setBairro(this.bairro.getText());
        endereco.setCep(this.cep.getText().replaceAll("-", ""));

        return endereco;
    }

    private void limparCampos() {
        this.nome.setText("");
        this.sexo.setSelectedIndex(0);
        this.nascimento.setText("");
        this.estado_Nasc.setSelectedIndex(0);
        this.emissão_Rg.setText("");
        this.fone_Res.setText("");
        this.bairro.setText("");
        this.cep.setText("");
        this.cpf.setText("");
        this.email1.setText("");
        this.fone_Res.setText("");
        this.função.setSelectedIndex(0);
        this.lFuncional.setSelectedIndex(0);
        this.número.setText("");
        this.rg.setText("");
        this.rua.setText("");
        this.uf_Endereco.setSelectedIndex(0);
        this.uf_Rg.setSelectedIndex(0);
        this.vínculo.setSelectedIndex(0);

    }

    private void desativaCampos(boolean op) {
        this.nome.setEditable(op);
        this.sexo.setEnabled(op);
        this.nascimento.setEditable(op);
        this.estado_Nasc.setEnabled(op);
        this.emissão_Rg.setEditable(op);
        this.fone_Res.setEditable(op);
        this.bairro.setEditable(op);
        this.cep.setEditable(op);
        this.cpf.setEditable(op);
        this.email1.setEditable(op);
        this.fone_Res.setEditable(op);
        this.função.setEnabled(op);
        this.lFuncional.setEnabled(op);
        this.número.setEditable(op);
        this.rg.setEditable(op);
        this.rua.setEditable(op);
        this.uf_Endereco.setEnabled(op);
        this.uf_Rg.setEditable(op);
        this.vínculo.setEditable(op);
        this.mun_Endereco.setEnabled(op);
        this.municipio.setEnabled(op);
        this.vínculo.setEnabled(op);
        this.uf_Rg.setEnabled(op);
        this.cadastrar.setEnabled(op);
        this.limpar.setEnabled(op);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JTextField bairro;
    private javax.swing.JButton cadastrar;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField email1;
    private javax.swing.JFormattedTextField emissão_Rg;
    private javax.swing.JComboBox estado_Nasc;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField fone_Res;
    private javax.swing.JComboBox função;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox lFuncional;
    private javax.swing.JButton limpar;
    private javax.swing.JComboBox mun_Endereco;
    private javax.swing.JComboBox municipio;
    private javax.swing.JFormattedTextField nascimento;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField número;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField rua;
    private javax.swing.JButton sair;
    private javax.swing.JComboBox sexo;
    private javax.swing.JLabel titulo;
    private javax.swing.JComboBox uf_Endereco;
    private javax.swing.JComboBox uf_Rg;
    private javax.swing.JComboBox vínculo;
    // End of variables declaration//GEN-END:variables
}
