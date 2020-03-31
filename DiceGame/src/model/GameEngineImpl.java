package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine
{

	private ArrayList<Player> players = new ArrayList<Player>();	
	
	@Override
	public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyWinLoss(Player player, DicePair houseResult) 
	{
		// TODO Auto-generated method stub
		
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
				if(checkPlayerID(player)== false)
				{
					players.add(player);
				}
			}
		}

	}
	
	public boolean checkPlayerID(Player player)
	{
		if(players!= null)
		{
			for(int i =0; i < players.size(); i++)
			{
				if(players.get(i).getPlayerId().equals(player.getPlayerId()))
				{
					return true;
				}
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
				if(checkPlayerID(player) == true)
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
				if(checkPlayerID(player)== true)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		return players;
	}

}
