package testPackage;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;

public class TestGameEngineImpl 
{
	public static void main(String args[])
	{
		GameEngine g = new GameEngineImpl();

		Player p1 = new SimplePlayer("1", "The Roller", 5000);
		Player p2 = new SimplePlayer("2", "The Loser", 500);
		/*
		 * Adding a callback object
		 */
		g.addGameEngineCallback(new GameEngineCallbackImpl());
		/*
		 * Adding players to the gameEngine and then getting those players
		 */
		g.addPlayer(p1);
		g.addPlayer(p2);
		System.out.println(g.getPlayer("1"));
		System.out.println(g.getPlayer("2"));
		
		/*
		 * Players placing bets
		 */
		g.placeBet(p1, 100);
		System.out.println(p1.getBet());
		
		g.placeBet(p2, 250);
		System.out.println(p2.getBet());
		
		/*
		 * Player and house rolling 
		 * This tests GameEngineCallback as well as applyWinLoss method
		 */
		g.rollPlayer(p1, 100, 1000, 100, 50, 500, 50);
		g.rollPlayer(p2, 100, 1000, 100, 50, 500, 50);
		g.rollHouse(100, 1000, 200, 50, 500, 25);
		
		/*
		 * Removing p1
		 */
		g.removePlayer(p1);
		System.out.println(g.getAllPlayers());
	}
}
