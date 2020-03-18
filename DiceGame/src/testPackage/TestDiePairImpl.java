package testPackage;

import model.interfaces.DicePairImpl;

public class TestDiePairImpl 
{
	   public static void main(String args[])
	   {
		   DicePairImpl dicePair = new DicePairImpl();
		   DicePairImpl dicePair2 = new DicePairImpl();

		   dicePair.getTotal();
		   
		   dicePair.equals(dicePair2);
		   System.out.println(dicePair.toString());
		   System.out.println(dicePair.equals(dicePair2));
		   
		   System.out.println(dicePair.hashCode());
		   
		   
	   }

}
