package model;

import java.util.ArrayList;
import java.util.Collection;

import client.SimpleTestClient;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine
{

	private ArrayList<Player> players = new ArrayList<Player>();
	private GameEngineCallback gameEngineCallback;
	private DicePair dicePairHouse, dicePair;
	private Player player;
	@Override
	public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2)
	{
		this.player = player;
		parameterCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		
		for(int i = initialDelay1; i <= finalDelay1; i = i+delayIncrement1)
		{
			dicePair = new DicePairImpl();
			gameEngineCallback.playerDieUpdate(player, dicePair.getDie1(), this);
			gameEngineCallback.playerDieUpdate(player, dicePair.getDie2(), this);
		}
		player.setResult(dicePair);
		gameEngineCallback.playerResult(player, dicePair, this);
	}

	/*
	 * A check method used for rollplayer and rollhouse if the check fails throw an exception
	 */
	private void parameterCheck(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2)
	{
		if(initialDelay1 < 0 || initialDelay2 < 0 || finalDelay1 < 0 || finalDelay2 < 0 || delayIncrement1 < 0 
				|| delayIncrement2 < 0 || finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2
				|| delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2))
		{
			throw new IllegalArgumentException("Parameters are incorrect");
		}
	}
	
	@Override
	public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) 
	{
		parameterCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);

		for(int i = initialDelay1; i <= finalDelay1; i = i+delayIncrement1)
		{
			dicePairHouse = new DicePairImpl();
			gameEngineCallback.houseDieUpdate(dicePair.getDie1(), this);
			gameEngineCallback.houseDieUpdate(dicePair.getDie2(), this);
		}
		for(Player player : players)
		{
			applyWinLoss(player, dicePairHouse);
		}
		gameEngineCallback.houseResult(dicePairHouse, this);
		for(Player player : players)
		{
			player.resetBet();
		}
	}

	@Override
	public void applyWinLoss(Player player, DicePair houseResult) 
	{
		if(player.getResult().getTotal() > houseResult.getTotal())
		{
			player.setPoints(player.getBet()); 
		}
		else
		{
			player.setPoints(-player.getBet());
		}
	}

	@Override
	public void addPlayer(Player player) 
	{
		if(players.size() == 0)
		{
			players.add(player);
		}
		else if(players.size() > 0)
		{
			for(int i =0; i < players.size(); i++)
			{
				if(checkPlayerID(player, i)== false)
				{
					players.add(player);
				}
			}
		}
	}
	
	/*
	 * Method to check player id
	 */
	private boolean checkPlayerID(Player player, int i)
	{
		if(players!= null)
		{
			if(players.get(i).getPlayerId().equals(player.getPlayerId()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Player getPlayer(String id) 
	{
		if(players!=null)
		{
			for(int i = 0; i < players.size(); i++)
			{
				if(players.get(i).getPlayerId().equals(id))
				{
					return players.get(i);
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean removePlayer(Player player) 
	{
		if(players!= null)
		{
			for(int i = 0; i < players.size(); i++)
			{
				if(checkPlayerID(player, i) == true)
				{
					players.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean placeBet(Player player, int bet) 
	{
		if(players!= null)
		{
			for(int i = 0; i < players.size(); i++)
			{
				if(checkPlayerID(player, i)== true)
				{
					players.get(i).setBet(bet);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		this.gameEngineCallback = gameEngineCallback;
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		if(this.gameEngineCallback != null)
		{
			this.gameEngineCallback = null;
			return true;
		}
		else if(this.gameEngineCallback == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		return players;
	}

}
