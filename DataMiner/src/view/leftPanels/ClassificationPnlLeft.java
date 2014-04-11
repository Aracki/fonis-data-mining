/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.leftPanels;

import com.sun.corba.se.spi.ior.IORFactories;
import controller.Data;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.centerPanels.ClassificationPnlCenterPredict;
import view.centerPanels.ClassificationPnlCenterTrainNew;
import view.main.MainGUI;
import weka.core.Instances;

/**
 *
 * @author Dusan Dudukovic
 */
public class ClassificationPnlLeft extends javax.swing.JPanel {

    String selectedModel;

    Instances data = Data.getInstance().getInstances();

    /**
     * Creates new form NewJPanel
     */
    public ClassificationPnlLeft() {
        initComponents();

        setSize(MainGUI.getInstance().getPnlCenter().getWidth(), MainGUI.getInstance().getPnlCenter().getHeight());
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

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnPredict = new javax.swing.JButton();
        jBtnTrainNew = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setText("Train new");

        jBtnPredict.setText("Predict");
        jBtnPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPredictActionPerformed(evt);
            }
        });

        jBtnTrainNew.setText("Train new");
        jBtnTrainNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrainNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jBtnPredict)
                    .addComponent(jBtnTrainNew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jBtnTrainNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jBtnPredict)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPredictActionPerformed

        if (data != null) {

            MainGUI.getInstance().getPnlCenter().removeAll();
            MainGUI.getInstance().getPnlCenter().add(new ClassificationPnlCenterPredict());
            MainGUI.getInstance().getPnlCenter().validate();
            MainGUI.getInstance().getPnlCenter().repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Open .csv file");
        }
    }//GEN-LAST:event_jBtnPredictActionPerformed

    private void jBtnTrainNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrainNewActionPerformed

        if (data != null) {
            MainGUI.getInstance().getPnlCenter().removeAll();
            MainGUI.getInstance().getPnlCenter().add(new ClassificationPnlCenterTrainNew());
            MainGUI.getInstance().getPnlCenter().validate();
            MainGUI.getInstance().getPnlCenter().repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Open .csv file");
        }
    }//GEN-LAST:event_jBtnTrainNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnPredict;
    private javax.swing.JButton jBtnTrainNew;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}