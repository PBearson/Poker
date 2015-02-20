package pokermodel;

public class Player 
{
  private int myNumberOfWins;

  private String myName;

  private PokerHand myHand;

  public Player(String name) 
  {
	  myName = name;
  }

  public boolean isValidName() 
  {
	  return false;
  }

  public int incrementScore() 
  {
	  return 0;
  }

  public String toString() 
  {
	  return null;
  }

	public String getName() 
	{
		return myName;
	}
	
	public void setName(String name) 
	{
		myName = name;
	}
	
	public int getNumberOfWins()
	{
		return myNumberOfWins;
	}
	
	public PokerHand getHand() 
	{
		return myHand;
	}
}