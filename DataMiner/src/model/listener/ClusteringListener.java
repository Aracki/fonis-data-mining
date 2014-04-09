/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.leftPanels.ClusteringPnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class ClusteringListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlCenter().removeAll();
        
        MainGUI.getInstance().getPnlLeft().add(new ClusteringPnlLeft());
        
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
        
    }
    
}
