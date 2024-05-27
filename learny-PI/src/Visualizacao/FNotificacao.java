/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Session;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author fatec-dsm2
 */
public class FNotificacao extends javax.swing.JFrame {

    /**
     * Creates new form FNotificacao
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private Map<Integer, PanelSombra> notificacoesMap; // Mapa para armazenar os painéis de notificação
    private Aluno alunoLogado;
    private int idAluno;
    
    public FNotificacao() {
        initComponents();
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
        // Inicialize a estrutura de dados
        notificacoesMap = new HashMap<>();
        idAluno = alunoLogado.getIdAluno();
        painelNotificacoes.setLayout(new BoxLayout(painelNotificacoes, BoxLayout.Y_AXIS));
        carregarNotificacoes();
        carregarMissoes();
        // Suponha que você tenha um ID de notificação
        int idNotificacao = 1; // O ID da notificação que você deseja buscar

        // Obtenha o painel correspondente
        PanelSombra painel = getPainelNotificacao(idNotificacao);

        if (painel != null) {
            // Faça algo com o painel específico
            System.out.println("Painel encontrado para a notificação com ID: " + idNotificacao);
        } else {
            System.out.println("Nenhum painel encontrado para a notificação com ID: " + idNotificacao);
        }
    }

    private void carregarNotificacoes() {
        String sql = "select * from notificacoes where idAluno = ?"; // Ajuste a consulta conforme necessário

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idAluno);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString("notificacao");
                String caminhoIcone = rs.getString("iconNotificacao");

                JPanel painelNotificacao = criarPainelNotificacao(descricao, caminhoIcone);
                painelNotificacoes.add(painelNotificacao);    
                
                painelNotificacoes.add(Box.createRigidArea(new Dimension(0, 15)));

                painelNotificacoes.add(painelNotificacao);
                
                // Armazena o painel no mapa com o ID da notificação
                notificacoesMap.put(id, (PanelSombra) painelNotificacao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private JPanel criarPainelNotificacao(String descricao, String caminhoIcone) {
        PanelSombra painel = new PanelSombra();
        painel.setShadowType(ShadowType.BOT_RIGHT);
        painel.setShadowSize(3);
        painel.setShadowOpacity(0.3f);
        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painel.setBackground(Color.WHITE);

        JLabel lblIcone = new JLabel();
        ImageIcon icon = new ImageIcon("src/Imagens/" + caminhoIcone); // Ajuste o caminho conforme necessário
        lblIcone.setIcon(icon);
        lblIcone.setPreferredSize(new Dimension(50, 50));

        JLabel lblDescricao = new JLabel(descricao);
        lblDescricao.setFont(new Font("Arial", Font.BOLD, 16));
        lblDescricao.setForeground(Color.WHITE);

        painel.add(lblIcone, BorderLayout.WEST);
        painel.add(lblDescricao, BorderLayout.CENTER);

        // Ajuste o estilo do painel conforme necessário (cores, bordas, etc.)
        Color verde = new Color(0,204,51);
        painel.setBackground(verde); // Exemplo de cor de fundo

        return painel;
    }
    
    public PanelSombra getPainelNotificacao(int id) {
        return notificacoesMap.get(id);
    }
    
    private void carregarMissoes(){
        String sql = "select * from missoesDiarias"; 
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            // Lista de labels para fácil acesso no loop
            JLabel[] lblsMissoes = {lbl_missao1, lbl_missao2, lbl_missao3};
            JLabel[] lblsIcons = {icon_missao1, icon_misssao2, icon_missao3};
            int cont = 0;
            
            while(rs.next()){
                String descMissao = rs.getString(3);
                String iconMissao = rs.getString(4);
                lblsMissoes[cont].setText(descMissao);
                ImageIcon icon = new ImageIcon("src/Imagens/" + iconMissao);
                lblsIcons[cont].setIcon(icon);
                cont++;
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customScrollPane1 = new Visualizacao.CustomScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelSombra1 = new Visualizacao.PanelSombra();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customSeparator1 = new Visualizacao.CustomSeparator();
        jLabel6 = new javax.swing.JLabel();
        panelRoundBorda1 = new Visualizacao.PanelRoundBorda();
        lbl_missao1 = new javax.swing.JLabel();
        icon_missao1 = new javax.swing.JLabel();
        panelRoundBorda2 = new Visualizacao.PanelRoundBorda();
        lbl_missao2 = new javax.swing.JLabel();
        icon_misssao2 = new javax.swing.JLabel();
        panelRoundBorda3 = new Visualizacao.PanelRoundBorda();
        lbl_missao3 = new javax.swing.JLabel();
        icon_missao3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        painelNotificacoes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(72, 72, 72));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(60);
        panelRound1.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 72, 72));
        jLabel1.setText("Notificações");

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

        panelSombra1.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra1.setShadowOpacity(0.3F);
        panelSombra1.setShadowSize(4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(72, 72, 72));
        jLabel2.setText("Conta Criada !!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 72, 72));
        jLabel3.setText("Conta Kastle criada com");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(72, 72, 72));
        jLabel4.setText("sucesso, aproveite o");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(72, 72, 72));
        jLabel5.setText("aplicativo Learny");

        customSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        customSeparator1.setColor(new java.awt.Color(72, 72, 72));
        customSeparator1.setThickness(5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Novos");

        panelRoundBorda1.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda1.setBorderWidth(5);
        panelRoundBorda1.setGradientEndColor(new java.awt.Color(239, 91, 106));
        panelRoundBorda1.setRadius(50);

        lbl_missao1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao1.setForeground(new java.awt.Color(72, 72, 72));
        lbl_missao1.setText("Conclua 03 fases");

        icon_missao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-vermelho.png"))); // NOI18N

        javax.swing.GroupLayout panelRoundBorda1Layout = new javax.swing.GroupLayout(panelRoundBorda1);
        panelRoundBorda1.setLayout(panelRoundBorda1Layout);
        panelRoundBorda1Layout.setHorizontalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_missao1)
                .addGap(16, 16, 16))
        );
        panelRoundBorda1Layout.setVerticalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                .addGroup(panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_missao1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(icon_missao1)))
                .addGap(21, 21, 21))
        );

        panelRoundBorda2.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda2.setBorderWidth(5);
        panelRoundBorda2.setGradientStartColor(new java.awt.Color(83, 194, 242));
        panelRoundBorda2.setRadius(50);

        lbl_missao2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao2.setForeground(new java.awt.Color(72, 72, 72));
        lbl_missao2.setText("Conclua a fase observacao");

        icon_misssao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-observ.png"))); // NOI18N

        javax.swing.GroupLayout panelRoundBorda2Layout = new javax.swing.GroupLayout(panelRoundBorda2);
        panelRoundBorda2.setLayout(panelRoundBorda2Layout);
        panelRoundBorda2Layout.setHorizontalGroup(
            panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_misssao2)
                .addGap(19, 19, 19))
        );
        panelRoundBorda2Layout.setVerticalGroup(
            panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_misssao2)
                    .addComponent(lbl_missao2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        panelRoundBorda3.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda3.setBorderWidth(5);
        panelRoundBorda3.setGradientEndColor(new java.awt.Color(128, 210, 91));
        panelRoundBorda3.setGradientStartColor(new java.awt.Color(128, 210, 91));
        panelRoundBorda3.setRadius(50);

        lbl_missao3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao3.setForeground(new java.awt.Color(72, 72, 72));
        lbl_missao3.setText("Conclua um mundo");

        icon_missao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-mundo.png"))); // NOI18N

        javax.swing.GroupLayout panelRoundBorda3Layout = new javax.swing.GroupLayout(panelRoundBorda3);
        panelRoundBorda3.setLayout(panelRoundBorda3Layout);
        panelRoundBorda3Layout.setHorizontalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_missao3)
                .addGap(16, 16, 16))
        );
        panelRoundBorda3Layout.setVerticalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                .addGroup(panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_missao3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(icon_missao3)))
                .addGap(21, 21, 21))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Missões Diarias");

        painelNotificacoes.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelNotificacoesLayout = new javax.swing.GroupLayout(painelNotificacoes);
        painelNotificacoes.setLayout(painelNotificacoesLayout);
        painelNotificacoesLayout.setHorizontalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelNotificacoesLayout.setVerticalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGroup(panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSombra1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel6))
                    .addGroup(panelSombra1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelRoundBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRoundBorda2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRoundBorda3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelSombra1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel7))
                            .addGroup(panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(customSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                .addComponent(painelNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addComponent(customSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(painelNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(panelRoundBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelRoundBorda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelRoundBorda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel13))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 153, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new FPerfil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel13MouseExited

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
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FNotificacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private Visualizacao.CustomSeparator customSeparator1;
    private javax.swing.JLabel icon_missao1;
    private javax.swing.JLabel icon_missao3;
    private javax.swing.JLabel icon_misssao2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_missao1;
    private javax.swing.JLabel lbl_missao2;
    private javax.swing.JLabel lbl_missao3;
    private javax.swing.JPanel painelNotificacoes;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRoundBorda panelRoundBorda1;
    private Visualizacao.PanelRoundBorda panelRoundBorda2;
    private Visualizacao.PanelRoundBorda panelRoundBorda3;
    private Visualizacao.PanelSombra panelSombra1;
    // End of variables declaration//GEN-END:variables
}
