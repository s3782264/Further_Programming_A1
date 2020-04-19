package client;

import testPackage.TestDieImpl;
import testPackage.TestDiePairImpl;
import testPackage.TestGameEngineImpl;
import testPackage.TestSimplePlayer;
/**
 * 
 * Simple test console client for FP assignment 1, 2020 to demonstrate
 * full functionality of implemented classes.
 * 
 * @author Angela Alviano
 * 
 */
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
		
		System.out.printf("\n TESTING GAMEENGINEIMPL AND GAMEENGINECALLBACKIMPL");
		TestGameEngineImpl gameEngineTest = new TestGameEngineImpl();
		gameEngineTest.run();
	}

}
