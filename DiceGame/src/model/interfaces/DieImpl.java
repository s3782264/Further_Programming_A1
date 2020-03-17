package model.interfaces;

public class DieImpl implements Die
{
	private int number;
	private int value;
	private int numFaces;
	public static final int NUM_FACES = 6;

	public DieImpl(int number, int value, int numFaces) throws IllegalArgumentException
	{
		this.number = checkNumber(number);
		this.numFaces = checkNumFaces(numFaces);
		this.value = checkValue(value, numFaces);
	}
	
	public int checkNumber(int number)
	{
		if(number != 1 || number != 2)
		{
			return 0;
		}
		return number;
	}
	
	public int checkNumFaces(int numFaces)
	{
		if(numFaces != NUM_FACES)
		{
			return 0;
		}
		return numFaces;
	}
	
	public int checkValue(int value, int numFaces)
	{
		if(value <= 1 && value >= NUM_FACES)
		{
			return 0;
		}
		return value;
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
		return hashCode();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-20s %s\n", "Face Value:", convertValue(this.value)));
		return sb.toString();
	}
	
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
