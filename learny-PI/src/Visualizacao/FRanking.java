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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class FRanking extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private Aluno alunoLogado;
    private int idAluno;
    ArrayList<Double> pontosAlunos = new ArrayList<Double>();

    /**
     * Creates new form FRanking
     */
    public FRanking() {
        initComponents();
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
        idAluno = alunoLogado.getIdAluno();
        double pontos = alunoLogado.getPontosTotais();
        String ranque = alunoLogado.getRanque();
        
        lbl_pontos.setText(Double.toString(pontos));
        lbl_ranque.setText(ranque+"º");
        
        String verConquistas = "select count(*) from alunosXconquistas where idAluno = ?";
        try {
            pst = conexao.prepareStatement(verConquistas);
            pst.setInt(1, idAluno);
            rs = pst.executeQuery();

            if (rs.next()) {
                int qtdMedalhas = rs.getInt(1);
                lbl_medalhas.setText(Integer.toString(qtdMedalhas));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        Color pretoComOpacidade = new Color(0, 0, 0, 75);
        panel_ranking_opac.setBackground(pretoComOpacidade);
        this.setLayout(new BorderLayout());
        this.add(customScrollPane1, BorderLayout.CENTER);
        this.add(menu, BorderLayout.SOUTH);
        carregarPontos();
        ordenarPontos();
        exibirPontosOrdenados();
    }   

    private void carregarPontos() {
        String sql = "SELECT nome, pontosTotais FROM alunos";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                double pontosTotais = rs.getDouble("pontosTotais");
                pontosAlunos.add(pontosTotais);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void merge(ArrayList<Double> v, int inicio, int meio, int fim) {
        ArrayList<Double> aux = new ArrayList<>(v.subList(inicio, fim + 1));

        int i = 0;
        int j = meio - inicio + 1;
        int k = inicio;

        while (i <= meio - inicio && j <= fim - inicio) {
            if (aux.get(i) >= aux.get(j)) {
                v.set(k, aux.get(i));
                i++;
            } else {
                v.set(k, aux.get(j));
                j++;
            }
            k++;
        }

        while (i <= meio - inicio) {
            v.set(k, aux.get(i));
            i++;
            k++;
        }

        while (j <= fim - inicio) {
            v.set(k, aux.get(j));
            j++;
            k++;
        }
    }

    private void mergesort(ArrayList<Double> v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergesort(v, inicio, meio);
            mergesort(v, meio + 1, fim);
            merge(v, inicio, meio, fim);
        }
    }

    public void ordenarPontos() {
        if (!pontosAlunos.isEmpty()) {
            mergesort(pontosAlunos, 0, pontosAlunos.size() - 1);
        }
    }
    
    public void exibirPontosOrdenados() {
        JLabel[] lblsNomes = {lbl_nome1, lbl_nome2, lbl_nome3, lbl_nome4, lbl_nome5, lbl_nome6, lbl_nome7};
        JLabel[] lblsPontos = {lbl_pontos1, lbl_pontos2, lbl_pontos3, lbl_pontos4, lbl_pontos5, lbl_pontos6, lbl_pontos7};
        PanelRoundBorda[] panelsFotos = {panel_foto1, panel_foto2, panel_foto3};
        int i  = 0;
        for (double ponto : pontosAlunos) {
            if (i >= lblsNomes.length) {
                break; // Interrompe o loop após preencher todas as labels disponíveis
            }
            String sql = "SELECT idAluno, nome, pontosTotais, foto FROM alunos where pontosTotais = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setDouble(1,  ponto);
                rs = pst.executeQuery();

                while (rs.next()) {
                    int idAluno = rs.getInt("idAluno");
                    String nomeAluno = rs.getString("nome");
                    String fotoAluno = rs.getString("foto");
                    lblsNomes[i].setText(nomeAluno);
                    lblsPontos[i].setText(String.valueOf(ponto));
                    if (i < panelsFotos.length) {
                        panelsFotos[i].setImg(new ImageIcon("src/Imagens/" + fotoAluno));
                    }
                    String alteraRank;
                    alteraRank = "update alunos set ranque = ? where idAluno = ?";
                    try {
                        pst = conexao.prepareStatement(alteraRank);
                        pst.setInt(1, i+1);
                        pst.setInt(2, idAluno);
                        alunoLogado.setRanque(String.valueOf(i+1));

                        pst.executeUpdate();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            i++;
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

        menu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        menuHamburguer = new javax.swing.JLabel();
        customScrollPane1 = new Visualizacao.CustomScrollPane();
        panel_principal = new javax.swing.JPanel();
        panelRound1 = new Visualizacao.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panel_foto1 = new Visualizacao.PanelRoundBorda();
        jLabel1 = new javax.swing.JLabel();
        panelRoundBorda3 = new Visualizacao.PanelRoundBorda();
        jLabel6 = new javax.swing.JLabel();
        lbl_nome1 = new javax.swing.JLabel();
        lbl_pontos1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panel_foto2 = new Visualizacao.PanelRoundBorda();
        panelRoundBorda12 = new Visualizacao.PanelRoundBorda();
        jLabel14 = new javax.swing.JLabel();
        lbl_nome2 = new javax.swing.JLabel();
        lbl_pontos2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        panel_foto3 = new Visualizacao.PanelRoundBorda();
        panelRoundBorda14 = new Visualizacao.PanelRoundBorda();
        jLabel15 = new javax.swing.JLabel();
        lbl_nome3 = new javax.swing.JLabel();
        lbl_pontos3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelRound2 = new Visualizacao.PanelRound();
        panel_ranking_opac = new Visualizacao.PanelRound();
        customSeparator1 = new Visualizacao.CustomSeparator();
        panelRoundBorda7 = new Visualizacao.PanelRoundBorda();
        jLabel8 = new javax.swing.JLabel();
        lbl_nome4 = new javax.swing.JLabel();
        lbl_pontos4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_nome5 = new javax.swing.JLabel();
        lbl_pontos5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        customSeparator4 = new Visualizacao.CustomSeparator();
        panelRoundBorda15 = new Visualizacao.PanelRoundBorda();
        jLabel17 = new javax.swing.JLabel();
        lbl_nome6 = new javax.swing.JLabel();
        lbl_pontos6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        customSeparator5 = new Visualizacao.CustomSeparator();
        panelRoundBorda16 = new Visualizacao.PanelRoundBorda();
        lbl_nome7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_pontos7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelRoundBorda17 = new Visualizacao.PanelRoundBorda();
        panelSombra6 = new Visualizacao.PanelSombra();
        lbl_ranque = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelSombra7 = new Visualizacao.PanelSombra();
        lbl_pontos = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        panelSombra5 = new Visualizacao.PanelSombra();
        lbl_medalhas = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        menu.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone perfil.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone home.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        menuHamburguer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone menu hamburguer.png"))); // NOI18N
        menuHamburguer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(104, 104, 104)
                .addComponent(menuHamburguer)
                .addGap(49, 49, 49))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuHamburguer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panel_principal.setBackground(new java.awt.Color(108, 210, 255));
        panel_principal.setPreferredSize(new java.awt.Dimension(475, 1171));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(80);
        panelRound1.setRoundTopRight(80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        panel_foto1.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto1.setBorderWidth(5);
        panel_foto1.setPreferredSize(new java.awt.Dimension(65, 65));
        panel_foto1.setRadius(100);

        javax.swing.GroupLayout panel_foto1Layout = new javax.swing.GroupLayout(panel_foto1);
        panel_foto1.setLayout(panel_foto1Layout);
        panel_foto1Layout.setHorizontalGroup(
            panel_foto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_foto1Layout.setVerticalGroup(
            panel_foto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 72, 72));
        jLabel1.setText("Ranking");

        panelRoundBorda3.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda3.setBorderWidth(5);
        panelRoundBorda3.setPreferredSize(new java.awt.Dimension(284, 69));
        panelRoundBorda3.setRadius(30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(247, 202, 13));
        jLabel6.setText("1º");

        lbl_nome1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nome1.setForeground(new java.awt.Color(72, 72, 72));
        lbl_nome1.setText("nome");
        lbl_nome1.setPreferredSize(new java.awt.Dimension(149, 20));

        lbl_pontos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_pontos1.setForeground(new java.awt.Color(72, 72, 72));
        lbl_pontos1.setText("100");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(72, 72, 72));
        jLabel16.setText("pts");

        javax.swing.GroupLayout panelRoundBorda3Layout = new javax.swing.GroupLayout(panelRoundBorda3);
        panelRoundBorda3.setLayout(panelRoundBorda3Layout);
        panelRoundBorda3Layout.setHorizontalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pontos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelRoundBorda3Layout.setVerticalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_pontos1)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        panel_foto2.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto2.setBorderWidth(5);
        panel_foto2.setPreferredSize(new java.awt.Dimension(65, 65));
        panel_foto2.setRadius(100);

        javax.swing.GroupLayout panel_foto2Layout = new javax.swing.GroupLayout(panel_foto2);
        panel_foto2.setLayout(panel_foto2Layout);
        panel_foto2Layout.setHorizontalGroup(
            panel_foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_foto2Layout.setVerticalGroup(
            panel_foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelRoundBorda12.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda12.setBorderWidth(5);
        panelRoundBorda12.setPreferredSize(new java.awt.Dimension(284, 69));
        panelRoundBorda12.setRadius(30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(165, 166, 168));
        jLabel14.setText("2º");

        lbl_nome2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nome2.setForeground(new java.awt.Color(72, 72, 72));
        lbl_nome2.setText("nome");
        lbl_nome2.setPreferredSize(new java.awt.Dimension(149, 20));

        lbl_pontos2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_pontos2.setForeground(new java.awt.Color(72, 72, 72));
        lbl_pontos2.setText("100");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(72, 72, 72));
        jLabel21.setText("pts");

        javax.swing.GroupLayout panelRoundBorda12Layout = new javax.swing.GroupLayout(panelRoundBorda12);
        panelRoundBorda12.setLayout(panelRoundBorda12Layout);
        panelRoundBorda12Layout.setHorizontalGroup(
            panelRoundBorda12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pontos2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelRoundBorda12Layout.setVerticalGroup(
            panelRoundBorda12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRoundBorda12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pontos2)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        panel_foto3.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto3.setBorderWidth(5);
        panel_foto3.setPreferredSize(new java.awt.Dimension(65, 65));
        panel_foto3.setRadius(100);

        javax.swing.GroupLayout panel_foto3Layout = new javax.swing.GroupLayout(panel_foto3);
        panel_foto3.setLayout(panel_foto3Layout);
        panel_foto3Layout.setHorizontalGroup(
            panel_foto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panel_foto3Layout.setVerticalGroup(
            panel_foto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelRoundBorda14.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda14.setBorderWidth(5);
        panelRoundBorda14.setPreferredSize(new java.awt.Dimension(284, 69));
        panelRoundBorda14.setRadius(30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(169, 68, 36));
        jLabel15.setText("3º");

        lbl_nome3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nome3.setForeground(new java.awt.Color(72, 72, 72));
        lbl_nome3.setText("nome");
        lbl_nome3.setPreferredSize(new java.awt.Dimension(149, 20));

        lbl_pontos3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_pontos3.setForeground(new java.awt.Color(72, 72, 72));
        lbl_pontos3.setText("100");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(72, 72, 72));
        jLabel22.setText("pts");

        javax.swing.GroupLayout panelRoundBorda14Layout = new javax.swing.GroupLayout(panelRoundBorda14);
        panelRoundBorda14.setLayout(panelRoundBorda14Layout);
        panelRoundBorda14Layout.setHorizontalGroup(
            panelRoundBorda14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nome3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pontos3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelRoundBorda14Layout.setVerticalGroup(
            panelRoundBorda14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRoundBorda14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pontos3)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nome3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setImg(new ImageIcon("src/Imagens/terra.png"));

        panel_ranking_opac.setBackground(new java.awt.Color(153, 153, 153));
        panel_ranking_opac.setRoundBottomLeft(40);
        panel_ranking_opac.setRoundBottomRight(40);
        panel_ranking_opac.setRoundTopLeft(40);
        panel_ranking_opac.setRoundTopRight(40);

        customSeparator1.setColor(new java.awt.Color(255, 255, 255));
        customSeparator1.setThickness(3);

        panelRoundBorda7.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda7.setBorderWidth(5);
        panelRoundBorda7.setPreferredSize(new java.awt.Dimension(35, 35));
        panelRoundBorda7.setRadius(100);

        javax.swing.GroupLayout panelRoundBorda7Layout = new javax.swing.GroupLayout(panelRoundBorda7);
        panelRoundBorda7.setLayout(panelRoundBorda7Layout);
        panelRoundBorda7Layout.setHorizontalGroup(
            panelRoundBorda7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelRoundBorda7Layout.setVerticalGroup(
            panelRoundBorda7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("4º");

        lbl_nome4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nome4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome4.setText("nome");

        lbl_pontos4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pontos4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pontos4.setText("100");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("pts");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("5º");

        lbl_nome5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nome5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome5.setText("nome");

        lbl_pontos5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pontos5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pontos5.setText("100");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("pts");

        customSeparator4.setColor(new java.awt.Color(255, 255, 255));
        customSeparator4.setThickness(3);

        panelRoundBorda15.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda15.setBorderWidth(5);
        panelRoundBorda15.setPreferredSize(new java.awt.Dimension(35, 35));
        panelRoundBorda15.setRadius(100);

        javax.swing.GroupLayout panelRoundBorda15Layout = new javax.swing.GroupLayout(panelRoundBorda15);
        panelRoundBorda15.setLayout(panelRoundBorda15Layout);
        panelRoundBorda15Layout.setHorizontalGroup(
            panelRoundBorda15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelRoundBorda15Layout.setVerticalGroup(
            panelRoundBorda15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("6º");

        lbl_nome6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nome6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome6.setText("nome");

        lbl_pontos6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pontos6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pontos6.setText("100");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("pts");

        customSeparator5.setColor(new java.awt.Color(255, 255, 255));
        customSeparator5.setThickness(3);

        panelRoundBorda16.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda16.setBorderWidth(5);
        panelRoundBorda16.setPreferredSize(new java.awt.Dimension(35, 35));
        panelRoundBorda16.setRadius(100);

        javax.swing.GroupLayout panelRoundBorda16Layout = new javax.swing.GroupLayout(panelRoundBorda16);
        panelRoundBorda16.setLayout(panelRoundBorda16Layout);
        panelRoundBorda16Layout.setHorizontalGroup(
            panelRoundBorda16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelRoundBorda16Layout.setVerticalGroup(
            panelRoundBorda16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        lbl_nome7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nome7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome7.setText("nome");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("7º");

        lbl_pontos7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pontos7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pontos7.setText("100");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("pts");

        panelRoundBorda17.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda17.setBorderWidth(5);
        panelRoundBorda17.setPreferredSize(new java.awt.Dimension(35, 35));
        panelRoundBorda17.setRadius(100);

        javax.swing.GroupLayout panelRoundBorda17Layout = new javax.swing.GroupLayout(panelRoundBorda17);
        panelRoundBorda17.setLayout(panelRoundBorda17Layout);
        panelRoundBorda17Layout.setHorizontalGroup(
            panelRoundBorda17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelRoundBorda17Layout.setVerticalGroup(
            panelRoundBorda17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_ranking_opacLayout = new javax.swing.GroupLayout(panel_ranking_opac);
        panel_ranking_opac.setLayout(panel_ranking_opacLayout);
        panel_ranking_opacLayout.setHorizontalGroup(
            panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ranking_opacLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundBorda7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nome4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pontos4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nome5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pontos5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(customSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nome6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pontos6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(customSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nome7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pontos7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        panel_ranking_opacLayout.setVerticalGroup(
            panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRoundBorda7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_pontos4)))
                        .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nome4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(customSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_pontos5)))
                        .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nome5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRoundBorda15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(customSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_pontos6)))
                        .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nome6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRoundBorda16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(customSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_ranking_opacLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_pontos7)))
                        .addGroup(panel_ranking_opacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nome7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRoundBorda17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panel_ranking_opac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panel_ranking_opac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panel_foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(panelRoundBorda3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addComponent(panel_foto2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(panelRoundBorda12, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panel_foto3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(panelRoundBorda14, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(67, 67, 67)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_foto2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_foto3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelSombra6.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra6.setPreferredSize(new java.awt.Dimension(131, 47));
        panelSombra6.setShadowOpacity(0.3F);

        lbl_ranque.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_ranque.setForeground(new java.awt.Color(72, 72, 72));
        lbl_ranque.setText("1");
        lbl_ranque.setToolTipText("");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-estrela.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra6Layout = new javax.swing.GroupLayout(panelSombra6);
        panelSombra6.setLayout(panelSombra6Layout);
        panelSombra6Layout.setHorizontalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra6Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lbl_ranque)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelSombra6Layout.setVerticalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_ranque)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSombra7.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra7.setPreferredSize(new java.awt.Dimension(131, 54));
        panelSombra7.setShadowOpacity(0.3F);

        lbl_pontos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pontos.setForeground(new java.awt.Color(72, 72, 72));
        lbl_pontos.setText("100");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-fogo.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra7Layout = new javax.swing.GroupLayout(panelSombra7);
        panelSombra7.setLayout(panelSombra7Layout);
        panelSombra7Layout.setHorizontalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra7Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pontos)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelSombra7Layout.setVerticalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra7Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panelSombra7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_pontos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSombra5.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra5.setPreferredSize(new java.awt.Dimension(131, 47));
        panelSombra5.setShadowOpacity(0.3F);

        lbl_medalhas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_medalhas.setForeground(new java.awt.Color(72, 72, 72));
        lbl_medalhas.setText("10");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-moeda.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra5Layout = new javax.swing.GroupLayout(panelSombra5);
        panelSombra5.setLayout(panelSombra5Layout);
        panelSombra5Layout.setHorizontalGroup(
            panelSombra5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra5Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(lbl_medalhas)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelSombra5Layout.setVerticalGroup(
            panelSombra5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_medalhas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSombra5Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(panelSombra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSombra5, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(panelSombra6, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customScrollPane1.setViewportView(panel_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9jLabel1MouseClicked
        new FPerfil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9jLabel1MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel10MouseExited

    private void menuHamburguerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuHamburguerMouseEntered

    private void menuHamburguerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuHamburguerMouseExited

    private void menuHamburguerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseClicked
        new FOpcoes().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuHamburguerMouseClicked
  
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
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private Visualizacao.CustomSeparator customSeparator1;
    private Visualizacao.CustomSeparator customSeparator4;
    private Visualizacao.CustomSeparator customSeparator5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_medalhas;
    private javax.swing.JLabel lbl_nome1;
    private javax.swing.JLabel lbl_nome2;
    private javax.swing.JLabel lbl_nome3;
    private javax.swing.JLabel lbl_nome4;
    private javax.swing.JLabel lbl_nome5;
    private javax.swing.JLabel lbl_nome6;
    private javax.swing.JLabel lbl_nome7;
    private javax.swing.JLabel lbl_pontos;
    private javax.swing.JLabel lbl_pontos1;
    private javax.swing.JLabel lbl_pontos2;
    private javax.swing.JLabel lbl_pontos3;
    private javax.swing.JLabel lbl_pontos4;
    private javax.swing.JLabel lbl_pontos5;
    private javax.swing.JLabel lbl_pontos6;
    private javax.swing.JLabel lbl_pontos7;
    private javax.swing.JLabel lbl_ranque;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel menuHamburguer;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRound panelRound2;
    private Visualizacao.PanelRoundBorda panelRoundBorda12;
    private Visualizacao.PanelRoundBorda panelRoundBorda14;
    private Visualizacao.PanelRoundBorda panelRoundBorda15;
    private Visualizacao.PanelRoundBorda panelRoundBorda16;
    private Visualizacao.PanelRoundBorda panelRoundBorda17;
    private Visualizacao.PanelRoundBorda panelRoundBorda3;
    private Visualizacao.PanelRoundBorda panelRoundBorda7;
    private Visualizacao.PanelSombra panelSombra5;
    private Visualizacao.PanelSombra panelSombra6;
    private Visualizacao.PanelSombra panelSombra7;
    private Visualizacao.PanelRoundBorda panel_foto1;
    private Visualizacao.PanelRoundBorda panel_foto2;
    private Visualizacao.PanelRoundBorda panel_foto3;
    private javax.swing.JPanel panel_principal;
    private Visualizacao.PanelRound panel_ranking_opac;
    // End of variables declaration//GEN-END:variables
}
