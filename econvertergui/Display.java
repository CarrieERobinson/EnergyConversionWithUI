/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econvertergui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
        JTextField wattField = new JTextField(10);
        JTextField jouleField = new JTextField(10);
        JTextField calorieField = new JTextField(10);
        JTextField kCalField = new JTextField(10);
        JTextField hpField = new JTextField(10);
        JTextField btuField = new JTextField(10);
        
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
        panel.add(wattField);
        panel.add(jouleLabel);
        panel.add(jouleField);
        panel.add(calorieLabel);
        panel.add(calorieField);
        panel.add(kCalLabel);
        panel.add(kCalField);
        panel.add(hpLabel);
        panel.add(hpField);
        panel.add(btuLabel);
        panel.add(btuField);
        
        
        
        tp.addTab("Energy", panel);
        
        add(tp);
        
    }
}
