package testPackage;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class TestGameEngine 
{
	public static void main(String args[])
	{
		GameEngine g = new GameEngineImpl();
		
		Player p = new SimplePlayer("123", "Angela", 0);
		Player d = new SimplePlayer("678", "Anthony", 0);

		g.addPlayer(p);
		g.addPlayer(d);
		g.placeBet(p, 5);
		
		System.out.println(p.getBet());
	}
}
