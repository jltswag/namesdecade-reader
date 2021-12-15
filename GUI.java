import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.*;
/**
 * Creates the GUI that Names Class will operate off of.
 *
 * @author (Julia Tran)
 * @version (12/10/2021)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Names names; 
    private Canvas myCanvas;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()throws FileNotFoundException
    {
        //creates frame
        Names names = new Names(); 
        JFrame frame = new JFrame("Name Records Through Decades");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        //creates panels
        JPanel primPanel = new JPanel();
        primPanel.setPreferredSize (new Dimension(1000, 525)); 
        primPanel.setBackground (Color.lightGray); 
        JTextArea text1 = new JTextArea(2, 90);
        JScrollPane s = new JScrollPane(text1);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        text1.setLineWrap(true);
        
        JPanel subPanel1 = new JPanel(); 
        subPanel1.setPreferredSize (new Dimension(450, 450)); 
        subPanel1.setBackground (Color.pink); 
        
        JPanel subPanel2 = new JPanel(); 
        subPanel2.setPreferredSize (new Dimension(450, 450)); 
        subPanel2.setBackground (Color.pink); 
        subPanel2.setLayout(new GridLayout(0,1,4,4));
        
        primPanel.add(s);
        primPanel.add (subPanel1); 
        primPanel.add (subPanel2);
        //frame.add(primPanel);
        
        //code for panel one that will add an image
        ImageIcon pic = new ImageIcon("image.png");
        JLabel label2 = new JLabel(pic, SwingConstants.CENTER);
        subPanel1.add(label2);//set picture in subpanel1
        
        //code for panel two that will add buttons
        JButton button1 = new JButton("Finds all the names that have been getting more popular each decade.");
        JButton button2 = new JButton("Type in a name and print out the ranks for each decade of that name.");
        JButton button3 = new JButton("Display the names that appear in only one decade.");
        JButton button4 = new JButton("Display the names that are ranked in all the decades.");
        JButton button5 = new JButton("Display all names of a given rank for all decades.");
        JButton button6 = new JButton("Given a name, draw a graph for that name (with appropriate labels)");
        JButton button7 = new JButton("Finds all the names that have been getting less popular each decade.");
        JButton button8 = new JButton("EXIT");
        
        button1.setPreferredSize (new Dimension(100, 50)); 
        
        subPanel2.add(button1);
        subPanel2.add(button2);
        subPanel2.add(button3);
        subPanel2.add(button4);
        subPanel2.add(button5);
        subPanel2.add(button6);
        subPanel2.add(button7);
        subPanel2.add(button8);
        
        button1.addActionListener(
        new ActionListener() // performs method one on the button 
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                text1.append("These are all of the names that have been getting more popular each decade: " + names.panelOption1());
            }
        }
        );
        
        button2.addActionListener(
        new ActionListener() // performs method two on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                JFrame frame = new JFrame("Option 5");
                String pickName = JOptionPane.showInputDialog(frame, "Pick a name: " );
                //System.out.println(names.nameRecords.get(pickName)); //outputs to terminal, check
                text1.append("This outputted the ranks of the name you asked for: " + names.nameRecords.get(pickName) + "\n");
            }
        }
        );
        
        button3.addActionListener(
        new ActionListener() // performs method three on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                names.panelOption3(); 
                text1.append("This outputted the names only ranked once: " + names.panelOption3() + "\n");
            }
        }
        );
        
        button4.addActionListener(
        new ActionListener() // performs method four on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                names.panelOption4(); 
                text1.append("This outputted the names ranked in all decades: " + names.panelOption4() + "\n");
            }
        }
        );
        
        button5.addActionListener(
        new ActionListener() // performs method five on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                ArrayList<String> rankNames = new ArrayList<String>();//arraylist to hold names ranked in a user given number
                JFrame frame = new JFrame("Option 5");
                String rank = JOptionPane.showInputDialog(frame, "Pick a rank 1-1000: ");
                for (Map.Entry<String, String> set: names.nameRecords.entrySet())
                {
                    String row = set.getValue();
                    //splits the name and rank to be interpreted in the for and each loop
                    for (String colum : row.split(" "))
                    {
                        //counts how many times the name was ranked z
                        if (colum.equals(rank))
                        {
                            System.out.println(set.getKey());
                            rankNames.add(set.getKey());
                        }
                    }
                }
                text1.append("This printed out names with a rank of: " + rank + ", " + rankNames);
            }
        }
        );
        
        button6.addActionListener(
        new ActionListener() // performs method five on the button 
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                //option pane asks for user input
                String name = JOptionPane.showInputDialog(frame, "Pick a name");
                String key = names.nameRecords.get(name);
            
                //creates the graph
                myCanvas = new Canvas("Line Graph of Name Ranks", 600,600);
                myCanvas.setForegroundColor(Color.BLACK);
                myCanvas.fillRectangle(0,0,600,600);
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("This graph displays the graph for the name: " + name, 75, 25); 
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(50,0,50,600);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(100,50,100,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(150,50,150,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(200,50,200,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(250,50,250,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(300,50,300,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(350,50,350,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(400,50,400,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(450,50,450,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(500,50,500,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(550,50,550,550);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(0,50,600, 50);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawLine(0,550,600, 550);
                
                //plot string coordinates
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1900",50,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1910",100,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1920",150,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1930",200,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1940",250,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1950",300,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1960",350,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1970",400,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1980",450,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1990",500,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("2000",550,565);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("0",35,65);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("100",30,105);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("200",30,155);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("300",30,205);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("400",30,255);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("500",30,305);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("600",30,355);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("700",30,405);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("800",30,455);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("900",30,505);
                
                myCanvas.setForegroundColor(Color.WHITE);
                myCanvas.drawString("1000",25,550);
                
                //runs through values of names set and graphs numbers and lines
                //if not valid, displays "NR"
                String [] decades = key.split(" ");
                for (int i = 1; i < decades.length; i++)
                {
                    if (Integer.parseInt(decades[i]) == 0) //if rank is zero, displays "NR"
                    {
                        myCanvas.drawString("NR", 50*i-5, 40);
                    }
                    else //if rank is not zero, plots the point and string of rank next to it
                    {
                        myCanvas.setForegroundColor(Color.WHITE);
                        myCanvas.fillCircle(50*i-5, Integer.parseInt(decades[i])*1/2+50,10);
                        myCanvas.setForegroundColor(Color.WHITE);
                        myCanvas.drawString("" + decades[i],52*i-5, Integer.parseInt(decades[i])*1/2+50);
                    }
                    
                }
                for (int n = 2; n < decades.length; n++) // draws the lines between the points
                {
                    if (Integer.parseInt(decades[n-1]) != 0 && Integer.parseInt(decades[n]) != 0)
                    {
                            myCanvas.setForegroundColor(Color.WHITE);
                            //myCanvas.drawLine(50,60,70,80);
                            myCanvas.drawLine(50*(n-1), Integer.parseInt(decades[n-1])*1/2+50,50*(n), Integer.parseInt(decades[n])*1/2+50);
                    }
                }
            }
        }
        );
        
        button7.addActionListener(
        new ActionListener() // performs method seven on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                text1.append("These are all of the names that have been getting less popular each decade: " + names.panelOption7());
            }
        }
        );
        
        button8.addActionListener(
        new ActionListener() // performs method eight on the button
        {
            public void actionPerformed(ActionEvent evt)
            {
                text1.setText(""); //clears any previous text
                String answer = JOptionPane.showInputDialog(frame, "You are now leaving this program, say goodbye!");
                System.exit(0);
            }
        }
        );
        
        //code that adds everything to the frame
        frame.getContentPane().add(primPanel); 
        frame.pack(); 
        frame.setVisible(true);
    }

    
    
}
