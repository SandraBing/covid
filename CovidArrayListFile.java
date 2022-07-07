/*Assignment 2 Software Development & Testing
Author: Sandra Fitzgerald L00144096
Date: 27th of May 2021
Covid Cases*/


/*Read covid details from user and write them out to file */

import java.io.*;
import java.util.*;

public class CovidArrayListFile //implements Serializable
{
   public static void main(String args[]) throws IOException, FileNotFoundException
   {
      //Create ArrayList for Covid Objects
      ArrayList<Covid> covidList = new ArrayList<Covid>();
     
      //create objects of the classes
      try
      {
         FileOutputStream fos = new FileOutputStream("Covid.txt");
         ObjectOutputStream os = new ObjectOutputStream(fos);
         Scanner keyboardIn = new Scanner(System.in);
         char response;
         int cases, males, females, age;
         String county, countyName;
      
      
      //Get data from user
      do
      {
         System.out.print("Enter number of cases: ");
         cases = keyboardIn.nextInt();
         keyboardIn.nextLine();
         System.out.print("Enter County: ");
         county = keyboardIn.nextLine();
         System.out.print("Enter number of males: ");
         males = keyboardIn.nextInt();
         System.out.print("Enter number of females:");
         females = keyboardIn.nextInt();
         System.out.print("Enter the median age:");
         age = keyboardIn.nextInt();
         
         //Add info to Arraylist
         covidList.add(new Covid(county, cases, males, females, age));
         System.out.println("Do you want to add more information?");
         response = keyboardIn.next().charAt(0);
         
      }
      while(response == 'y' || response == 'Y');
      //write ArrayList out to file
      os.writeObject(covidList);
      //Close file and output stream
      fos.close();
      os.close();
      }//close of try
      catch(InputMismatchException ex)
      {
         System.out.println("Must be numeric values - Please check your input");
      }
      catch(IllegalArgumentException ex)
      {
         System.out.println("Cannot be negative numbers - Please check your input");
      }
      catch(FileNotFoundException ex)
      {
         System.out.println("Problem writing to the file Covid.txt");
      }
      catch(IOException ex)
      {
         System.out.println("Problem writing to the file Covid.txt");
      }
      
      System.out.print("File was successfully created");
   }
}