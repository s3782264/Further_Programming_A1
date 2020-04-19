package testPackage;

import model.DicePairImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import model.interfaces.Player;

public class TestSimplePlayer 
{
	public void run()
	{
		Player player1 = new SimplePlayer("1", "The Roller", 5000);
		/*
		 * Setting results from a dicePair and then getting those results
		 */
		DicePair dicePair1 = new DicePairImpl();
		player1.setResult(dicePair1);
		System.out.println(player1.getResult());
		
		/*
		 * Testing return methods using player1
		 */
		System.out.println(player1.toString());
		System.out.println(player1.getPlayerId());
		System.out.println(player1.getPlayerName());
		System.out.println(player1.getPoints());
		System.out.println(player1.getBet());
		
		/*
		 * Setting a bet and then resetting the bet
		 */
		player1.setBet(100);
		System.out.println(player1.getBet());
		player1.resetBet();
		System.out.println(player1.getBet());
		
		/*
		 * Setting points 
		 */
		player1.setPoints(100);
		System.out.println(player1.getPoints());
		
		/*
		 * Setting playerName
		 */
		player1.setPlayerName("The New Roller");
		System.out.println(player1.getPlayerName());
	}
}
