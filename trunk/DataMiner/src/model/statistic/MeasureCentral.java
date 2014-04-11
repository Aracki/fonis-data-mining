/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.statistic;

import java.util.Arrays;

/**
 *
 * @author Stupi
 */
public class MeasureCentral {

    public double arithmeticMean(double[] elements) {
        double suma = 0;
        for(int i = 0; i<elements.length;i++){
            
             suma = elements[i]+suma;
             
        }
        double arithmetic = suma/elements.length;
       
        return arithmetic;
    }

    public double geometricMean(double[] elements) {
        double proizvod=1.0;
        for(int i=0;i<elements.length;i++){
            proizvod= proizvod*elements[i];
        }
        double koren= 1.0/elements.length;
        double geometric = Math.pow(proizvod,koren);
         return geometric;
    }

    public double harmonicMean(double[] elements) {
        double a=0;
        for(int i = 0; i<elements.length; i++){
            a= a+ 1/elements[i];
        }
       double harmonic = elements.length/a;
         return harmonic;
    }

    public double mode(double[] elements) {
         double maxValue=0;
         int maxCount=0;

    for (int i = 0; i < elements.length; ++i) {
        int count = 0;
        for (int j = 0; j < elements.length; ++j) {
            if (elements[j] == elements[i]) ++count;
        }
        if (count > maxCount) {
            maxCount = count;
            maxValue = elements[i];
        }
    }

         return maxValue;
    }

    public double median(double[] elements) {
        Arrays.sort(elements);
        
         return elements[elements.length/2];
    }
    
}
