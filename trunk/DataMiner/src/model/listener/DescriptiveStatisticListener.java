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
import view.leftPanels.DescriptivePnlLeft;
import view.main.MainGUI;
import weka.core.Instances;

/**
 *
 * @author Stupi
 */
public class DescriptiveStatisticListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Instances instances = Data.getInstance().getInstances();
        if (instances == null) {
            JOptionPane.showMessageDialog(null, "You have to open/create table first!");
            return;
        }
        
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlCenter().removeAll();
        
        //da se doda za centralni panel tabela
        MainGUI.getInstance().getPnlLeft().add(new DescriptivePnlLeft(instances));
        
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
        
        
    }
    
}
