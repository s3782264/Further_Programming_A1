package testPackage;

import model.DicePairImpl;
import model.interfaces.DicePair;

public class TestDiePairImpl 
{
	   public void run()
	   {
		   /*
		    * Creating two DicePair objects
		    */
		   DicePair dicePair1 = new DicePairImpl();
		   DicePair dicePair2 = new DicePairImpl();

		   /*
		    * Testing the return methods using dicePair1
		    */
		   System.out.println(dicePair1.getDie1());
		   System.out.println(dicePair1.getDie2());
		   System.out.println(dicePair1.getTotal());
		   System.out.println(dicePair1.hashCode());
		   /*
		    * Testing the return methods using dicePair2
		    */
		   System.out.println(dicePair2.getDie1());
		   System.out.println(dicePair2.getDie2());
		   System.out.println(dicePair2.getTotal());
		   System.out.println(dicePair2.hashCode());
		   
		   /*
		    * Comparing both dicePair objects
		    */
		   System.out.println(dicePair1.compareTo(dicePair2));
		   
		   /*
		    * Checking if the dicePair objects are equal
		    */
		   System.out.println(dicePair1.equals(dicePair2));
	   }

}
