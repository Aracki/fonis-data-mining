/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clasification;

import controller.Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author Dusan Dudukovic
 */
public class ModelFinder {

    public static File[] finder() {
        File dir = new File("methods/classification/Models/");

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".model");
            }
        });

    }

    public static String[] arrayOfModels() {

        File[] nizFajlova = finder();
        String[] nizImena = new String[nizFajlova.length];

        for (int i = 0; i < nizFajlova.length; i++) {
            nizImena[i] = nizFajlova[i].getName();
        }

        return nizImena;
//        PrintWriter writer;
//            try {
//                writer = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Dusan Dudukovic/Documents/NetBeansProjects/trunk/Models/lista_modela.txt")));
//
//                writer.println(nizImena[i]);
//
//                writer.close();
//
//            } catch (IOException ex) {
//                System.out.println("Greska");
//            }
//
//            System.out.println(nizImena[i]);
    }

    public static File[] arffFinder() {
        File dir = new File("methods/classification/Models/");

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".arff");
            }
        });
    }

    public static String[] arrayOfArffs() {

        File[] nizFajlova = arffFinder();
        String[] nizImena = new String[nizFajlova.length];

        PrintWriter writer;

        for (int i = 0; i < nizFajlova.length; i++) {
            nizImena[i] = nizFajlova[i].getName();

//            try {
//                writer = new PrintWriter(new BufferedWriter
//                            (new FileWriter
//                                ("C:/Users/Dusan Dudukovic/Documents/NetBeansProjects/trunk/Models/lista_modela.txt")));
//                
//                writer.println(nizImena[i]);
//                
//                writer.close();
//                    
//            } catch (IOException ex) {
//                System.out.println("Greska");
//            }
//            System.out.println(nizImena[i]);
        }

        return nizImena;
    }

    public static void writeIntoTxt(String modelName) throws IOException {
        Instances data = Data.getInstance().getInstances();

        PrintWriter bw = new PrintWriter(
                new BufferedWriter(new FileWriter("methods/classification/TxtFiles/" + modelName + ".txt")));

//        BufferedWriter bw = new BufferedWriter(new FileWriter("methods/classification/TxtFiles/" + modelName + ".txt"));
        int brojAtr = data.numAttributes() - 1;

        for (int i = 0; i < brojAtr; i++) {

            int prviR = data.attribute(i).toString().indexOf("'");
            int drugiR = data.attribute(i).toString().lastIndexOf("'");

            bw.write(data.attribute(i).toString().substring(prviR +1, drugiR) + ", ");

        }
        bw.close();
    }

}
