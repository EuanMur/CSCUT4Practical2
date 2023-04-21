import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) {
   
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");       

        try {
            // Set up a new Scanner to read the input file.
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

             // Parse name and date from input line
             String[] parts = line.split("(?=\\d)(?<!\\d)");
             String name = parts[0];
             String dateStr = parts[1];

             String[] bothNames = name.split(" ");
             
             bothNames[0] = bothNames[0].substring(0, 1).toUpperCase() + bothNames[0].substring(1);
             bothNames[1] = bothNames[1].substring(0, 1).toUpperCase() + bothNames[1].substring(1);
             String fullName = bothNames[0] + " " + bothNames[1];

             SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
             SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
             try {

                Date date = format.parse(dateStr);
                String newDate = newDateFormat.format(date);
                System.out.println(fullName + " " + newDate);
                
                try{

                    FileWriter writer = new FileWriter("output.txt");
                    PrintWriter printWriter = new PrintWriter(writer);
                    printWriter.println(fullName + " " + newDate);
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    } // main

} // FilesInOut
