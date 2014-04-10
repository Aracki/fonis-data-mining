/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.centerPanels;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import weka.core.Instances;

/**
 *
 * @author Stupi
 */
public class ClusteringAttributesPnl extends javax.swing.JPanel {

    
    
    
    /**
     * Creates new form ClusteringAttributesPnl
     */
    public ClusteringAttributesPnl(Instances instances, ArrayList<JTextField> fields) {
        initComponents();
        
        int numAttributes = instances.numAttributes();
       
        setLayout(new FlowLayout((int) LEFT_ALIGNMENT));
        for (int i = 0; i < numAttributes; i++) {
            
            String name = instances.attribute(i).name();
            String type;
            if (instances.attribute(i).isNominal())
                type = "(nominal)";
            else
                type = "(numeric)";
            
            String text = name + " " + type;
            
            JLabel label = new JLabel(text);
            Dimension d1 = new Dimension(170, 20);
            label.setPreferredSize(d1);
            label.setAlignmentX(LEFT_ALIGNMENT);
            add(label);
            
            JTextField txtField = new JTextField("");
            Dimension d = new Dimension(50, 20);
            txtField.setPreferredSize(d);
            add(txtField);
            fields.add(txtField);
        }
        
        
        setSize(230, 250);
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

        setPreferredSize(new java.awt.Dimension(225, 300));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
