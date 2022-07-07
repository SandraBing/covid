/*Covid Cases*/

/*Covid class to record daily covid case numbers */
import java.io.Serializable;

public class Covid implements Serializable

{
   private String countyName, county;
   private int noCases;
   private int noMales;
   private int noFemales;
   private int medianAge;
   private int lowCases;
   //Constructors
   //Constructor 1 - User defined default
   public Covid()
   {
      countyName = " ";
      noCases = 0;
      noMales = 0;
      noFemales = 0;
      medianAge = 0;
      lowCases = 0;
   }
   
   //Constructor 2 - Parameter defined constructor
   public Covid(String county, int cases, int males, int females, int age) 
   {
      countyName = county;
      noCases = cases;
      noMales = males;
      noFemales = females;
      medianAge = age;
   }
   
   //Methods
   public String toString()
   {
      return "County:"+countyName+ " Cases: "+noCases+ " males: "+noMales+ " Females: "+noFemales+
      " Age:" +medianAge;
   }
   //Set methods Mutator methods
   public void setCountyName(String county)
   {
      countyName = county;
   }
   public void setNoCases(int cases)
   {
      noCases = cases;
   }
   public void setNoMales(int males)
   {
      noMales = males;
   }
   public void setNoFemales(int females)
   {
      noFemales = females;
   }
   public void setAge(int age)
   {
      medianAge = age;
   }
   //Accessor methods
   public String getCountyName()
   {
      return countyName;
   }
   public int getNoCases()
   {
      return noCases;
   }
   public int getNoMales()
   {
      return noMales;
   }
   public int getNoFemales()
   {
      return noFemales;
   }
   public int getAge()
   {
      return medianAge;
   }
   public int getHighestCases()
   {
      return noCases;
   }
}
