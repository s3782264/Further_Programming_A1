package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
	private String playerId, playerName;
	private int initialPoints, bet, points, result;
	private DicePair dicePair;
	
	/*
	 * Constructor to create a SimplePlayer
	 */
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
		return points+initialPoints;
	}

	@Override
	public void setPoints(int points) 
	{
		this.points+= points;
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
		sb.append(String.format("%s %s, ", "Player: id=", getPlayerId()));
		sb.append(String.format("%s %s, ", "name=", getPlayerName()));
		sb.append(String.format("%s %s, ", "bet=", getBet()));
		sb.append(String.format("%s %s, ", "points=", getPoints()));
		sb.append(String.format("%s %s", "RESULT..", getResult()));

		return sb.toString();
	}

}
