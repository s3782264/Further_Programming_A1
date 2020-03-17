package model.interfaces;

public class DicePairImpl implements DicePair
{
	private int numFaces = 6;
	
	public DicePairImpl()
	{
		DieImpl die1 = new DieImpl(1, getRandomValue(), numFaces);
		DieImpl die2 = new DieImpl(2, getRandomValue(), numFaces);
	}
	
	public int getRandomValue()
	{
		int value = (int) (Math.random() *(numFaces - 1) + 1);
		return value;
	}
	@Override
	public Die getDie1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Die getDie2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(DicePair dicePair) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(DicePair dicePair) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
