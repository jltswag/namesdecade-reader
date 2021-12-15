import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * This class implements a scanner that read through the "names.txt" files and displays various ranks.
 *
 * @author (Julia Tran)
 * @version (12/4/21)
 */
public class Names
{
    // instance variables - replace the example below with your own
    public ArrayList<String> names;
    public HashMap<String,String> nameRecords;//initial name records list that all methods work off of 
    private Scanner scan;
    public Random rand;
    private Canvas myCanvas;
    public String number; 
    
    //jlabel for gui, puts text on screen
    //gui with buttons that call the methods and brings it to the jlabel
    /**
     * Constructor for objects of class CopyOfNames
     */
    public Names()throws FileNotFoundException 
    {
        names = new ArrayList<String>();
        nameRecords = new HashMap<String,String>();
        rand = new Random();
        File text = new File("names.txt");
        scan = new Scanner(text);
        String line = "";
        //Object[] s = new String[2];
        int i = 0;
        String name = "";
        while (scan.hasNextLine())
        {
            line = scan.nextLine();
            names.add(line); 
            i = line.indexOf(" "); 
            //System.out.println(i);
            name = line.substring(0,i);
            //System.out.println(name);
            nameRecords.put(name, line);
            //System.out.println(nameRecords);
        }
        //sc = new Scanner(System.in);   
    }
    
    /**
     * Find all the names that have been getting more popular each decade.
     */
    public ArrayList<String> panelOption1()
    {
        ArrayList<String> compNames = new ArrayList<String>();//new arraylist to hold the correct names
        String[] num = null;
        boolean b;
        for (String look : names)
        {
            num = look.split(" ");
            b = num[0].equals("0") ||
                num[1].equals("0") ||
                num[2].equals("0") ||
                num[3].equals("0") ||
                num[4].equals("0") ||
                num[5].equals("0") ||
                num[6].equals("0") ||
                num[7].equals("0") ||
                num[8].equals("0") ||
                num[9].equals("0") ||
                num[10].equals("0") ||
                num[11].equals("0");
            if (!b)
            {
            if (Integer.parseInt(num[2]) <= Integer.parseInt(num[1]) && 
                Integer.parseInt(num[3]) <= Integer.parseInt(num[2]) &&
                Integer.parseInt(num[4]) <= Integer.parseInt(num[3]) &&
                Integer.parseInt(num[5]) <= Integer.parseInt(num[4]) &&
                Integer.parseInt(num[6]) <= Integer.parseInt(num[5]) &&
                Integer.parseInt(num[7]) <= Integer.parseInt(num[6]) &&
                Integer.parseInt(num[8]) <= Integer.parseInt(num[7]) &&
                Integer.parseInt(num[9]) <= Integer.parseInt(num[8]) &&
                Integer.parseInt(num[10]) <= Integer.parseInt(num[9]) &&
                Integer.parseInt(num[11]) <= Integer.parseInt(num[10])
            )
            {
                compNames.add(look);
                //System.out.println(look); //check
            }
        }
        }
        return compNames;
    }
    
    /**
     * Given a name, the GUI outputs the ranks of the decades for that name.
     */
    public void panelOption2()//asks the user to type a name and prints its rank
    {
        scan = new Scanner(System.in); 
        System.out.println("Pick a name: ");
        String nameKey = "";
        nameKey = scan.nextLine();
        //System.out.println(nameRecords.get(nameKey)); //check
    }
    
    /**
     * GUI displays the names that appear in only one decade
     */
    public ArrayList<String> panelOption3()//prints the number of names that are ranked only once
    {
        //reads through all of the hashmap
        ArrayList<String> oneNames = new ArrayList<String>();//arraylist to hold names ranked in one decade
        for (Map.Entry<String, String> set: nameRecords.entrySet())
        {
            String row = set.getValue();
            int counter = 0;
            //splits the name and rank
            for (String colum : row.split(" "))//do this process in the constructor|go through eveery entry, check numbers inputted, if there, do something
            {
                if (colum.equals("0"))
                {
                    counter ++;
                }
            }
            //if the name ranks 0 for 10 decades it prints the name
            if (counter == 10)
            {
                //System.out.println(set.getKey()); //check
                oneNames.add(set.getKey());
            }
        }
        //System.out.println("These are all of the names that are ranked in only one decade.");
        return oneNames;
    }
    
