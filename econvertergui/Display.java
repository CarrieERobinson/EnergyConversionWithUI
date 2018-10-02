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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Carrie
 */
public class Display extends JFrame implements ActionListener{
    
    //runs my display code
    public Display()
    {
        runGUI();
    }
    
    //arrayList to hold the textfields
    ArrayList<JTextField> fieldArray = new ArrayList();
    //arrayList to hold the labels
    ArrayList<JLabel> labelArray = new ArrayList();

    public void runGUI()
    {
        setTitle("Energy Converter");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //set window to center of screen
        setLocationRelativeTo(null);
        
        //tabbed pane which will contain panel with textfields
        JTabbedPane tp = new JTabbedPane();
        //panel to contain text fields
        JComponent panel = new JPanel();
        
        //Text fields:
        //creates text fields, adds a listener, adds field to fieldArray
        JTextField wattField = new JTextField(10);
        fieldArray.add(wattField);
        JTextField jouleField = new JTextField(10);
        fieldArray.add(jouleField);
        JTextField calorieField = new JTextField(10);
        fieldArray.add(calorieField);
        JTextField kCalField = new JTextField(10);
        fieldArray.add(kCalField);
        JTextField hpField = new JTextField(10);
        fieldArray.add(hpField);
        JTextField btuField = new JTextField(10);
        fieldArray.add(btuField);
        
        //Add action listeners to each field
        for(int i = 0; i < fieldArray.size(); i++)
        {
            fieldArray.get(i).addActionListener(this);
        }
        
        //Labels for each text field
        JLabel wattLabel = new JLabel("Wattsecond: ");
        JLabel jouleLabel = new JLabel("Joules: ");
        JLabel calorieLabel = new JLabel("Gram Calories: ");
        JLabel kCalLabel = new JLabel("kCalories: ");
        JLabel hpLabel = new JLabel("Horsepower Hour: ");
        JLabel btuLabel = new JLabel("BTU: ");
        
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
        
        //display instructions
        displayError("Please enter a value into a box then press enter!");
        //set initial values in boxes
        initialValues();
    }
    
    public void keyPressed(ActionEvent event)
    {
        int row = fieldArray.indexOf(event.getSource());
        String entry = fieldArray.get(row).getText();
        
        calculateConv(entry, row);
    }
    
    public void calculateConv(String entry, int row)
    {
        //update each text box in order to show conversions as user types
        //explanation under class
        int stop = row;
        
        
        //will keep track of what row the loop is on
        if(row >= 5) 
            row = 0;
        else 
            row+=1;
        
        //wrap in try-catch to catch any invalid input and make a dialog
        try{
            //will hold the value of previous equation
            double value = Double.parseDouble(entry);  
        
            do
            {
                switch(row)
                {
                    case 0:
                    {
                        value = value * 1055.06;
                        //btu to wattseconds
                        fieldArray.get(row).setText(String.valueOf(value));
                        row++;
                        break;
                    }
                    case 1:
                    {
                        value = value;
                        //watts to joules
                        fieldArray.get(row).setText(String.valueOf(value));
                        row++;
                        break;
                    }
                    case 2:
                    {
                        value = value * 0.2389;
                        //joules to calories
                        fieldArray.get(row).setText(String.valueOf(value));
                        row++;
                        break;
                    }
                    case 3:
                    {
                        value = value* 0.001;
                        //calories to kCal
                        fieldArray.get(row).setText(String.valueOf(value));
                        row++;
                        break;
                    }
                    case 4:
                    {
                        value = value * 0.0015596;
                        //kCal to horsepower
                        fieldArray.get(row).setText(String.valueOf(value));
                        row++;
                        break;
                    }
                    case 5:
                    {
                        value = value * 2544.43;
                        //horsepower to btu
                        fieldArray.get(row).setText(String.valueOf(value));
                        row = 0; //wrap back around to 0
                        break;
                    }
                    default: 
                        System.out.println("You broke it!");
                }



            }while(stop != row); //stop when loop reaches original row
        }catch(Exception ex)
        {
            displayError("Invalid input!");
            initialValues();
        }
    }

    //excecutes when enter key is pressed
    @Override
    public void actionPerformed(ActionEvent ae) {
        //gets index of the source
        int row = fieldArray.indexOf(ae.getSource());
        //gets the input from the source
        String entry = fieldArray.get(row).getText();
        
        //passes input into calculation function
        calculateConv(entry, row);
    }
    
    //sets up initial values for the textfields
    public void initialValues()
    {
        fieldArray.get(0).setText("1");
        calculateConv("1", 0);
    }
    
    //will display a dialog box with the specified message
    public void displayError(String msg)
    {
        JOptionPane.showMessageDialog(null, msg);
    }
    
}


//Will use the row number to shorten checking what fields need updated info

//The conversion function works by going through each field one-by-one
//it will use the conversion equation for the previous textfield along with the
//value of the previous field. This way, each field is updated based on the
//previous field rather than looking at one field then going through each equation