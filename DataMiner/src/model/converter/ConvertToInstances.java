/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.converter;

import controller.TableSingleton;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.leftPanels.NewTablePnlLeft;

public class ConvertToInstances {

    public Instances convertCSVToInstances(File file) {

        CSVLoader loader = new CSVLoader();
        Instances data = null;
        try {
            loader.setSource(file);
            data = loader.getDataSet();
        } catch (Exception ex) {
            System.out.println("error:" + ex.getMessage());
        }
        return data;
    }

    public void convertXlsxToCSV(File inputFile, File outputFile) {
        // For storing data into CSV files
        StringBuffer data = new StringBuffer();

        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            // Get the workbook object for XLSX file
            XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(inputFile));
            // Get first sheet from the workbook
            XSSFSheet sheet = wBook.getSheetAt(0);
            Row row;
            Cell cell;
            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            data.append(cell.getBooleanCellValue() + ",");

                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            data.append(cell.getNumericCellValue() + ",");

                            break;
                        case Cell.CELL_TYPE_STRING:
                            data.append(cell.getStringCellValue() + ",");
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            data.append("" + ",");
                            break;
                        default:
                            data.append(cell + ",");

                    }

                }
                data.append("\r\n");
            }

            String csvData = data.toString();
            csvData = csvData.replaceAll(",\r\n", "\r\n");
            fos.write(csvData.getBytes());
            fos.close();

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

    public void convertTableToCSV(File outputFile) {
        String[][] tableData = TableSingleton.getInstance().getData();
        String dataToWrite = "";
        for (int i = 0; i < NewTablePnlLeft.numOfColumns; i++) {
            String attribute = TableSingleton.getInstance().getTextFields().get(i).getText();
            if (i < NewTablePnlLeft.numOfColumns - 1) {
                dataToWrite = dataToWrite + attribute + ",";
            } else {
                dataToWrite = dataToWrite + attribute + "\r\n";
            }
        }
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < NewTablePnlLeft.numOfColumns; j++) {
                    if (j < NewTablePnlLeft.numOfColumns - 1) {
                        dataToWrite = dataToWrite + tableData[i][j] + ",";
                    } else {
                        dataToWrite = dataToWrite + tableData[i][j] + "\r\n";
                    }
                    
                }
            }
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            
//            System.out.println(dataToWrite);

            fos.write(dataToWrite.getBytes());
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
