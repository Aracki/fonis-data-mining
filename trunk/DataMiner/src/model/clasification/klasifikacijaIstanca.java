/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clasification;


import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



/**
 *
 * @author Ivan
 */
public class klasifikacijaIstanca {

    private static String fileName = "C:/Users/Dusan Dudukovic/Documents/test.arff";

	public static void main(String[] args) throws Exception {

		// load data
		DataSource loader = new DataSource(fileName);
		Instances data = loader.getDataSet();
		data.setClassIndex(data.numAttributes() - 1);

		
		// Create the Naive Bayes Classifier
		NaiveBayes bayesClsf = new NaiveBayes();   
		bayesClsf.buildClassifier(data);
		
		// output generated model
//		System.out.println(bayesClsf);
		
		
		// Test the model with the original set
		Evaluation eval = new Evaluation(data);
		eval.evaluateModel(bayesClsf, data);
		

		// Print the result as in Weka explorer
		String strSummary = eval.toSummaryString();
		
//		System.out.println("=== Evaluation on training set ===");
//		System.out.println("=== Summary ===");
//		System.out.println(strSummary);
		
		// Get the confusion matrix
		System.out.println(eval.toMatrixString());
                
                
	}
}
