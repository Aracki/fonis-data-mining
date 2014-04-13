/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.listener;

import controller.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.leftPanels.KolmogorovSmirnovPnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class KolmogorovSmirnovListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        KolmogorovSmirnovPnlLeft pnlLeft = new KolmogorovSmirnovPnlLeft();
        
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlCenter().removeAll();
        
        MainGUI.getInstance().getPnlLeft().add(pnlLeft);
        MainGUI.getInstance().getPnlCenter().add(Data.getInstance().getLoadedInstancesCentralPanel());
        
        pnlLeft.setVisible(true);
        
        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
    
    }
    
}
