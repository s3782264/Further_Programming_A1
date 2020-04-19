package testPackage;

import model.DieImpl;
import model.interfaces.Die;
/**
 * 
 * Test class to test full functionality of DieImpl 
 * 
 * @author Angela Alviano
 * 
 */
public class TestDieImpl 
{
	public void run()
	{
		try {
			/*
			 * Creating a die object
			 */
			Die die1 = new DieImpl(1, 3, 6);
			Die die2 = new DieImpl(2,3,6);
			/*
			 * Testing return methods using die1
			 */
			System.out.println(die1.toString());
			System.out.println(die1.getNumber());
			System.out.println(die1.getNumFaces());
			System.out.println(die1.getValue());
			System.out.println(die1.hashCode());
	
			/*
			 * Checking if both dies created are equal
			 */
			System.out.println(die1.equals(die2));
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
