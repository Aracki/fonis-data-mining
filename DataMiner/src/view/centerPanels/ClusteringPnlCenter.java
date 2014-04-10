/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.centerPanels;

import javax.swing.JTextArea;
import view.main.MainGUI;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;

/**
 *
 * @author Stupi
 */
public class ClusteringPnlCenter extends javax.swing.JPanel {

    /**
     * Creates new form ClusteringPnlCenter
     */
    public ClusteringPnlCenter(SimpleKMeans kMeans, ClusterEvaluation eval) {
        initComponents();
        setSize(MainGUI.getInstance().getPnlCenter().getWidth(), MainGUI.getInstance().getPnlCenter().getHeight());

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

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setToolTipText("");
        jScrollPane1.setViewportView(txtArea);

        btnSave.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextArea getTxtArea() {
        return txtArea;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}