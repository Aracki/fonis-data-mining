/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.listener;

import controller.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.leftPanels.OneSamplePnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class OneSampleTTestListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        OneSamplePnlLeft pnlLeft = new OneSamplePnlLeft();
        
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlCenter().removeAll();
        
        MainGUI.getInstance().getPnlLeft().add(pnlLeft);
        MainGUI.getInstance().getPnlCenter().add(Data.getInstance().getLoadedInstancesCentralPanel());
        
        pnlLeft.setVisible(true);
        
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
        
        
    }
    
}
