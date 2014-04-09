/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.clasification;

/**
 *
 * @author Ivan
 */

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class klasifikacijaTrening {
    
    private static String fileName = "D:/workspaceNB/hay-train.arff";
    private static String instanceName = "D:/workspaceNB/test.arff";

	public static void main(String[] args) throws Exception {

//		// load data
//		DataSource loader = new DataSource(fileName);
//		Instances data = loader.getDataSet();
//		data.setClassIndex(data.numAttributes() - 1);
//                //drugi deo
//                DataSource loader2 = new DataSource(instanceName);
//		Instances data2 = loader2.getDataSet();
//		data2.setClassIndex(data.numAttributes() - 1);
//                
//
//		
//		// Create the Naive Bayes Classifier
//		NaiveBayes bayesClsf = new NaiveBayes();   
//		bayesClsf.buildClassifier(data);
//		//bayesClsf.buildClassifier(data2);
//                
//		// output generated model
////		System.out.println(bayesClsf);
//		
//		
//		// Test the model with the original set
//		Evaluation eval = new Evaluation(data);
//		eval.evaluateModel(bayesClsf, data2);
//                
//		
//
//		// Print the result as in Weka explorer
//		String strSummary = eval.toSummaryString();
//		
////		System.out.println("=== Evaluation on training set ===");
////		System.out.println("=== Summary ===");
////		System.out.println(strSummary);
//		
//		System.out.println(eval.toMatrixString());
//
////                //DRUGI DEO
////                
//                //eval.evaluateModel(bayesClsf, data2);
//		
//               double [][] matrix = eval.confusionMatrix();
//               int klasaIndex;
//               
//               for (int i = 0; i < matrix.length; i++) {
//                  if( matrix[i][i] == 1){
//                      klasaIndex = i;
//                      System.out.println(klasaIndex);
//                  }
//                  return;
//            }
//             
//
//                // Get the confusion matrix
//		//System.out.println(eval.toMatrixString());
//                
                
        }
    
}
