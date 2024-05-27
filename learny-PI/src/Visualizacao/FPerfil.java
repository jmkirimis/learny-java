/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class FPerfil extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Aluno alunoLogado;
    
    public FPerfil() {
        initComponents();
        alunoLogado = Session.getInstance().getAlunoLogado();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
                String nome = alunoLogado.getNome();
                double pontos = alunoLogado.getPontosTotais();
                int nivel = (int)(pontos/100);
                double progressoNivel = pontos % 100;
                String foto = alunoLogado.getFoto();
                barra_nivel.setValue((int) progressoNivel);
                lbl_nome_perfil.setText(nome);
                lbl_anos.setText(Integer.toString(nivel));
                panel_foto_perfil.setImagem("src/Imagens/" + foto);     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_nome_perfil = new javax.swing.JLabel();
        lbl_idade_perfil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelBtnPerfil1 = new Visualizacao.PanelBtnPerfil();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBtnPerfil2 = new Visualizacao.PanelBtnPerfil();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBtnPerfil3 = new Visualizacao.PanelBtnPerfil();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBtnPerfil4 = new Visualizacao.PanelBtnPerfil();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelBtnPerfil5 = new Visualizacao.PanelBtnPerfil();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelBtnPerfil6 = new Visualizacao.PanelBtnPerfil();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelBtnPerfil7 = new Visualizacao.PanelBtnPerfil();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_anos = new javax.swing.JLabel();
        panel_foto_perfil = new Visualizacao.PanelRoundPerfil();
        panelRoundBorda1 = new Visualizacao.PanelRoundBorda();
        barra_nivel = new Visualizacao.ProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_nome_perfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_nome_perfil.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nome_perfil.setText("Nome");

        lbl_idade_perfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_idade_perfil.setForeground(new java.awt.Color(102, 102, 102));
        lbl_idade_perfil.setText("Lvl.");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        panelBtnPerfil1.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBtnPerfil1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil1MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon estatisticas.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Estatísticas");

        javax.swing.GroupLayout panelBtnPerfil1Layout = new javax.swing.GroupLayout(panelBtnPerfil1);
        panelBtnPerfil1.setLayout(panelBtnPerfil1Layout);
        panelBtnPerfil1Layout.setHorizontalGroup(
            panelBtnPerfil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnPerfil1Layout.setVerticalGroup(
            panelBtnPerfil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil1Layout.createSequentialGroup()
                .addGroup(panelBtnPerfil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBtnPerfil1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(panelBtnPerfil1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelBtnPerfil2.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBtnPerfil2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil2MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon google.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Ranking");

        javax.swing.GroupLayout panelBtnPerfil2Layout = new javax.swing.GroupLayout(panelBtnPerfil2);
        panelBtnPerfil2.setLayout(panelBtnPerfil2Layout);
        panelBtnPerfil2Layout.setHorizontalGroup(
            panelBtnPerfil2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnPerfil2Layout.setVerticalGroup(
            panelBtnPerfil2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil2Layout.createSequentialGroup()
                .addGroup(panelBtnPerfil2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBtnPerfil2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6))
                    .addGroup(panelBtnPerfil2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelBtnPerfil3.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBtnPerfil3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil3MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon sino.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Notificações");

        javax.swing.GroupLayout panelBtnPerfil3Layout = new javax.swing.GroupLayout(panelBtnPerfil3);
        panelBtnPerfil3.setLayout(panelBtnPerfil3Layout);
        panelBtnPerfil3Layout.setHorizontalGroup(
            panelBtnPerfil3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnPerfil3Layout.setVerticalGroup(
            panelBtnPerfil3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnPerfil3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(35, 35, 35))
        );

        panelBtnPerfil4.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBtnPerfil4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil4MouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon lapis.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Editar perfil");

        javax.swing.GroupLayout panelBtnPerfil4Layout = new javax.swing.GroupLayout(panelBtnPerfil4);
        panelBtnPerfil4.setLayout(panelBtnPerfil4Layout);
        panelBtnPerfil4Layout.setHorizontalGroup(
            panelBtnPerfil4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnPerfil4Layout.setVerticalGroup(
            panelBtnPerfil4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil4Layout.createSequentialGroup()
                .addGroup(panelBtnPerfil4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBtnPerfil4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10))
                    .addGroup(panelBtnPerfil4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelBtnPerfil5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon config.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Configurações");

        javax.swing.GroupLayout panelBtnPerfil5Layout = new javax.swing.GroupLayout(panelBtnPerfil5);
        panelBtnPerfil5.setLayout(panelBtnPerfil5Layout);
        panelBtnPerfil5Layout.setHorizontalGroup(
            panelBtnPerfil5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        panelBtnPerfil5Layout.setVerticalGroup(
            panelBtnPerfil5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil5Layout.createSequentialGroup()
                .addGroup(panelBtnPerfil5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBtnPerfil5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel12))
                    .addGroup(panelBtnPerfil5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelBtnPerfil6.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBtnPerfil6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil6MouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon sair.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Sair");

        javax.swing.GroupLayout panelBtnPerfil6Layout = new javax.swing.GroupLayout(panelBtnPerfil6);
        panelBtnPerfil6.setLayout(panelBtnPerfil6Layout);
        panelBtnPerfil6Layout.setHorizontalGroup(
            panelBtnPerfil6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil6Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        panelBtnPerfil6Layout.setVerticalGroup(
            panelBtnPerfil6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14)
            .addGroup(panelBtnPerfil6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15))
        );

        panelBtnPerfil7.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnPerfil7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBtnPerfil7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBtnPerfil7MouseExited(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon contato.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Contato");

        javax.swing.GroupLayout panelBtnPerfil7Layout = new javax.swing.GroupLayout(panelBtnPerfil7);
        panelBtnPerfil7.setLayout(panelBtnPerfil7Layout);
        panelBtnPerfil7Layout.setHorizontalGroup(
            panelBtnPerfil7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil7Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(0, 49, Short.MAX_VALUE))
        );
        panelBtnPerfil7Layout.setVerticalGroup(
            panelBtnPerfil7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnPerfil7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBtnPerfil7Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbl_anos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_anos.setForeground(new java.awt.Color(102, 102, 102));
        lbl_anos.setText("Nível");

        panel_foto_perfil.setPreferredSize(new java.awt.Dimension(150, 140));
        panel_foto_perfil.setRoundBottomLeft(50);
        panel_foto_perfil.setRoundBottomRight(50);
        panel_foto_perfil.setRoundTopLeft(50);
        panel_foto_perfil.setRoundTopRight(50);

        javax.swing.GroupLayout panel_foto_perfilLayout = new javax.swing.GroupLayout(panel_foto_perfil);
        panel_foto_perfil.setLayout(panel_foto_perfilLayout);
        panel_foto_perfilLayout.setHorizontalGroup(
            panel_foto_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panel_foto_perfilLayout.setVerticalGroup(
            panel_foto_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        panelRoundBorda1.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda1.setBorderWidth(3);
        panelRoundBorda1.setPreferredSize(new java.awt.Dimension(406, 45));
        panelRoundBorda1.setRadius(50);

        barra_nivel.setBorder(null);
        barra_nivel.setValue(300);
        barra_nivel.setColorString(new java.awt.Color(255, 255, 255));
        barra_nivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRoundBorda1Layout = new javax.swing.GroupLayout(panelRoundBorda1);
        panelRoundBorda1.setLayout(panelRoundBorda1Layout);
        panelRoundBorda1Layout.setHorizontalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(barra_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRoundBorda1Layout.setVerticalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barra_nivel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nome_perfil)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_idade_perfil)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_anos)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRoundBorda1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelBtnPerfil2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBtnPerfil3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBtnPerfil4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBtnPerfil5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBtnPerfil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(panelBtnPerfil6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelBtnPerfil7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panel_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_nome_perfil)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_idade_perfil)
                                .addComponent(lbl_anos))
                            .addGap(40, 40, 40))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(panelRoundBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelBtnPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtnPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtnPerfil3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtnPerfil4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtnPerfil5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBtnPerfil6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnPerfil7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel13MouseExited

    private void panelBtnPerfil6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil6MouseClicked
        new FLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelBtnPerfil6MouseClicked

    private void panelBtnPerfil1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil1MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil1MouseEntered

    private void panelBtnPerfil1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil1MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil1MouseExited

    private void panelBtnPerfil2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil2MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil2MouseEntered

    private void panelBtnPerfil2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil2MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil2MouseExited

    private void panelBtnPerfil3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil3MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil3MouseEntered

    private void panelBtnPerfil3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil3MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil3MouseExited

    private void panelBtnPerfil4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil4MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil4MouseEntered

    private void panelBtnPerfil4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil4MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil4MouseExited

    private void panelBtnPerfil6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil6MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil6MouseEntered

    private void panelBtnPerfil6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil6MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil6MouseExited

    private void panelBtnPerfil7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil7MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil7MouseEntered

    private void panelBtnPerfil7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil7MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_panelBtnPerfil7MouseExited

    private void panelBtnPerfil4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil4MouseClicked
        new FEditarPerfil().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelBtnPerfil4MouseClicked

    private void panelBtnPerfil1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil1MouseClicked
        new FEstatistica().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelBtnPerfil1MouseClicked

    private void panelBtnPerfil2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil2MouseClicked
        new FRanking().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelBtnPerfil2MouseClicked

    private void panelBtnPerfil3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnPerfil3MouseClicked
        new FNotificacao().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelBtnPerfil3MouseClicked

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
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.ProgressBar barra_nivel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_anos;
    private javax.swing.JLabel lbl_idade_perfil;
    private javax.swing.JLabel lbl_nome_perfil;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil1;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil2;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil3;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil4;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil5;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil6;
    private Visualizacao.PanelBtnPerfil panelBtnPerfil7;
    private Visualizacao.PanelRoundBorda panelRoundBorda1;
    private Visualizacao.PanelRoundPerfil panel_foto_perfil;
    // End of variables declaration//GEN-END:variables
}
