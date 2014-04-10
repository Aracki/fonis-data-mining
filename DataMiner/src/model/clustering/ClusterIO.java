/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.clustering;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.SerializationHelper;

/**
 *
 * @author Stupi
 */
public class ClusterIO {
    
    
    
    
    //pravi objekat koji moze da se serijalizuje, ovaj objekat cad i njega upisuje u fajl
    public void writeInstanceObject (String fileName, Instances fullIstances) {
    
        //pravi kopiju instanci
        Instances instances = new Instances(fullIstances);
        
        //brise sve instance, ostavlja samo informacije o atributima, samo zaglavlje
        instances.delete();
        try {
             SerializationHelper.write("methods/clustering/instances/"
                     +fileName+Instances.SERIALIZED_OBJ_FILE_EXTENSION, instances);
        } catch (Exception e) {
        }
        
    }
    
    public void writeKMeansObject (String fileName, SimpleKMeans kMeans) {
        
        try {
            SerializationHelper.write("methods/clustering/models/"+fileName+".model", kMeans);
        } catch (Exception e) {
        }
    }
    //metoda vraca boolean jer proverava u isto vreme da li postoji vec takav naziv
    public boolean updateTxtFile (String fileName) {
        
        try {
            
            ArrayList<String> files = new ArrayList<>();
            
            BufferedReader in = new BufferedReader(new FileReader("methods/clustering/files.txt"));
            
            //ucitavamo sve fajlove koji postoje u files.txt, svaki red upisujemo u listu
            
            while (true) {
                String tmp = in.readLine();
                if (tmp.equals(fileName))
                    return false;
                if (tmp == null)
                    break;
                files.add(tmp);
            }
            in.close();
            
            //na kraju ubacimo u listu i fajl koji dodajemo
            files.add(fileName);
            
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("methods/clustering/files.txt")));
            
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
    
    
    
    
    
    
    
}