    /**
     * Reads through the nameRecords hashmap to return the names that have been ranked in each decade. 
     */
    public ArrayList<String> panelOption4()
    {
        //reads through the hashmap
        ArrayList<String> allNames = new ArrayList<String>();//arraylist to hold names ranked in all decades
        for (Map.Entry<String, String> set: nameRecords.entrySet())
        {
            String row = set.getValue();
            int counter = 0;
            //splits the name and rank to be interpreted in the for and each loop
            for (String colum : row.split(" "))
            {
                //counts how many times the name was ranked z
                if (colum.equals("0"))
                {
                    counter ++;
                }
            }
            //if the counter counts that the name has been ranked in all 11 
            if (counter == 0)
            {
                //System.out.println(set.getKey()); //check
                allNames.add(set.getKey());
            }
        }
        //System.out.println("These are all of the names that are ranked in each decade.");
        return allNames;
    }
    
    /**
     * Reads through the nameRecords hashmap to return the names of a user-given rank. 
     */
    public ArrayList<String> panelOption5() //done mainly within the GUI class
    {
        //reads through the hashmap 
        ArrayList<String> rankNames = new ArrayList<String>();//arraylist to hold names ranked in a user given number
        scan = new Scanner(System.in); 
        System.out.println("Pick a rank: ");
        String nameValue = "";
        nameValue = scan.nextLine();
        System.out.println("These are all of the names of the rank you gave.");
        for (Map.Entry<String, String> set: nameRecords.entrySet())
        {
            String row = set.getValue();
            //splits the name and rank to be interpreted in the for and each loop
            for (String colum : row.split(" "))
            {
                //counts how many times the name was ranked z
                if (colum.equals(nameValue))
                {
                    //System.out.println(set.getKey()); //check
                    rankNames.add(set.getKey());
                }
            }
        }
        return rankNames;
    }
    
    /**
     * Output a graph of a selected name, showing information of it throughout the decades. 
     */
    public void panelOption6()
    {
         //done in GUI class   
    }
    
    /**
     * Reads through the nameRecords hashmap to return all names whose ranks are decreasing each decade. 
     */
    public ArrayList<String> panelOption7()
    {
        ArrayList<String> revNames = new ArrayList<String>();//new arraylist to hold the correct names
        String[] num = null;
        boolean b;
        for (String look : names)
        {
            num = look.split(" ");
            b = num[0].equals("0") ||
                num[1].equals("0") ||
                num[2].equals("0") ||
                num[3].equals("0") ||
                num[4].equals("0") ||
                num[5].equals("0") ||
                num[6].equals("0") ||
                num[7].equals("0") ||
                num[8].equals("0") ||
                num[9].equals("0") ||
                num[10].equals("0") ||
                num[11].equals("0");
            if (!b)
            {
            if (Integer.parseInt(num[2]) >= Integer.parseInt(num[1]) && 
                Integer.parseInt(num[3]) >= Integer.parseInt(num[2]) &&
                Integer.parseInt(num[4]) >= Integer.parseInt(num[3]) &&
                Integer.parseInt(num[5]) >= Integer.parseInt(num[4]) &&
                Integer.parseInt(num[6]) >= Integer.parseInt(num[5]) &&
                Integer.parseInt(num[7]) >= Integer.parseInt(num[6]) &&
                Integer.parseInt(num[8]) >= Integer.parseInt(num[7]) &&
                Integer.parseInt(num[9]) >= Integer.parseInt(num[8]) &&
                Integer.parseInt(num[10]) >= Integer.parseInt(num[9]) &&
                Integer.parseInt(num[11]) >= Integer.parseInt(num[10])
            )
            {
                revNames.add(look);
                //System.out.println(look); //check
            }
        }
        }
        return revNames;
    }
    
    /**
     * Exits the program 
     */
    public void panelOption8()
    {
        System.exit(0);
    }
}

