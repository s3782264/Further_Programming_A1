package view;

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
   private static final Logger PARENT_LOGGER = Logger.getLogger("");
   
   public GameEngineCallbackImpl()
   {
      // FINE shows rolling output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE, String.format("%s %s %s %s %s %s", "", " die ", " rolled to ", 
    		  player.getPlayerName(), die.getNumber(), convertValue(die.getValue())));
      // TODO: complete this method to log results
   }

   @Override
   public void playerResult(Player player, DicePair result, GameEngine gameEngine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
      // TODO: complete this method to log results
   }

	@Override
	public void houseDieUpdate(Die die, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
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
