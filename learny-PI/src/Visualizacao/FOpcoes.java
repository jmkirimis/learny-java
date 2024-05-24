/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author fatec-dsm2
 */
public class FOpcoes extends javax.swing.JFrame {

    /**
     * Creates new form FOpcoes
     */
    Color preto = new Color(0,0,0,64);
    Color vermelhoPastel = new Color(239,91,106);
    Color azulPastel = new Color(108,210,255);
    public FOpcoes() {
        initComponents();
        Color pretoComOpacidade = new Color(0, 0, 0, 64);
        panel_sombra.setBackground(pretoComOpacidade);
        panel_icon1.setBackground(pretoComOpacidade);
        panel_icon2.setBackground(pretoComOpacidade);
        panel_icon3.setBackground(pretoComOpacidade);
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
        panelGradienteHorizontal1 = new Visualizacao.PanelGradienteHorizontal();
        panelPretoOpac1 = new Visualizacao.PanelPretoOpac();
        panelRound1 = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelRound3 = new Visualizacao.PanelRound();
        placeholderTextField1 = new Visualizacao.PlaceholderTextField();
        jLabel2 = new javax.swing.JLabel();
        panelGradienteHorizontal2 = new Visualizacao.PanelGradienteHorizontal();
        panel_sombra = new Visualizacao.PanelRound();
        panel_icon1 = new Visualizacao.PanelSombra();
        panel_icon2 = new Visualizacao.PanelSombra();
        panel_icon3 = new Visualizacao.PanelSombra();
        panelSombra1 = new Visualizacao.PanelSombra();
        panelSombra2 = new Visualizacao.PanelSombra();
        panelSombra3 = new Visualizacao.PanelSombra();
        panelSombra4 = new Visualizacao.PanelSombra();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Opções");

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

        panelRound3.setBackground(new java.awt.Color(72, 72, 72));
        panelRound3.setRoundBottomLeft(40);
        panelRound3.setRoundBottomRight(40);
        panelRound3.setRoundTopLeft(40);
        panelRound3.setRoundTopRight(40);

        placeholderTextField1.setBackground(new java.awt.Color(72, 72, 72));
        placeholderTextField1.setBorder(null);
        placeholderTextField1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        placeholderTextField1.setPlaceholder("Pesquise Atividade");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-pesquisa.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(placeholderTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placeholderTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        panelGradienteHorizontal2.setRadius(50);

        panel_sombra.setBackground(new java.awt.Color(204, 204, 204));
        panel_sombra.setRoundBottomLeft(50);
        panel_sombra.setRoundBottomRight(50);
        panel_sombra.setRoundTopLeft(50);
        panel_sombra.setRoundTopRight(50);

        panel_icon1.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon1.setCornerRadius(100);
        panel_icon1.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon1.setShadowOpacity(0.3F);
        panel_icon1.setShadowSize(3);
        panel_icon1.setShadowType(Visualizacao.ShadowType.BOT);

        javax.swing.GroupLayout panel_icon1Layout = new javax.swing.GroupLayout(panel_icon1);
        panel_icon1.setLayout(panel_icon1Layout);
        panel_icon1Layout.setHorizontalGroup(
            panel_icon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_icon1Layout.setVerticalGroup(
            panel_icon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panel_icon2.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon2.setCornerRadius(100);
        panel_icon2.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon2.setShadowOpacity(0.3F);
        panel_icon2.setShadowSize(3);
        panel_icon2.setShadowType(Visualizacao.ShadowType.BOT);

        javax.swing.GroupLayout panel_icon2Layout = new javax.swing.GroupLayout(panel_icon2);
        panel_icon2.setLayout(panel_icon2Layout);
        panel_icon2Layout.setHorizontalGroup(
            panel_icon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_icon2Layout.setVerticalGroup(
            panel_icon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panel_icon3.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon3.setCornerRadius(100);
        panel_icon3.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon3.setShadowOpacity(0.3F);
        panel_icon3.setShadowSize(3);
        panel_icon3.setShadowType(Visualizacao.ShadowType.BOT);

        javax.swing.GroupLayout panel_icon3Layout = new javax.swing.GroupLayout(panel_icon3);
        panel_icon3.setLayout(panel_icon3Layout);
        panel_icon3Layout.setHorizontalGroup(
            panel_icon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_icon3Layout.setVerticalGroup(
            panel_icon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_sombraLayout = new javax.swing.GroupLayout(panel_sombra);
        panel_sombra.setLayout(panel_sombraLayout);
        panel_sombraLayout.setHorizontalGroup(
            panel_sombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_sombraLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(panel_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(panel_icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(panel_icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_sombraLayout.setVerticalGroup(
            panel_sombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_sombraLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panel_sombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_icon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_icon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_icon3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout panelGradienteHorizontal2Layout = new javax.swing.GroupLayout(panelGradienteHorizontal2);
        panelGradienteHorizontal2.setLayout(panelGradienteHorizontal2Layout);
        panelGradienteHorizontal2Layout.setHorizontalGroup(
            panelGradienteHorizontal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_sombra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradienteHorizontal2Layout.setVerticalGroup(
            panelGradienteHorizontal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_sombra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelSombra1.setBackground(new java.awt.Color(239, 91, 106));
        panelSombra1.setCornerRadius(40);
        panelSombra1.setShadowOpacity(0.3F);
        panelSombra1.setShadowSize(3);
        panelSombra1.setShadowType(Visualizacao.ShadowType.BOT_LEFT);

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        panelSombra2.setBackground(new java.awt.Color(83, 194, 242));
        panelSombra2.setCornerRadius(40);
        panelSombra2.setShadowOpacity(0.3F);
        panelSombra2.setShadowSize(3);
        panelSombra2.setShadowType(Visualizacao.ShadowType.BOT_LEFT);

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        panelSombra3.setBackground(new java.awt.Color(128, 210, 91));
        panelSombra3.setCornerRadius(40);
        panelSombra3.setShadowOpacity(0.3F);
        panelSombra3.setShadowSize(3);
        panelSombra3.setShadowType(Visualizacao.ShadowType.BOT_LEFT);

        javax.swing.GroupLayout panelSombra3Layout = new javax.swing.GroupLayout(panelSombra3);
        panelSombra3.setLayout(panelSombra3Layout);
        panelSombra3Layout.setHorizontalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        panelSombra3Layout.setVerticalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        panelSombra4.setBackground(new java.awt.Color(255, 179, 0));
        panelSombra4.setCornerRadius(40);
        panelSombra4.setShadowOpacity(0.3F);
        panelSombra4.setShadowSize(3);
        panelSombra4.setShadowType(Visualizacao.ShadowType.BOT_LEFT);

        javax.swing.GroupLayout panelSombra4Layout = new javax.swing.GroupLayout(panelSombra4);
        panelSombra4.setLayout(panelSombra4Layout);
        panelSombra4Layout.setHorizontalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        panelSombra4Layout.setVerticalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addComponent(jLabel1)
                            .addGap(105, 105, 105)
                            .addComponent(jLabel13))
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelGradienteHorizontal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(48, 48, 48)
                .addComponent(panelGradienteHorizontal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPretoOpac1Layout = new javax.swing.GroupLayout(panelPretoOpac1);
        panelPretoOpac1.setLayout(panelPretoOpac1Layout);
        panelPretoOpac1Layout.setHorizontalGroup(
            panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPretoOpac1Layout.setVerticalGroup(
            panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPretoOpac1Layout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelGradienteHorizontal1Layout = new javax.swing.GroupLayout(panelGradienteHorizontal1);
        panelGradienteHorizontal1.setLayout(panelGradienteHorizontal1Layout);
        panelGradienteHorizontal1Layout.setHorizontalGroup(
            panelGradienteHorizontal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradienteHorizontal1Layout.setVerticalGroup(
            panelGradienteHorizontal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        customScrollPane1.setViewportView(panelGradienteHorizontal1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private Visualizacao.PanelGradienteHorizontal panelGradienteHorizontal1;
    private Visualizacao.PanelGradienteHorizontal panelGradienteHorizontal2;
    private Visualizacao.PanelPretoOpac panelPretoOpac1;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRound panelRound3;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra3;
    private Visualizacao.PanelSombra panelSombra4;
    private Visualizacao.PanelSombra panel_icon1;
    private Visualizacao.PanelSombra panel_icon2;
    private Visualizacao.PanelSombra panel_icon3;
    private Visualizacao.PanelRound panel_sombra;
    private Visualizacao.PlaceholderTextField placeholderTextField1;
    // End of variables declaration//GEN-END:variables
}
