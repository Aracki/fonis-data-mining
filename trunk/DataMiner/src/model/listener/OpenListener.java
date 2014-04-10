/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.listener;

import controller.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import model.converter.ConvertToInstances;
import model.converter.TXTcreator;
import view.centerPanels.LoadedInstancesCentralPanel;
import view.main.MainGUI;
import weka.core.Instances;

/**
 *
 * @author Stupi
 */
public class OpenListener implements ActionListener {

    JFileChooser chooser;
    Instances instances;

    @Override
    public void actionPerformed(ActionEvent ae) {
        chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new TableFilter());

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Utils utils = new Utils();
            ConvertToInstances convert = new ConvertToInstances();
            File chosenFile = chooser.getSelectedFile();

            String extension = utils.getExtension(chosenFile);

            if (extension.equals("xlsx")) {

                File outputFile = new File("files/proba.csv");
                convert.convertXlsxToCSV(chosenFile, outputFile);
            }
            if (extension.equals("xlsx")) {
                instances = convert.convertCSVToInstances(new File("files/proba.csv"));
            } else if (extension.equals("csv")) {
                instances = convert.convertCSVToInstances(chosenFile);
            }
            System.out.println(instances);
            Data.getInstance().setInstances(instances);

            //proverava da li je klasifikovano i podesava to u klasi Data
            int lastAttributeIndex = instances.numAttributes() - 1;
            if (instances.attribute(lastAttributeIndex).isNominal()) {
                Data.getInstance().setClassified(true);
                TXTcreator creator = new TXTcreator(instances);
                creator.createTXTfile("methods/visualization/txtFile.txt");
            } else {
                Data.getInstance().setClassified(false);
            }

            for (int i = 0; i < instances.numInstances(); i++) {
                for (int j = 0; j < instances.numAttributes(); j++) {
                    System.out.print(instances.instance(i).value(j) + " ");
                }
                System.out.println();
            }
            LoadedInstancesCentralPanel panel = new LoadedInstancesCentralPanel();
            panel.setSize(MainGUI.getInstance().getPnlCenter().getSize());
            MainGUI.getInstance().getPnlCenter().removeAll();
            MainGUI.getInstance().getPnlCenter().add(panel);
            MainGUI.getInstance().validate();
            MainGUI.getInstance().repaint();
            
            panel.setVisible(true);
        }

    }

    class TableFilter extends FileFilter {

        @Override
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            Utils utils = new Utils();
            String extension = utils.getExtension(file);

            if (extension != null) {
                if (extension.equals("xlsx") || extension.equals("csv")) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return ".xlsx, .csv";
        }

    }

    class Utils {
        /*
         * Get the extension of a file.
         */

        public String getExtension(File f) {
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                ext = s.substring(i + 1).toLowerCase();
            }
            return ext;
        }
    }
}
