/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Stupi
 */
public class MainGUI extends javax.swing.JFrame {

    private static MainGUI instance = null;

    public static MainGUI getInstance() {
        if (instance == null) {
            instance = new MainGUI();
        }
        return instance;
    }

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Data Miner");
        BufferedImage icon = null;
        try {
            File file = new File("C:/Users/Stupi/Desktop/ikonica.PNG");
            icon = ImageIO.read(file);
        } catch (Exception e) {

        }
        setIconImage(icon);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        mitNew = new javax.swing.JMenuItem();
        mitOpen = new javax.swing.JMenuItem();
        menuDataMining = new javax.swing.JMenu();
        mitClassification = new javax.swing.JMenuItem();
        mitClustering = new javax.swing.JMenuItem();
        menuStatistics = new javax.swing.JMenu();
        mitDescriptiveStatistic = new javax.swing.JMenuItem();
        mitOneSampleTtest = new javax.swing.JMenuItem();
        mitTwoSamplesTtest = new javax.swing.JMenuItem();
        mitKolmogorovSmirnov = new javax.swing.JMenuItem();
        menuVisualization = new javax.swing.JMenu();
        mitVisualize = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLeft.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlLeft.setMaximumSize(new java.awt.Dimension(300, 32767));
        pnlLeft.setMinimumSize(new java.awt.Dimension(200, 100));

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(pnlLeft, java.awt.BorderLayout.LINE_START);

        pnlCenter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCenter.setMaximumSize(new java.awt.Dimension(700, 32767));

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        menuFile.setText("File");

        mitNew.setText("New");
        menuFile.add(mitNew);

        mitOpen.setText("Open");
        menuFile.add(mitOpen);

        jMenuBar1.add(menuFile);

        menuDataMining.setText("Data Mining");

        mitClassification.setText("Classification");
        mitClassification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitClassificationActionPerformed(evt);
            }
        });
        menuDataMining.add(mitClassification);

        mitClustering.setText("Clustering");
        menuDataMining.add(mitClustering);

        jMenuBar1.add(menuDataMining);

        menuStatistics.setText("Statistics");

        mitDescriptiveStatistic.setText("Descriptive Statistic");
        menuStatistics.add(mitDescriptiveStatistic);

        mitOneSampleTtest.setText("One Sample T-test");
        menuStatistics.add(mitOneSampleTtest);

        mitTwoSamplesTtest.setText("Two Samples T-test");
        menuStatistics.add(mitTwoSamplesTtest);

        mitKolmogorovSmirnov.setText("Kolmogorov-Smirnov test");
        menuStatistics.add(mitKolmogorovSmirnov);

        jMenuBar1.add(menuStatistics);

        menuVisualization.setText("Visualization");

        mitVisualize.setText("Visualize");
        menuVisualization.add(mitVisualize);

        jMenuBar1.add(menuVisualization);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitClassificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitClassificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitClassificationActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    public void addOpenListener(ActionListener listener) {
        mitOpen.addActionListener(listener);
    }

    public void addClassificationListener(ActionListener listener) {
        mitClassification.addActionListener(listener);
    }

    public void addClusteringListener(ActionListener listener) {
        mitClustering.addActionListener(listener);
    }

    public void addVisualizeListener(ActionListener listener) {
        mitVisualize.addActionListener(listener);
    }

    public void addNewListener(ActionListener listener) {
        mitNew.addActionListener(listener);
    }

    public void addDescriptiveStatisticListener(ActionListener listener) {
        mitDescriptiveStatistic.addActionListener(listener);
    }

    public void addOneSampleTTest(ActionListener listener) {
        mitOneSampleTtest.addActionListener(listener);
    }

    public void addTwoSamplesTTest(ActionListener listener) {
        mitTwoSamplesTtest.addActionListener(listener);
    }

    public void addKolmogorovSmirnov(ActionListener listener) {
        mitKolmogorovSmirnov.addActionListener(listener);
    }

    public JPanel getPnlLeft() {
        return pnlLeft;
    }

    public JPanel getPnlCenter() {
        return pnlCenter;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuDataMining;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuStatistics;
    private javax.swing.JMenu menuVisualization;
    private javax.swing.JMenuItem mitClassification;
    private javax.swing.JMenuItem mitClustering;
    private javax.swing.JMenuItem mitDescriptiveStatistic;
    private javax.swing.JMenuItem mitKolmogorovSmirnov;
    private javax.swing.JMenuItem mitNew;
    private javax.swing.JMenuItem mitOneSampleTtest;
    private javax.swing.JMenuItem mitOpen;
    private javax.swing.JMenuItem mitTwoSamplesTtest;
    private javax.swing.JMenuItem mitVisualize;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlLeft;
    // End of variables declaration//GEN-END:variables
}