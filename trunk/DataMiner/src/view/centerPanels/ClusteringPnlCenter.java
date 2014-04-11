/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.centerPanels;

import controller.Data;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.clustering.ClusterIO;
import view.main.MainGUI;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;




/**
 *
 * @author Stupi
 */
public class ClusteringPnlCenter extends javax.swing.JPanel {

    private SimpleKMeans simpleKMeans;
    
    /**
     * Creates new form ClusteringPnlCenter
     */
    public ClusteringPnlCenter(SimpleKMeans kMeans, ClusterEvaluation eval) {
        initComponents();
        setSize(MainGUI.getInstance().getPnlCenter().getWidth(), MainGUI.getInstance().getPnlCenter().getHeight());

        simpleKMeans = kMeans;
        
        //treba ispisati sta da ispise
        String text = eval.clusterResultsToString();

        String [] textArray = text.split("\n");
        for (int i = 13; i < textArray.length; i++) {
            txtArea.setText(txtArea.getText() + textArray[i] + "\n");
        }
        
//        txtArea.setText(eval.clusterResultsToString());

        setVisible(true);
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        txtSave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPredict = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setToolTipText("");
        jScrollPane1.setViewportView(txtArea);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Save as:");

        btnPredict.setText("Predict");
        btnPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredictActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPredict)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnPredict))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        ClusterIO clusterIO = new ClusterIO();
        
        Instances data = Data.getInstance().getInstances();
        
        String fileName = txtSave.getText().trim();
        if (fileName.length() == 0)
            JOptionPane.showMessageDialog(this, "You need to enter the name for saving.");
        
        
        if (clusterIO.updateTxtFile(fileName) == false) {
            JOptionPane.showMessageDialog(this, "This name already exist.");
        }
        clusterIO.writeInstanceObject(fileName, data);
        clusterIO.writeKMeansObject(fileName, simpleKMeans);
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredictActionPerformed
        
        MainGUI.getInstance().getPnlCenter().removeAll();
        
        MainGUI.getInstance().getPnlCenter().add(new ClusteringPredictPnlCenter(simpleKMeans));
        
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
        
        
        
    }//GEN-LAST:event_btnPredictActionPerformed

    public JTextArea getTxtArea() {
        return txtArea;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPredict;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtSave;
    // End of variables declaration//GEN-END:variables
}