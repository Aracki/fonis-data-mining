/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.centerPanels;

import controller.Data;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static view.centerPanels.ClassificationPnlCenterPredict.jPanelStart;
import view.main.MainGUI;

/**
 *
 * @author Ivan
 */
public class ClassificationPnlCenterStart extends javax.swing.JPanel {

    /**
     * Creates new form ClassificationPnlCenterStart
     */
    public ClassificationPnlCenterStart() {
        initComponents();

        setLocation(ClassificationPnlCenterPredict.jPanelStart.getLocation());
        setSize(ClassificationPnlCenterPredict.jPanelStart.getSize());

        ArrayList<JLabel> labelList = new ArrayList<JLabel>();
        ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();

        int numOfAt = Data.getInstance().getInstances().numAttributes();

        for (int i = 0; i < numOfAt - 1; i++) {
            String name = Data.getInstance().getInstances().attribute(i).name();
            labelList.add(new JLabel(name));
            labelList.get(i).setText(name);

            textFieldList.add(new JTextField());

            add(labelList.get(i));

            add(textFieldList.get(i));
            textFieldList.get(i).setSize(55, 25);
        }

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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
