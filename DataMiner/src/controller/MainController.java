/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.listener.ClassificationListener;
import model.listener.ClusteringListener;
import model.listener.DescriptiveStatisticListener;
import model.listener.KolmogorovSmirnovListener;
import model.listener.NewListener;
import model.listener.OneSampleTTestListener;
import model.listener.OpenListener;
import model.listener.TwoSamplesTTestLitener;
import model.listener.VisualizeListener;
import view.main.MainGUI;

/**
 *
 * @author Stupi
 */
public class MainController {
    
    
    public static void main(String[] args) {
        
        MainGUI.getInstance();
        
        //deo za dodavanje listenera //=======================
        
        //File
        MainGUI.getInstance().addNewListener(new NewListener());
        MainGUI.getInstance().addOpenListener(new OpenListener());
        
        
        //Data Mining
        MainGUI.getInstance().addClassificationListener(new ClassificationListener());
        MainGUI.getInstance().addClusteringListener(new ClusteringListener());
       
        
        //Statistics
        MainGUI.getInstance().addDescriptiveStatisticListener(new DescriptiveStatisticListener());
        MainGUI.getInstance().addOneSampleTTest(new OneSampleTTestListener());
        MainGUI.getInstance().addTwoSamplesTTest(new TwoSamplesTTestLitener());
        MainGUI.getInstance().addKolmogorovSmirnov(new KolmogorovSmirnovListener());
        
        //Visualization
        MainGUI.getInstance().addVisualizeListener(new VisualizeListener());
        //deo za dodavanje listenrea //=======================
        
    }
    
  
}
