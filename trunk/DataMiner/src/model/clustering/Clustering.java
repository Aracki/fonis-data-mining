/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clustering;

import java.util.Enumeration;
import weka.clusterers.FilteredClusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author Baki
 */
public class Clustering {

    private SimpleKMeans kMeansCLusterer;

    public Instances loadData(String fileName) throws Exception {
        DataSource loader = new DataSource(fileName);
        Instances data = loader.getDataSet();

        return data;
    }

//    public String centroids (Instances data) throws Exception {
//
//		
//
//		SimpleKMeans kMeansCLusterer = new SimpleKMeans();
//		kMeansCLusterer.setNumClusters(3);
//		kMeansCLusterer.setDisplayStdDevs(true);
//
//		FilteredClusterer filteredClusterer = new FilteredClusterer();
//		filteredClusterer.setClusterer(kMeansCLusterer);
//		filteredClusterer.buildClusterer(data);
//
//		return kMeansCLusterer.getClusterCentroids().toString();
//	}
    public String filledFile(Instances data, int numOfClusters, String remove) throws Exception {

        String mainData = data.toString();
        int index = mainData.indexOf("@data");
        String clusterData = mainData.substring(0, index + 6);

        Remove removeFilter = new Remove();
        removeFilter.setAttributeIndices(remove);

        kMeansCLusterer = new SimpleKMeans();
        kMeansCLusterer.setNumClusters(numOfClusters);

        FilteredClusterer filteredClusterer = new FilteredClusterer();
        filteredClusterer.setClusterer(kMeansCLusterer);
        filteredClusterer.setFilter(removeFilter);
        filteredClusterer.buildClusterer(data);

        Enumeration<Instance> newData = data.enumerateInstances();

        while (newData.hasMoreElements()) {

            Instance i = (Instance) newData.nextElement();
            int kluster = filteredClusterer.clusterInstance(i);
            String instanceString = i.toString() + "," + kluster;
            clusterData = clusterData + instanceString + "\n";

        }
        return clusterData;
    }

    public SimpleKMeans getkMeansCLusterer() {
        return kMeansCLusterer;
    }

}
