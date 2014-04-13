/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.centerPanels;

import controller.Data;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.clasification.ClassificationIO;
import view.main.MainGUI;
import view.centerPanels.ClassificationPnlCenterStart;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

/**
 *
 * @author Dusan Dudukovic
 */
public class ClassificationPnlCenterPredict extends javax.swing.JPanel {

    private ButtonGroup radioGroup;

    private Instances instances;
    private NaiveBayes naiveBayes;

    private boolean filesExist;
    private boolean predictOnCurrent;

    private ArrayList<JTextField> textFields;
//    private ArrayList<JLabel> labelList;

    /**
     * Creates new form ClassificationPnlCenter
     */
    public ClassificationPnlCenterPredict(NaiveBayes nb) {
        initComponents();
        setSize(MainGUI.getInstance().getPnlCenter().getWidth(), MainGUI.getInstance().getPnlCenter().getHeight());
        radioGroup = new ButtonGroup();
        radioGroup.add(radioCurrent);
        radioGroup.add(radioLoad);
        btnOk.setEnabled(false);

        naiveBayes = nb;

        pnlAttributes.setVisible(true);
        btnStart.setEnabled(false);

        ArrayList<String> files = ClassificationIO.readFileNames();
        if (files.size() == 0) {
            filesExist = false;
        } else {
            for (String fileName : files) {
                cmbFiles.addItem(fileName);
            }
            filesExist = true;
        }
        setVisible(true);

    }

    private Object makeObj(final String item) {
        return new Object() {
            public String toString() {
                return item;
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioCurrent = new javax.swing.JRadioButton();
        radioLoad = new javax.swing.JRadioButton();
        cmbFiles = new javax.swing.JComboBox();
        btnOk = new javax.swing.JButton();
        pnlAttributes = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        radioCurrent.setText("Predict on currently trained data set");
        radioCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCurrentActionPerformed(evt);
            }
        });

        radioLoad.setText("Load trained model and then predict");
        radioLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLoadActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAttributesLayout = new javax.swing.GroupLayout(pnlAttributes);
        pnlAttributes.setLayout(pnlAttributesLayout);
        pnlAttributesLayout.setHorizontalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        pnlAttributesLayout.setVerticalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(radioCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOk)
                                    .addComponent(cmbFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnlAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStart)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioCurrent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnStart))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCurrentActionPerformed
        if (naiveBayes == null) {
            JOptionPane.showConfirmDialog(this, "You can't choose this. Train algorithm first and then try");

            radioCurrent.setEnabled(false);
            return;
        }

        cmbFiles.setEnabled(false);
        btnOk.setEnabled(true);
        predictOnCurrent = true;
    }//GEN-LAST:event_radioCurrentActionPerformed

    private void radioLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLoadActionPerformed
        if (!filesExist) {
            JOptionPane.showMessageDialog(this, "There is not models to load");
            radioLoad.setEnabled(false);
            return;
        }

        cmbFiles.setEnabled(true);
        btnOk.setEnabled(true);
        predictOnCurrent = false;
    }//GEN-LAST:event_radioLoadActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        if (predictOnCurrent == true) {
            
            instances = new Instances(Data.getInstance().getInstances());
            instances.delete();
        } else { //predictOnCurrent == false, znaci ucitavamo
            String fileName = cmbFiles.getSelectedItem().toString();

            
            
            instances = ClassificationIO.readInstances(fileName);
            naiveBayes = ClassificationIO.readNaiveBayes(fileName);

        }

        int numAttributes = instances.numAttributes();
        textFields = new ArrayList<>();

        pnlAttributes.setLayout(new FlowLayout((int) LEFT_ALIGNMENT));
        Dimension dim = new Dimension(250, 180);
        pnlAttributes.setPreferredSize(dim);
        for (int i = 0; i < numAttributes - 1; i++) {

            String name = instances.attribute(i).name();
            String type;
            if (instances.attribute(i).isNominal()) {
                type = "(nominal)";
            } else {
                type = "(numeric)";
            }

            String text = name + " " + type;

            JLabel label = new JLabel(text);
            Dimension d1 = new Dimension(170, 20);
            label.setPreferredSize(d1);
            label.setAlignmentX(LEFT_ALIGNMENT);
            label.setVisible(true);
            pnlAttributes.add(label);

            JTextField txtField = new JTextField("");
            Dimension d = new Dimension(50, 20);
            txtField.setPreferredSize(d);
            txtField.setVisible(true);
            pnlAttributes.add(txtField);
            textFields.add(txtField);
        }
        pnlAttributes.setVisible(true);

        btnStart.setEnabled(true);

        validate();
        repaint();


    }//GEN-LAST:event_btnOkActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        //imate vec objekat instances i objekat naiveBayes u ovoj klasi
        //treba da izvucete ono sto je uetu u text fieldove preko liste i da napravite
        //objekat Instance (nema "s"). kad naravite objekat Instance samo ga dodate
        //na instances.add(  )..
        //onda koristite takav Instances i naiveBayes za evaluaciju i u textArea
        //ispisujete kojoj klasi pripada.. Sad ne trba matrica konfuzije potrebno
        //je da ispisete string kojoj klasi pripada
        //pogledajte klasu ClusterinPnlCenterPredict tu je odradjeno 90% onog sto se i ovde trazi
