/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.BorderLayout;
import javax.swing.JButton;
import model.listener.ClassificationListener;
import model.listener.ClusteringListener;
import model.listener.DescriptiveStatisticListener;
import model.listener.NewListener;
import model.listener.OpenListener;
import model.listener.TextMiningListener;
import model.listener.VisualizeListener;
import model.listener.VisualizeSaveListener;
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
        MainGUI.getInstance().addTextMiningListener(new TextMiningListener());
        
        //Statistics
        MainGUI.getInstance().addDescriptiveStatisticListener(new DescriptiveStatisticListener());
        
        //Visualization
        MainGUI.getInstance().addVisualizeListener(new VisualizeListener());
        MainGUI.getInstance().addSaveVisualizeListener(new VisualizeSaveListener());
        //deo za dodavanje listenrea //=======================
        
    }
    
  
}
