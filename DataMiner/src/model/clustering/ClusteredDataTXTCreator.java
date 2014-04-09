/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clustering;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import weka.clusterers.SimpleKMeans;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Baki
 */

public class ClusteredDataTXTCreator {

    private Instances data;

    public ClusteredDataTXTCreator(Instances data) {
        this.data = data;
    }

    public SimpleKMeans createTXTfile(String fileName, int numOfClusters, String removeFilter) {
        Clustering k = null;
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            out.println("@numOfAttributes " + (getNumOfAttributes()+1));
            out.println("@numOfInstances " + getNumOfInstances());
            out.println();
            ArrayList<String> attributes = getAttributeNames();
            for (String attribute : attributes) {
                out.println(attribute.toString());
            }
            out.print("@attribute class {");
            for (int i = 0; i < numOfClusters-1; i++) {
                out.print(i+",");
            }
            out.print(numOfClusters-1+"}"+"\n");
            out.println();
            out.println();
            out.println("@data");

            k = new Clustering();
            String wholeARFF = k.filledFile(data, numOfClusters, removeFilter);
            String onlyData = wholeARFF.substring(wholeARFF.indexOf("@data") + 6, wholeARFF.length());
            String[] datas = onlyData.split("\n");
            for (int i = 0; i < datas.length; i++) {
                out.println(datas[i] + "\n");
            }

            out.close();

            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return k.getkMeansCLusterer();
    }

    public int getNumOfAttributes() {
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

    public int getNumOfInstances() {
        return data.numInstances();
    }



}