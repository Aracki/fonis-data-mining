/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.listener;

import controller.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.leftPanels.ClassificationPnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class ClassificationListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (Data.getInstance().getInstances() == null) {
            JOptionPane.showMessageDialog(null, "You have to open/create table first!");
            return;
        }
        MainGUI.getInstance().getPnlLeft().removeAll();
//        MainGUI.getInstance().getPnlCenter().removeAll();
        MainGUI.getInstance().getPnlLeft().add(new ClassificationPnlLeft());
//        MainGUI.getInstance().getPnlCenter().add(new ClassificationPnlCenter());

        MainGUI.getInstance().getPnlLeft().validate();
        MainGUI.getInstance().getPnlLeft().repaint();
    }

}
