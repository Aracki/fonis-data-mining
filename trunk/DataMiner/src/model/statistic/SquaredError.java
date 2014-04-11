/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.statistic;

/**
 *
 * @author Stupi
 */
public class SquaredError {
    
    

    public double variance(double[] elements) {
        double suma=0;
        double suma2 = 0;
        for(int i = 0; i<elements.length;i++){
            
             suma2 = elements[i]+suma;
             
        }
        double arithmetic = suma2/elements.length;
        for(int i = 0; i < elements.length; i++){
            suma =suma + Math.pow((elements[i]-arithmetic),2);
        }
        double varijansa = suma/elements.length;
        return varijansa;
    }
    
    
}
