package model;

import model.interfaces.DicePair;
import model.interfaces.Die;

public class DicePairImpl implements DicePair
{
	private int numFaces = 6, value1, value2, total;
	private Die die1, die2;
	
	/*
	 * A non parameter constructor that generates two Die objects
	 */
	public DicePairImpl()
	{
		value1 = getRandomValue();
		value2 = getRandomValue();
		die1 = new DieImpl(1, value1, numFaces);
		die2 = new DieImpl(2, value2, numFaces);
	}
	
	/*
	 * Method to generate random int values from 1 to numFaces
	 */
	private int getRandomValue()
	{
		int value = (int) (Math.random() *(numFaces - 1) + 1);
		return value;
	}
	
	@Override
	public Die getDie1() 
	{
		return die1;
	}

	@Override
	public Die getDie2() 
	{
		return die2;
	}

	@Override
	public int getTotal() 
	{
		this.total = die1.getValue() + die2.getValue();
		return this.total;
	}

	@Override
	public boolean equals(DicePair dicePair) 
	{
		if(dicePair.getDie1().getValue() == value1)
		{
			if(dicePair.getDie2().getValue() == value2)
			{
				return true;
			}

		}
		return false;
	}
	
	@Override
	public boolean equals(Object dicePair)
	{
		if(((DicePairImpl) dicePair).getDie1().getValue() == value1)
		{
			if(((DicePairImpl) dicePair).getDie2().getValue() == value2)
			{
				return true;
			}

		}
		return false;
	}

	@Override
	public int compareTo(DicePair dicePair) 
	{
		if(total < dicePair.getTotal())
		{
			return -1;
		}
		else if(total < dicePair.getTotal())
		{
			return 0;
		}
		else if(total > dicePair.getTotal())
		{
			return 1;
		}
		return total;
	}
	
	@Override
	public int hashCode()
	{
		int hash = 17;
		hash = 31 * hash + value1;
		hash = 31 * hash + value2;
		hash = 31 * hash + numFaces;
		return hash;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s %s, ", "Dice 1:", ((DieImpl) die1).convertValue(die1.getValue())));
		sb.append(String.format("%s %s .. ", "Dice 2:", ((DieImpl) die2).convertValue(die2.getValue())));
		sb.append(String.format("%s %s ", "Total:", getTotal()));
		return sb.toString();
	}
}
