package model;

import model.interfaces.Die;

/**
 * 
 * Implemented class of Die
 * 
 * @author Angela Alviano
 * 
 */
public class DieImpl implements Die
{
	private int number;
	private int value;
	private int numFaces;
	public static final int NUM_FACES = 6;

	/*
	 * Constructor to create a Die object
	 */
	public DieImpl(int number, int value, int numFaces) throws IllegalArgumentException
	{
		if(checkNumber(number) == false|| checkValue(value, numFaces) == false
				|| checkNumFaces(numFaces) == false)
		{
			throw new IllegalArgumentException("Please input appropriate values for the die.");
		}
		this.number = number;
		this.numFaces = numFaces;
		this.value = value;
	}
	
	/*
	 * A check method that returns false if number that is passed in does
	 * not equal to 1 and 2 otherwise returns true
	 */
	private boolean checkNumber(int number)
	{
		if(number != 1 && number != 2)
		{
			return false;
		}
		return true;
	}
	
	/*
	 * A check method that returns false if numFaces passed in does
	 * not equal to NUM_FACES otherwise returns true
	 */
	private boolean checkNumFaces(int numFaces)
	{
		if(numFaces != NUM_FACES)
		{
			return false;
		}
		return true;
	}
	
	/*
	 * A check method that returns false if the value if less than 1
	 * and if it greater than NUM_FACES otherwise returns true
	 */
	private boolean checkValue(int value, int numFaces)
	{
		if(value <= 1 && value >= NUM_FACES)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public int getNumber() 
	{
		return number;
	}

	@Override
	public int getValue() 
	{
		return value;
	}

	@Override
	public int getNumFaces() 
	{
		return numFaces;
	}

	@Override
	public boolean equals(Die die) 
	{
		if(die.getValue() == value)
		{
			if(die.getNumFaces() == numFaces)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean equals(Object die)
	{
		if(((DieImpl) die).getValue() == value)
		{
			if(((DieImpl) die).getNumFaces() == numFaces)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int hash = 17;
		hash = 31 * hash + value;
		hash = 31 * hash + numFaces;
		return hash;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s %s", "Face Value:", convertValue(this.value)));
		return sb.toString();
	}
	
	/*
	 * A method that converts and int value from 1-9 into a string and
	 * returns that string
	 */
	public String convertValue(int value)
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
	
}
