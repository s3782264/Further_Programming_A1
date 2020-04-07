package view;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());
   //private ArrayList<Player> players = new ArrayList();
   
   public GameEngineCallbackImpl()
   {
      // FINE shows rolling output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
   {
      // intermediate results logged at Level.FINE
     logger.log(Level.INFO, String.format("%s die %d rolled to %s" , player.getPlayerName(), die.getNumber(), convertValue(die.getValue())));
      // TODO: complete this method to log results
   }

   @Override
   public void playerResult(Player player, DicePair result, GameEngine gameEngine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, String.format("%s *RESULT* %s" , player.getPlayerName(), result.toString()));
      
      // TODO: complete this method to log results
   }

	@Override
	public void houseDieUpdate(Die die, GameEngine gameEngine) 
	{
	     logger.log(Level.INFO, String.format("The House die %d rolled to %s" , die.getNumber(), convertValue(die.getValue())));
	}
	
	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{
		logger.log(Level.INFO, String.format("The House *RESULT* %s" , result.toString()));
		for(Player player : gameEngine.getAllPlayers())
		{
			logger.log(Level.INFO, String.format("%s", player.toString()));
		}
	}
	
	private String convertValue(int value)
	{
		String name = "";
		if(value == 1)
		{
			name = "One";
		}
		else if(value == 2)
		{
			name = "Two";
		}
		else if(value == 3)
		{
			name = "Three";
		}
		else if(value == 4)
		{
			name = "Four";
		}
		else if(value == 5)
		{
			name = "Five";
		}
		else if(value == 6)
		{
			name = "Six";
		}
		else if(value == 7)
		{
			name = "Seven";
		}
		else if(value == 8)
		{
			name = "Eight";
		}
		else if(value == 9)
		{
			name = "Nine";
		}
		else if(value > 9)
		{
			name = "> Nine";
		}
		return name;
	}
   // TODO implement rest of interface
}
