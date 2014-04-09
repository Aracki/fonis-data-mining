/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.textMining;
    import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.bayes.NaiveBayesUpdateable;

import java.io.File;
import javax.swing.JTextArea;
/**
 *
 * @author jonnn_000
 */
public class Model1 {


/**
 * This example trains NaiveBayes incrementally on data obtained
 * from the ArffLoader.
 *
 * 
 */


  /**
   * Expects an ARFF file as first argument (class attribute is assumed
   * to be the last attribute).
   *
   * @param args        the commandline arguments
   * @throws Exception  if something goes wrong
   */
  public static void main(String[] args) throws Exception {
    // load data
    ArffLoader loader = new ArffLoader();
    loader.setFile(new File(""));
    Instances structure = loader.getStructure();
    structure.setClassIndex(structure.numAttributes() - 1);

    // train NaiveBayes
    NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
    nb.buildClassifier(structure);
    Instance current;
    while ((current = loader.getNextInstance(structure)) != null)
      nb.updateClassifier(current);

    // output generated model
    System.out.println(nb);
  }
}


