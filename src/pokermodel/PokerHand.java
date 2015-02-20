package pokermodel;

public class PokerHand extends Hand 
{

  private PokerHandRanking myRank;

  public PokerHand(int maxCards) 
  {
	  super(maxCards);
  }

  public boolean isHighCard() 
  {
	  return false;
  }

  public boolean isPair() 
  {
	  return false;
  }

  public boolean isTwoPair() 
  {
	  return false;
  }

  public boolean isThreeOfKind() 
  {
	  return false;
  }

  public boolean isStraight() 
  {
	  return false;
  }

  public boolean isFlush() 
  {
	  return false;
  }

  public boolean isFullHouse() 
  {
	  return false;
  }

  public boolean isFourOfKind() 
  {
	  return false;
  }

  public boolean isStraightFlush() 
  {
	  return false;
  }

  public boolean isRoyalFlush() 
  {
	  return false;
  }

  public String toString() 
  {
	  return null;
  }

  public int compareTo(PokerHand hand) 
  {
	  return 0;
  }

  public int determineRank() 
  {
	  return 0;
  }

  public int discard() 
  {
	  return 0;
  }

}