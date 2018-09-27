/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econvertergui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Carrie
 */
public class Display extends JFrame{
    
    
    public Display()
    {
        runGUI();
    }
    
    //arrayList to hold listeners
    ArrayList<ActionListener> listenerArray = new ArrayList();
    //arrayList to hold the textfields
    ArrayList<JTextField> fieldArray = new ArrayList();
    //arrayList to hold the labels
    ArrayList<JLabel> labelArray = new ArrayList();

    public void runGUI()
    {
        setTitle("Energy Converter");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        //tabbed pane which will contain panel with textfields
        JTabbedPane tp = new JTabbedPane();
        //panel to contain text fields
        JComponent panel = new JPanel();
        
        
        //Text fields:
        //creates text fields, adds a listener, adds field to fieldArray
        JTextField wattField = new JTextField(10);
        wattField.addActionListener(listenerArray.get(0));
        fieldArray.add(wattField);
        JTextField jouleField = new JTextField(10);
        jouleField.addActionListener(listenerArray.get(1));
        fieldArray.add(jouleField);
        JTextField calorieField = new JTextField(10);
        calorieField.addActionListener(listenerArray.get(2));
        fieldArray.add(calorieField);
        JTextField kCalField = new JTextField(10);
        kCalField.addActionListener(listenerArray.get(3));
        fieldArray.add(kCalField);
        JTextField hpField = new JTextField(10);
        hpField.addActionListener(listenerArray.get(4));
        fieldArray.add(hpField);
        JTextField btuField = new JTextField(10);
        btuField.addActionListener(listenerArray.get(5));
        fieldArray.add(btuField);
        
        //Labels for each text field
        JLabel wattLabel = new JLabel("Watts: ");
        JLabel jouleLabel = new JLabel("Joules: ");
        JLabel calorieLabel = new JLabel("Calories: ");
        JLabel kCalLabel = new JLabel("kCals: ");
        JLabel hpLabel = new JLabel("Horsepower: ");
        JLabel btuLabel = new JLabel("British Thermal Units: ");
        
        //created grid layout to allign labels and text boxes
        GridLayout grid = new GridLayout(6, 2);
        //add the layout to the panel
        panel.setLayout(grid);
        
        //add labels and text boxes to the panel
        panel.add(wattLabel);
        panel.add(wattField); //Row 0
        panel.add(jouleLabel);
        panel.add(jouleField); //row 1
        panel.add(calorieLabel);
        panel.add(calorieField); //row 2
        panel.add(kCalLabel);
        panel.add(kCalField); //row 3
        panel.add(hpLabel);
        panel.add(hpField); //row 4
        panel.add(btuLabel);
        panel.add(btuField); //row 5
        
        //Create tab for panel
        tp.addTab("Energy", panel);
        
        //add the tabbed pane to the JFrame
        add(tp);
        
    }
    
    public void keyPressed(ActionEvent event)
    {
        int row = listenerArray.indexOf(event.getSource());
        String entry = fieldArray.get(row).getText();
        
        calculateConv(entry, row);
    }
    
    public void calculateConv(String entry, int row)
    {
        
    }
    
}


//Will use the row number to shorten checking what fields need updated info