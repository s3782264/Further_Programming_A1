package client;

import testPackage.TestDieImpl;
import testPackage.TestDiePairImpl;
import testPackage.TestSimplePlayer;

public class MyTestlClient {

	public static void main(String[] args) 
	{
		System.out.println("TESTING DIEIMPL");
		TestDieImpl dieTest = new TestDieImpl();
		dieTest.run();
		
		System.out.printf("\nTESTING DICEPAIRIMPL\n");
		TestDiePairImpl dicePairTest = new TestDiePairImpl();
		dicePairTest.run();
		
		System.out.printf("\nTESTING SIMPLEPLAYER\n");
		TestSimplePlayer simplePlayerTest = new TestSimplePlayer();
		simplePlayerTest.run();
	}

}
