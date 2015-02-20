package pokermodel;

import java.util.Vector;

public class Hand 
{

  private int myMaxNumberCards;

  private Vector<Card> myCards;

  public Hand(int maxCards) 
  {
  }

  public int discard() 
  {
	  return 0;
  }

  public boolean addCard(Card card) 
  {
	  return false;
  }

  public Vector<Card> getCards()
  {
	  return myCards;
  }
  
  public int getMaxNumberCards()
  {
	  return myMaxNumberCards;
  }

}