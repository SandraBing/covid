/*Assignment 2 Software Development & Testing
Author: Sandra Fitzgerald L00144096
Date: 27th of May 2021
Covid Cases*/

/*Read object of CovidArrayListFile class back in from file as ArrayList*/

import java.io.*;
import java.util.*;


public class ReadCovidData
{
   
   public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Scanner keyboardIn = new Scanner(System.in);
      //Create objects to open file and read from it
      FileInputStream fis = new FileInputStream("Covid.txt");
      ObjectInputStream is = new ObjectInputStream(fis);
      
      
      //Bring data back in from file and store it in ArrayList
      ArrayList<Covid> covidList = (ArrayList<Covid>) is.readObject();

      int option, noCases, age, females = 0, males = 0;
      String countyName;
      do
      {
         //Display Menu
         System.out.println("1. View all data");
         System.out.println("2. Search by county");
         System.out.println("3. Search by county with highest cases");
         System.out.println("4. Calculate average age");
         System.out.println("5. Find % number of males and females by county");
         System.out.println("6. Write all details of the county with the lowest number of cases to file");
         System.out.println("0. Exit System"); 
         System.out.print("Enter your option");
         option = keyboardIn.nextInt();
        
         switch(option)
         {
            case 1:
           
            viewCovid(covidList);//Pass contents of ArrayList to method
            break;
            case 2:
            //Enter county
            keyboardIn.nextLine();
            System.out.print("Enter County:");
            countyName = keyboardIn.nextLine();
            viewCounty(covidList, countyName);//Passing 2 values
            break;
            case 3:
            String county;
            keyboardIn.nextLine();
            System.out.print("Show county with highest cases:");
            highestCases(covidList);
            break;
            case 4:
            //calculate average age
            int averageAge;
            averageAge(covidList);
            break;
            case 5:
            System.out.println("What county");
            countyName = keyboardIn.nextLine();
            searchCounty(covidList, countyName, males, females);
            break;
            case 6:
            lowestCases(covidList);
            break;
            case 0:
            System.exit(0);
            default:
            System.out.println("Invalid option");
         }
      
      }
      while(option != 0);
  }//close main method 
      //Methods
      //Option 1 Print All Covid Data
      public static void viewCovid(ArrayList<Covid> covidList) 
      {
         for(Covid cov: covidList)
         {
            System.out.println(covidList.toString() + "\n");
         }
      }   
    
      
      //option 2 Search for data by county 
      public static void viewCounty(ArrayList<Covid>covidList, String county)
      {
         boolean countyFound = false;
         for(int i = 0; i < covidList.size(); i++)
         {
            if(county.equalsIgnoreCase(covidList.get(i).getCountyName()))
            {
               System.out.println(covidList.get(i).toString());
               countyFound = true;
            }
         }
         if(countyFound == false)
         {
            System.out.println("No data for that county on file");
         }

      }
      
      //Option 3 Find county with highest cases
      public static void highestCases(ArrayList<Covid> covidList)
      {
         //Set variable highestCases to noCases held in 1st element of the ArrayList
         int highestCases = covidList.get(0).getNoCases();
         
         String county = " ";
         for(int i = 0; i < covidList.size(); i++)
         {
            if(covidList.get(i).getNoCases() > highestCases ) //Check if any other element of ArrayList has higher cases than the 1st element
            {
               highestCases = covidList.get(i).getNoCases();//Overwrite the variable if higher cases are found
               county = covidList.get(i).getCountyName();
            }
         }
         System.out.println("County " +county+ "  has the highest number of cases with a total of  "+highestCases);
      }
      
      //Option 4 average age
      public static void averageAge(ArrayList<Covid> covidList)
      {
         int medianAge=0, noCases=0;
         double avgAge = 0;
      
      for(int i = 0; i < covidList.size(); i++)
      {
         noCases++;
         medianAge++;
      }
          avgAge = medianAge/noCases;
          System.out.print("Average age is "+ avgAge);
         
   }

      //Option 5 
      //Search for percentage male and female cases by county
      public static void searchCounty(ArrayList<Covid> covidList, String countyName, int males, int females)
      {
         int noMales = 0;
         boolean countyFound = false;
         
         for(int i = 0; i < covidList.size(); i++)
         {
            if(countyName == covidList.get(i).getCountyName());
            if(countyName.equalsIgnoreCase(covidList.get(i).getCountyName()));
            {
               countyFound = true;
               System.out.println("for county  "+countyName+ " male cases: " +(covidList.get(i).getNoMales()));
               System.out.println("for county  "+countyName+ " female cases : "+(covidList.get(i).getNoFemales()));
            }
         }
         if(countyFound == false)
         {
            System.out.println("That county is not on file");
         }
           
   }
      //option 6 write county with the lowest cases to file
      //find county with lowest cases
      public static void lowestCases(ArrayList<Covid> covidList) throws IOException
      {
         FileWriter fw = new FileWriter("LowestCases.txt");
         PrintWriter pw = new PrintWriter(fw);
     
         //set variable lowCases to cases
         int lowCases = covidList.get(0).getNoCases();
         String county = " ";
      
         for(int i = 0; i <covidList.size(); i++)
         {
            if(covidList.get(i).getNoCases() < lowCases)
            {
               lowCases = covidList.get(i).getNoCases();
               county = covidList.get(i).getCountyName();
               pw.print(county);
               fw.close();
            }
         }
     
         System.out.println("New file successfully created.The county with the lowest cases is "+county+ " with case total of : "+lowCases);
      }
} //close class    
      
    