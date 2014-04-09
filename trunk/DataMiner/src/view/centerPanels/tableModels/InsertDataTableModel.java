/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.centerPanels.tableModels;

import controller.Data;
import controller.TableSingleton;
import javax.swing.table.DefaultTableModel;
import view.leftPanels.AtributeNamesLeftPanel;
import view.leftPanels.NewTablePnlLeft;

/**
 *
 * @author Vlada
 */
public class InsertDataTableModel extends DefaultTableModel{

    private Object[][] data;

    public InsertDataTableModel() {
        AtributeNamesLeftPanel p = new AtributeNamesLeftPanel();
        TableSingleton.getInstance().setData(30, TableSingleton.getInstance().getTextFields().size());
        
    }

   
    
    
    
    @Override
    public int getColumnCount() {
        return NewTablePnlLeft.numOfColumns;
    }

    @Override
    public int getRowCount() {
        return 30;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        TableSingleton.getInstance().getData()[row][col] = value.toString();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return TableSingleton.getInstance().getData()[row][col];
    }

    
    
    @Override
    public String getColumnName(int i) {
       
        return TableSingleton.getInstance().getTextFields().get(i).getText();
    }
    
    
}
