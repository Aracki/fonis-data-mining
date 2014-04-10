/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.visualization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Hybrid
 */
public class TXTVisualization {

    public static String x = "";
    public static String y = "";

    public static LinkedList<String> atributi(String txt) {
        boolean kraj = false;

        LinkedList<String> atributi = new LinkedList<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(txt));

            int br = Integer.parseInt(in.readLine().split(" ")[1]);
            for (int j = 0; j < br + 1; j++) {

                String pom = in.readLine();
                if (pom.contains("@attribute") && pom.contains("numeric")) {
                    atributi.add(pom.substring(11, pom.lastIndexOf("n") - 1));
                }

            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return atributi;

    }

    public static void drawChart(String a, String b, String txt) {
        String[] boje = null;
        LinkedList<String> atributi = new LinkedList<String>();
        LinkedList<String> sviAtributi = new LinkedList<String>();
        String[] vrAtribut = null;
        XYSeries[] xy = null;
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        int brojac = 0;
        boolean kraj = false;
        LinkedList<Integer> numeric = new LinkedList<Integer>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(txt));
            int br = Integer.parseInt(in.readLine().split(" ")[1]);
            for (int j = 0; j < br + 1; j++) {

                String pom = in.readLine();
                if (pom.contains("@attribute")) {
                    if (pom.contains("numeric")) {
                        sviAtributi.add(pom.substring(11, pom.lastIndexOf("n") - 1));
                    } else {
                        sviAtributi.add(pom.split(" ")[1]);
                    }
                }
                if (pom.contains("@attribute") && pom.contains("numeric")) {
                    atributi.add(pom.substring(11, pom.lastIndexOf("n") - 1));
                }
                if (!pom.contains("numeric")) {
                    brojac++;
                    numeric.add(j - 2);
                }

            }
            String s = in.readLine();
            boje = s.substring(s.indexOf("{") + 1, s.lastIndexOf("}")).split(",");
            xy = new XYSeries[boje.length];
            for (int i = 0; i < boje.length; i++) {

                xy[i] = new XYSeries(boje[i]);

            }
            while (!kraj) {
                String pom2 = in.readLine();

                if (!(pom2.contains("@data"))) {
                    vrAtribut = pom2.split(",");
                    for (int i = 0; i < xy.length; i++) {
                        if (xy[i].getKey().equals(vrAtribut[vrAtribut.length - 1])) {

                            xy[i].add(Double.parseDouble(vrAtribut[sviAtributi.indexOf(a)]), Double.parseDouble(vrAtribut[sviAtributi.indexOf(b)]));

                        }
                    }
                }
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
        for (int i = 0;
                i < xy.length;
                i++) {
            xySeriesCollection.addSeries(xy[i]);
        }

        JFreeChart grafik = ChartFactory.createScatterPlot("Vizuelizacija", a, b, xySeriesCollection, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame proba = new ChartFrame("DataMiner", grafik);

        proba.setVisible(
                true);
        proba.setSize(
                500, 600);

    }
}
