package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
	private String playerId, playerName;
	private int initialPoints, bet, points, result;
	private DicePair dicePair;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints) throws IllegalArgumentException 
	{
		this.initialPoints = initialPoints;
		this.playerId = playerId;
		this.playerName = playerName;
	}
	
	@Override
	public String getPlayerName() 
	{
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}

	@Override
	public int getPoints() 
	{
		return points;
	}

	@Override
	public void setPoints(int points) 
	{
		this.points = points + this.initialPoints;
	}

	@Override
	public String getPlayerId() 
	{
		return playerId;
	}

	@Override
	public boolean setBet(int bet) 
	{
		if(bet > 0)
		{
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() 
	{
		return bet;
	}

	@Override
	public void resetBet() 
	{
		this.bet = 0;
	}

	@Override
	public DicePair getResult() 
	{
		return this.dicePair;
	}

	@Override
	public void setResult(DicePair rollResult) 
	{
		this.dicePair = rollResult;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s %s, ", "Player: id=", playerId));
		sb.append(String.format("%s %s, ", "name=", playerName));
		sb.append(String.format("%s %s, ", "bet=", bet));
		sb.append(String.format("%s %s, ", "points=", points));
		sb.append(String.format("%s %s", "RESULTS.. Dice 1:", result));

		return sb.toString();
	}

}
