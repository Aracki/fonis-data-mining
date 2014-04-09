/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clasification;

import controller.TableSingleton;
import java.util.LinkedList;
import view.leftPanels.NewTablePnlLeft;
import weka.core.Attribute;
import weka.core.FastVector;

/**
 *
 * @author Vlada
 */
public class createInstancesFromTable {

    LinkedList<String> listOfNominalValues;
    public void createAttributes() {

        for (int i = 0; i < NewTablePnlLeft.numOfColumns; i++) {
            if (TableSingleton.getInstance().getComboBoxes().get(i).getSelectedItem() == "numeric") {
                Attribute age = new Attribute(TableSingleton.getInstance().getTextFields().get(i).getText());
            } else {
                int number = countNominals(i).size();
                FastVector vector = new FastVector(number);
                for (int j = 0; j < number; j++) {
                    vector.addElement(listOfNominalValues.get(j));
                }
                Attribute month = new Attribute(TableSingleton.getInstance().getTextFields().get(i).getText(), vector);
            }
        }

    }

    public LinkedList countNominals(int i) {
        listOfNominalValues = new LinkedList<>();

        if (TableSingleton.getInstance().getComboBoxes().get(i).getSelectedItem() == "nominal") {
            for (int j = 0; j < 30; j++) {
                if (!listOfNominalValues.contains(TableSingleton.getInstance().getData()[j][i])) {
                    listOfNominalValues.add(TableSingleton.getInstance().getData()[j][i]);
                }
            }

        }
        return listOfNominalValues;
    }
}
