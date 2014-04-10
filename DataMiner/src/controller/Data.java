/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.TextField;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import weka.core.Instances;

/**
 *
 * @author Stupi
 */
public class Data {
    
    private static Data instance = null;
    
    
    //objekti koji sluze za komunikaciju
    private Instances instances = null;
    private String txtFilePath = null;
    private boolean classified = false;
    private JPanel LoadedInstancesCentralPanel;

    
    
    
    
    
    public Instances getInstances() {
        return instances;
    }

    public void setInstances(Instances instances) {
        this.instances = instances;
    }

    public String getTxtFilePath() {
        return txtFilePath;
    }

    public void setTxtFilePath(String txtFilePath) {
        this.txtFilePath = txtFilePath;
    }

    public boolean isClassified() {
        return classified;
    }

    public void setClassified(boolean classified) {
        this.classified = classified;
    }

    public JPanel getLoadedInstancesCentralPanel() {
        return LoadedInstancesCentralPanel;
    }

    public void setLoadedInstancesCentralPanel(JPanel LoadedInstancesCentralPanel) {
        this.LoadedInstancesCentralPanel = LoadedInstancesCentralPanel;
    }
    
    
    
    
    
    
    public static Data getInstance () {
        if (instance == null)
            instance = new Data();
        return instance;
    }
}