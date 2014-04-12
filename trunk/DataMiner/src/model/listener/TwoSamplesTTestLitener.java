/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.listener;

import controller.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.centerPanels.NewTableCentralPanel;
import view.leftPanels.TwoSamplesChooserPnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class TwoSamplesTTestLitener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

        TwoSamplesChooserPnlLeft panelLeft = new TwoSamplesChooserPnlLeft();
        panelLeft.setSize(MainGUI.getInstance().getPnlLeft().getSize());
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlLeft().add(panelLeft);

        JPanel panelCenter = Data.getInstance().getLoadedInstancesCentralPanel();
//                panelCenter.setSize(MainGUI.getInstance().getPnlCenter().getSize());
        MainGUI.getInstance().getPnlCenter().removeAll();
        MainGUI.getInstance().getPnlCenter().add(panelCenter);

        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();

        panelLeft.setVisible(true);
        panelCenter.setVisible(true);
    }

}
