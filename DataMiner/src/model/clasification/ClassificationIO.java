/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clasification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.pmml.Function;

/**
 *
 * @author Stupi
 */
public class ClassificationIO {

    //pravi objekat koji moze da se serijalizuje, ovaj objekat cad i njega upisuje u fajl
    public static void writeInstanceObject(String fileName, Instances fullIstances) {

        //pravi kopiju instanci
        Instances instances = new Instances(fullIstances);

        //brise sve instance, ostavlja samo informacije o atributima, samo zaglavlje
        instances.delete();
        try {
            SerializationHelper.write("methods/classification/instances/"
                    + fileName + Instances.SERIALIZED_OBJ_FILE_EXTENSION, instances);
        } catch (Exception e) {
        }
        
    }

    public static void writeNaiveBayesObject(String fileName, NaiveBayes naiveBayes) {

        try {
            SerializationHelper.write("methods/classification/models/" + fileName + ".model", naiveBayes);
        } catch (Exception e) {
        }
    }

    //metoda vraca boolean jer proverava u isto vreme da li postoji vec takav naziv
    public static boolean updateTxtFile(String fileName) {

        try {

            ArrayList<String> files = new ArrayList<>();

            String path = "methods\\classification\\files.txt";
            
            BufferedReader in = new BufferedReader(new FileReader(path));

            //ucitavamo sve fajlove koji postoje u files.txt, svaki red upisujemo u listu
            while (true) {
                String tmp = in.readLine();
                if (tmp.equals(fileName)) {
                    return false;
                }
                if (tmp == null) {
                    break;
                }
                files.add(tmp);
            }
            in.close();
            
            //na kraju ubacimo u listu i fajl koji dodajemo
            files.add(fileName);

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));

            //sad u isti fajl upisujemo sve pdoatke, svaki put kad se napravi ovaj out objekat
            //on obrise ceo taj fajl, zato je bilo bitno da smo sacuvali fajlove pre toga u listu
            for (int i = 0; i < files.size(); i++) {
                out.println(files.get(i));
            }
            out.close();
            
        } catch (Exception e) {
        }

        return true;
    }

    /**
     * Ovo su ogoljne instance sadrze samo informaicje o atributima
     *
     * @param fileName
     * @return ogoljene instance
     */
    public static Instances readInstances(String fileName) {
        String path = "methods/classification/instances/" + fileName + Instances.SERIALIZED_OBJ_FILE_EXTENSION;
        Instances instances = null;
        try {
            instances = (Instances) SerializationHelper.read(path);
        } catch (Exception ex) {
            Logger.getLogger(ClassificationIO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return instances;

    }

    public static NaiveBayes readNaiveBayes(String fileName) {
        String path = "methods/classification/models" + fileName + ".model";

        NaiveBayes nb = null;
        try {
            nb = (NaiveBayes) SerializationHelper.read(path);
        } catch (Exception e) {
        }

        return nb;
    }

    public static ArrayList<String> readFileNames() {
        String path = "methods/classification/files.txt";
        ArrayList<String> files = new ArrayList<>();

        try {

            BufferedReader in = new BufferedReader(new FileReader(path));

            while (true) {
                String tmp = in.readLine();

                if (tmp == null) {
                    break;
                }
                files.add(tmp);
            }
            in.close();

        } catch (Exception e) {
        }

        return files;
        
    }

}
