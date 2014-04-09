/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.listener;

import controller.Data;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.main.MainGUI;
import view.leftPanels.pnlVisualization;

/**
 *
 * @author Stupi
 */
public class VisualizeListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (Data.getInstance().isClassified()) {
            MainGUI.getInstance().getPnlLeft().removeAll();
            MainGUI.getInstance().getPnlLeft().add(new pnlVisualization());
            MainGUI.getInstance().getPnlLeft().validate();
            MainGUI.getInstance().getPnlLeft().repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Data are not classified!");
        }
    }

}
