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
import javax.swing.JPanel;
import view.leftPanels.TwoSamplesChooserPnlLeft;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class TwoSamplesTTestLitener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (Data.getInstance().getInstances() == null) {
            JOptionPane.showMessageDialog(null, "You have to open/create table first!");
            return;
        }

        TwoSamplesChooserPnlLeft panelLeft = new TwoSamplesChooserPnlLeft();
        panelLeft.setSize(MainGUI.getInstance().getPnlLeft().getSize());
        MainGUI.getInstance().getPnlLeft().removeAll();
        MainGUI.getInstance().getPnlLeft().add(panelLeft);

        JPanel panelCenter = Data.getInstance().getLoadedInstancesCentralPanel();

        MainGUI.getInstance().getPnlCenter().removeAll();
        MainGUI.getInstance().getPnlCenter().add(panelCenter);

        panelLeft.setVisible(true);
        panelCenter.setVisible(true);

        MainGUI.getInstance().validate();
        MainGUI.getInstance().repaint();
    }

}
