package testPackage;

import model.DieImpl;

public class TestDieImpl 
{
	   public static void main(String args[])
	   {
		   try {
		   DieImpl die = new DieImpl(1, 3, 6);
		   
		   //DieImpl die2 = new DieImpl(2,3,6);
		   
		   System.out.println(die.toString());
		   System.out.println(die.getNumber());
		   System.out.println(die.getNumFaces());
		   System.out.println(die.getValue());
		   //System.out.println(die.equals(die2));
		   System.out.println(die.hashCode());
		  //System.out.println(die2.hashCode());
		   }catch(IllegalArgumentException e)
		   {
			   System.out.println(e.getMessage());
		   }
	   }

}
