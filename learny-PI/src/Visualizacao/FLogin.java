/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.AlunoLogado;
import Modelagem.Alunos;
import Modelagem.WindowManager;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João
 */
public class FLogin extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Alunos a = new Alunos();
    AlunoLogado alunlog = new AlunoLogado();
    
    Color preto = new Color(0,0,0,64);
    Color vermelhoPastel = new Color(239,91,106);
    Color azulPastel = new Color(108,210,255);

    /**
     * Creates new form FLogin
     */
    public FLogin() {
        initComponents();
        // Deleta o aluno logado ao sair pelo botão de fechar janela
        WindowManager.register(this);
        panelGradiente.addColor(new ModelColor(vermelhoPastel, 0f), new ModelColor(azulPastel, 1f));
        conexao = Conexao.conecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente = new Visualizacao.PanelGradiente();
        panelPretoOpac2 = new Visualizacao.PanelPretoOpac();
        txt_usuario_entrar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_senha_entrar = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone confirmar.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Não tem uma conta?");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cadastre-se");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Entre na sua conta Learny");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Faça login com suas informações de cadastro");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário:");

        javax.swing.GroupLayout panelPretoOpac2Layout = new javax.swing.GroupLayout(panelPretoOpac2);
        panelPretoOpac2.setLayout(panelPretoOpac2Layout);
        panelPretoOpac2Layout.setHorizontalGroup(
            panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_usuario_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPretoOpac2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_senha_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel7))))))
                    .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel3))
                    .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4)
                    .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel8)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelPretoOpac2Layout.setVerticalGroup(
            panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretoOpac2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_senha_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addGroup(panelPretoOpac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGradienteLayout = new javax.swing.GroupLayout(panelGradiente);
        panelGradiente.setLayout(panelGradienteLayout);
        panelGradienteLayout.setHorizontalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradienteLayout.setVerticalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new FCadastro().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        logar();
    }//GEN-LAST:event_jLabel8MouseClicked
    public void logar(){
        String sql = "select * from alunos where usuario =? and senha =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_usuario_entrar.getText());
            pst.setString(2, txt_senha_entrar.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                alunlog.setIdAluno(rs.getInt(1));
                alunlog.setNome(rs.getString(2));
                alunlog.setUsuario(rs.getString(3));
                alunlog.setSenha(rs.getString(4));
                alunlog.setEmail(rs.getString(5));
                alunlog.setDataNasc(rs.getString(6));
                alunlog.setIdade(rs.getInt(7));
                alunlog.setPontosTotais(rs.getDouble(8));
                alunlog.setFasesConcluidas(rs.getInt(9));
                alunlog.setFoto(rs.getString(10));
                alunlog.cadastrarLogin();
                new FMundos().setVisible(true);
                dispose();
            } else{
                new FMundos().setVisible(true);
                dispose();
                //JOptionPane.showMessageDialog(null,"usuário ou senha inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
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
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private Visualizacao.PanelGradiente panelGradiente;
    private Visualizacao.PanelPretoOpac panelPretoOpac2;
    private javax.swing.JPasswordField txt_senha_entrar;
    private javax.swing.JTextField txt_usuario_entrar;
    // End of variables declaration//GEN-END:variables
}
