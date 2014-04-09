/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.centerPanels.ClassificationPnlCenterPredict;
import view.leftPanels.ClassificationPnlLeft;
import view.main.MainGUI;
import static view.main.MainGUI.getInstance;

/**
 *
 * @author Stupi
 */
public class ClassificationListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

        MainGUI.getInstance().getPnlLeft().removeAll();
//        MainGUI.getInstance().getPnlCenter().removeAll();
        MainGUI.getInstance().getPnlLeft().add(new ClassificationPnlLeft());
//        MainGUI.getInstance().getPnlCenter().add(new ClassificationPnlCenter());

        MainGUI.getInstance().getPnlLeft().validate();
        MainGUI.getInstance().getPnlLeft().repaint();
    }

}
