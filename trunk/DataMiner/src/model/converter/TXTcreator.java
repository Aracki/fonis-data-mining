/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import weka.core.Instances;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Stupi
 */
public class TXTcreator {

    private Instances data;

    public TXTcreator(Instances data) {
        this.data = data;
    }

    public void createTXTfile(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName+".txt")));
            
            out.println("@numOfAttributes "+getNumOfAttributes());
            out.println("@numOfInstances "+getNumOfInstances());
            out.println();
            ArrayList<String> attributes = getAttributeNames();
            for (String attribute : attributes) {
                out.println(attribute.toString());
            }
            out.println();
            out.println("@data");
            for (int i = 0; i < getNumOfInstances(); i++) {
                out.println(getRowOfData(i));
            }
            out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public int getNumOfAttributes () {
        return data.numAttributes();
    }
    
    public ArrayList<String> getAttributeNames() {

        ArrayList<String> attributes = new ArrayList<>();
        int numOfAttributes = data.numAttributes();
        for (int i = 0; i < numOfAttributes; i++) {
            attributes.add(data.attribute(i).toString());
        }
        
        return attributes;

    }
    
    public String getRowOfData (int i) {
        Instance instance = data.instance(i);
        return instance.toString();
    }
    
    public int getNumOfInstances () {
        return data.numInstances();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "C://Users//Stupi//Desktop/iris.arff";
        DataSource loader = new DataSource(fileName);
        Instances data = loader.getDataSet();
        TXTcreator txtCreator = new TXTcreator(data);
        txtCreator.createTXTfile("files/proba");

    }

}