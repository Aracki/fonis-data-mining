/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.leftPanels;

import controller.Data;
import controller.TableSingleton;
import java.io.File;
import javax.swing.JOptionPane;
import model.converter.ConvertToInstances;
import view.centerPanels.LoadedInstancesCentralPanel;
import view.main.MainGUI;
import weka.core.Instances;

/**
 *
 * @author Vlada
 */
public class ConfirmTablepnlLeft extends javax.swing.JPanel {

    /**
     * Creates new form ConfirmTablePanel
     */
    public ConfirmTablepnlLeft() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirm = new javax.swing.JButton();

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnConfirm)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
       
      
        for (int i = 0; i < NewTablePnlLeft.numOfInstances; i++) {
            for (int j = 0; j < NewTablePnlLeft.numOfAttributes; j++) {
                if (TableSingleton.getInstance().getData()[i][j]==null || TableSingleton.getInstance().getData()[i][j].equals("")) {
                    JOptionPane.showMessageDialog(null, "You must enter values in all table cells!");
                    return;
                }
            }
        }
        
        ConvertToInstances conv = new ConvertToInstances();
       
        File outputFile = new File("files/file1.csv");
        conv.convertTableToCSV(outputFile);
        Instances instance = conv.convertCSVToInstances(new File("files/file1.csv"));
        Data.getInstance().setInstances(instance);
    
        outputFile.delete();
        
     LoadedInstancesCentralPanel panel = new LoadedInstancesCentralPanel();
            panel.setSize(MainGUI.getInstance().getPnlCenter().getSize());
            Data.getInstance().setLoadedInstancesCentralPanel(panel);
            MainGUI.getInstance().getPnlCenter().removeAll();
            MainGUI.getInstance().getPnlCenter().add(panel);
            MainGUI.getInstance().validate();
            MainGUI.getInstance().repaint();
            
            panel.setVisible(true);
            JOptionPane.showMessageDialog(null, "Your data has been added successfully.");
          
    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    // End of variables declaration//GEN-END:variables
}