package pokermodel;

public class Player 
{
  private int myNumberOfWins;

  private String myName;

  private PokerHand myHand;
  
  /**
   * The Player class keeps track of the player's name,
   * score, and current hand.
   * @author Bryan Pearson
   */

  /**
   * Constructor initializes the player
   * @param name the player's name
   * @author Bryan Pearson
   */
  public Player(String name) 
  {
	  myName = name;
	  myNumberOfWins = 0;
  }

  /**
   * Check if the name is valid. If the name 
   * is blank or exceeds 10 characters, it is 
   * invalid.
   * @return true if valid, false if invalid
   * @author Bryan Pearson
   */
  public boolean isValidName() 
  {
	  if(myName.length() == 0 || myName.length() > 10)
	  {
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  }

  /**
   * Increment the score by 1.
   * @return the new score
   * @author Bryan Pearson
   */
  public int incrementScore() 
  {
	  myNumberOfWins++;
	  return myNumberOfWins;
  }

  /**
   * Print a string representation of the class
   * @author Bryan Pearson
   */
  public String toString() 
  {
	  return "Player name: " + myName + "\nCurrent score: " + myNumberOfWins;
  }
  	
    /*
     * *********************
     * ACCESSORS & MUTATORS
     * *********************
     */
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
	
	public void setHand(PokerHand hand)
	{
		myHand = hand;
	}
}