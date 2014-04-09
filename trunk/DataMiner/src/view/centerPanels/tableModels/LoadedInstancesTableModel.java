/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.centerPanels.tableModels;

import javax.swing.table.DefaultTableModel;
import controller.Data;

/**
 *
 * @author Vlada
 */
public class LoadedInstancesTableModel extends DefaultTableModel {

    public Object[][] data = null;
    int numberOfInstances; 
    int numberOfAttributes; 


    public LoadedInstancesTableModel() {
        numberOfInstances = Data.getInstance().getInstances().numInstances();
        numberOfAttributes = Data.getInstance().getInstances().numAttributes();
        
        data = new Object[numberOfInstances]
                         [numberOfAttributes];
        for (int i = 0; i < numberOfInstances; i++) {
            String [] values = Data.getInstance().getInstances().instance(i).toString().split(",");
            
            for (int j = 0; j < numberOfAttributes; j++) {
                
                data[i][j] = values[j];

            }
        }
        System.out.println(numberOfAttributes);

    }

    @Override
    public int getColumnCount() {
        
        return numberOfAttributes;
    }

    @Override
    public int getRowCount() {
        return numberOfInstances;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int i) {
        return Data.getInstance().getInstances().attribute(i).name();
//        return columnNames[i];
       
    }

}
