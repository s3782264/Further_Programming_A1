package model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Implemented class of GameEngine
 * 
 * @author Angela Alviano
 * 
 */
public class GameEngineImpl implements GameEngine
{

	private final Map<String, Player> players = new HashMap<>();
	private Collection<GameEngineCallback> callbacks = new HashSet<>();
	private DicePair dicePairHouse, dicePair;
	@Override
	public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2)
	{
		parameterCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		int currentDelay = initialDelay1;
		while(currentDelay < finalDelay1)
		{
			for(GameEngineCallback cb : callbacks)
			{	
				dicePair = new DicePairImpl();
				cb.playerDieUpdate(player, dicePair.getDie1(), this);
				cb.playerDieUpdate(player, dicePair.getDie2(), this);
				doDelay(currentDelay);
			}
			currentDelay += delayIncrement1;
		}
		player.setResult(dicePair);
		for(GameEngineCallback cb : callbacks)
		{
			cb.playerResult(player, dicePair, this);

		}
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
	
	private void doDelay(int delay)
	{
		try
		{
			Thread.sleep(delay);
		}
		catch(InterruptedException e)
		{
			e.getMessage();
		}
	}
	
	@Override
	public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) 
	{
		parameterCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);

		int currentDelay = initialDelay1;
		while(currentDelay < finalDelay1)
		{
			for(GameEngineCallback cb : callbacks)
			{	
				dicePairHouse = new DicePairImpl();
				cb.houseDieUpdate(dicePair.getDie1(), this);
				cb.houseDieUpdate(dicePair.getDie2(), this);
				doDelay(currentDelay);
			}
			currentDelay += delayIncrement1;
		}
		for(Player player : players.values())
		{
			applyWinLoss(player, dicePairHouse);
		}
		for(GameEngineCallback cb : callbacks)
		{
			cb.houseResult(dicePairHouse, this);
		}
		for(Player player : players.values())
		{
			player.resetBet();
		}
	}

	@Override
	public void applyWinLoss(Player player, DicePair houseResult) 
	{
		int points;
		if(player.getResult().getTotal() > houseResult.getTotal())
		{
			points = player.getPoints()+ player.getBet();
			player.setPoints(points); 
		}
		else
		{
			points = (player.getPoints()-player.getBet());
			player.setPoints(points);
		}
	}

	@Override
	public void addPlayer(Player player) 
	{
		players.put(player.getPlayerId(), player);
	}
	
	@Override
	public Player getPlayer(String id) 
	{
		return players.get(id);
	}
	
	@Override
	public boolean removePlayer(Player player) 
	{
		return players.remove(player.getPlayerId())!=null;
	}

	@Override
	public boolean placeBet(Player player, int bet) 
	{
		return players.get(player.getPlayerId()).setBet(bet);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		callbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		return callbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		return Collections.unmodifiableCollection(players.values());
	}

}
