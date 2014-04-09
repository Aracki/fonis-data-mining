/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.centerPanels.LoadedInstancesCentralPanel;
import view.leftPanels.NewTablePnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class NewListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        NewTablePnlLeft panel = new NewTablePnlLeft();
            panel.setSize(MainGUI.getInstance().getPnlLeft().getSize());
            MainGUI.getInstance().getPnlLeft().removeAll();
            MainGUI.getInstance().getPnlLeft().add(panel);
            MainGUI.getInstance().validate();
            MainGUI.getInstance().repaint();
            
            panel.setVisible(true);
    }
    
}
