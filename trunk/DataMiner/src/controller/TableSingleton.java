/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.TextField;
import java.util.LinkedList;
import javax.swing.JComboBox;

/**
 *
 * @author Vlada
 */
public class TableSingleton {

    private static TableSingleton instance = null;
    LinkedList<TextField> textFields = new LinkedList<>();
    LinkedList<JComboBox> comboBoxes = new LinkedList<>();
    String[][] data;

    /**
     * @param aInstance the instance to set
     */
    public static void setInstance(TableSingleton aInstance) {
        instance = aInstance;
    }

    public static TableSingleton getInstance() {
        if (instance == null) {
            instance = new TableSingleton();
        }
        return instance;
    }

    public LinkedList<TextField> getTextFields() {
        return textFields;
    }

    public void setTextFields(LinkedList<TextField> textFields) {
        this.textFields = textFields;
    }

    public LinkedList<JComboBox> getComboBoxes() {
        return comboBoxes;
    }

    public void setComboBoxes(LinkedList<JComboBox> comboBoxes) {
        this.comboBoxes = comboBoxes;
    }

    public String[][] getData() {
        return data;
    }

    public void setData( int a, int b) {
        this.data = new String[a][b];
        
    }

    
}