//        instances.delete();
        for (int i = 0; i < textFields.size(); i++) {
            String text = textFields.get(i).getText().trim();

            //prekace prazna pollja jer za klasterizaciju znaci da se ona ignorisu
            //to za klasifikaciju nije slucaj
            if (!text.equals("")) {

                if (instances.attribute(i).isNominal()) {
                    boolean correct = false;
                    for (int j = 0; j < instances.attribute(i).numValues(); j++) {
                        if (text.equals(instances.attribute(i).value(j))) {
                            correct = true;
                        }
                    }
                    if (!correct) {
                        JOptionPane.showMessageDialog(this, "Incorrect format for attribute " + instances.attribute(i).name());
                        break;
                    }
                }

                if (instances.attribute(i).isNumeric()) {
                    try {
                        double value = Double.parseDouble(text);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Incorrect format for attribute " + instances.attribute(i).name());
                        break;
                    }
                }

            }
        }

        int numAttributes = instances.numAttributes();

        Instance instance = new Instance(numAttributes);

        for (int i = 0; i < textFields.size(); i++) {
            String text = textFields.get(i).getText().trim();

            try {
                double value = Double.parseDouble(text);
                instance.setValue(i, value);

            } catch (Exception e) {
                instance.setValue(i, text);
            }
        }
       
        String value = instances.attribute(numAttributes-1).value(0);
        Attribute  Att = instances.attribute(numAttributes-1);
        
        instance.setValue(Att, value);
//        instances.delete();
//        instance.setValue((numAttributes - 1), instances.attribute(numAttributes - 1).value(0) );

        instances.add(instance);

        double [][] matrix = null;
        
        System.out.println(instances);
        System.out.println(naiveBayes);
        
        try {

//                instances.setClassIndex(instances.numAttributes() - 1);
            Evaluation eval = new Evaluation(instances);

            eval.evaluateModel(naiveBayes, instances);

            textArea.setText(eval.toMatrixString());
            matrix = eval.confusionMatrix();

        } catch (Exception ex) {
            System.out.println("Greska: " + ex);
        }

        double [] array = new double[matrix.length];
        
        for (int i = 0; i < array.length; i++) {
            
            double sum = 0;
            for (int j = 0; j < array.length; j++) {
                
                sum = sum + matrix[j][i];
                
            }
            array[i] = sum;
            
        }
        
        String className = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                className = instances.attribute(numAttributes-1).value(i);
            }
        }
        
        textArea.setText("This instance belongs to class: \n\n== "+className+" ==");
        
        instances.delete();
    }//GEN-LAST:event_btnStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox cmbFiles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAttributes;
    private javax.swing.JRadioButton radioCurrent;
    private javax.swing.JRadioButton radioLoad;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
